package infrastructure;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.List;

public class HandleFiles {

    //Atributos
    private final static String RUTA_DATA_BASE = "src/main/java/dataBase_DataSet/";
    private final static String RUTA_TRAINNER = "src/main/java/dataBase_Trainings/";

    
    
    //Crear nuevo archivo y retornarlo
    public static File newFile(String fileName) throws IOException {
        
        PrintWriter salida = null;

        try {
            File archivo = new File(RUTA_DATA_BASE + fileName);
            salida = new PrintWriter(archivo);
            System.out.println("Archivo creado correctamente: " + fileName); // Usar println para nueva línea
            return archivo;
            
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage()); // Imprime el mensaje de error
            throw e; // lanza la excepción para que el que use el metodo sepa que falló
        
        } finally {
            if (salida != null) {
                salida.close(); // Cierra el PrintWriter en el bloque finally
            }
        }
    }
    
    
    //Escribir en archivo
    public static void writerFiles(String fileName, String contenido) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_DATA_BASE + fileName, true))) {
            writer.write(contenido);
            writer.newLine();
            System.out.println("Archivo escrito correctamente: " + fileName);
        
        } catch (IOException ex) {
            IOException e = new IOException(contenido);
            System.err.println("Error al escribir en el archivo: " + ex.getMessage());
            throw e;
        }
    }

    
    //leer archvivo y devolver un ArrayList con cada linea del archivo
    public static ArrayList<String> readFiles(String fileName) throws Exception {

        /* Lee el archivo y lo guarda en una lista para luego devolverlo como un ArrayList.
       Devuelve un ArrayList vacío si no pudo leer nada. */
        
        ArrayList<String> lineas = new ArrayList<>();
        
        try {
            List<String> contenido = Files.readAllLines(Paths.get(RUTA_DATA_BASE + fileName));
            lineas.addAll(contenido);
        
        } catch (NoSuchFileException ex) {
            System.err.println("El archivo " + RUTA_DATA_BASE + fileName + " no existe");
            throw ex;
        
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + RUTA_DATA_BASE + fileName + ex.getMessage());
            throw ex;
        }
        return lineas;
    }
    
    
    //Eliminar archivo
    public static void deleteFiles(String fileName) throws IOException {
        
        try {
            Path archivo = Paths.get(RUTA_DATA_BASE + fileName);
            Files.delete(archivo);
            System.out.println("Archivo eliminado correctamente: " + RUTA_DATA_BASE + fileName);

        } catch (IOException ex) {
            System.err.println("Error al eliminar el archivo: " + RUTA_DATA_BASE + ex.getMessage());
            throw ex;
        }
    }

    
    //Copir archivo
    public static void copyFile(String sourcePath) {
        
        Path source = Paths.get(sourcePath);
        Path target = Paths.get(RUTA_DATA_BASE + source.getFileName());

        try {
            Files.copy(source, target, REPLACE_EXISTING);
            System.out.println("Archivo copiado exitosamente");
        
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al copiar el archivo: ");
        }
    }

    
    //Guardar dos objetos en un fichero binario
    public static void saveObjectsToBinaryFile(Object objeto1, Object objeto2, String fileName) throws IOException {
        
        try (FileOutputStream fileOut = new FileOutputStream(RUTA_TRAINNER + fileName); ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(objeto1);
            objectOut.writeObject(objeto2);
            System.out.println("Objetos guardado correctamente en: " + RUTA_TRAINNER + fileName);
        
        } catch (IOException e) {
            System.err.println("Error al guardar los objetos en el archivo: " + e.getMessage());
            throw e;
        }
    }

    
    //Leer objetos guardados en un fichero binario
    public static Object[] readObjectsFromBinaryFile(String fileName) throws IOException, ClassNotFoundException {
        
        Object[] objects = new Object[2];
        
        try (FileInputStream fileIn = new FileInputStream(RUTA_TRAINNER + fileName); ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            objects[0] = objectIn.readObject();
            objects[1] = objectIn.readObject();
            return objects;

        } catch (IOException e) {
            System.err.println("Error al leer los objetos del archivo: " + e.getMessage());
            throw e;
        
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
            throw e;
        }
    }
}
