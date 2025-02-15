package infrastructure;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import back_end.Validator;
import java.util.List;
import neuralNetwork.NeuralNetwork;

public class HandleFiles {
    
final static String RUTA_DATA_BASE = "D:/Documents/GitHub/Clasificar_Flores_Iris/Clasificar_Flores_Iris/src/main/java/dataBase/";
final static String RUTA_TRAINNER = "D:/Documents/GitHub/Clasificar_Flores_Iris/Clasificar_Flores_Iris/src/test/java/";
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
    
    
    public static void writerFiles(String fileName, String contenido)throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(contenido);
            System.out.println("Archivo escrito correctamente: " + fileName);
        } catch (IOException ex) {
            IOException e = new IOException(contenido);
            System.err.println("Error al escribir en el archivo: " + ex.getMessage());
            throw e;
        }
    }
    

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

    
    public static void saveObjectToBinaryFile(Object objeto, String fileName) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(RUTA_TRAINNER + fileName);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(objeto);
        System.out.println("Objeto guardado correctamente en: " + RUTA_TRAINNER + fileName);
    }
   
}
