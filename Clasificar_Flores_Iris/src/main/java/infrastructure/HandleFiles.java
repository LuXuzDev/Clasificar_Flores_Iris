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

    
    public static void newFile(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        while (!Validator.isCorrectFile(nombreArchivo) || archivo.exists()) {

            if (!Validator.isCorrectFile(nombreArchivo)) {
                System.err.println("El nombre del archivo no puede ser null o vacío");
            }

            // Verificar si el archivo ya existe
            if (archivo.exists()) {
                System.out.println("El archivo " + nombreArchivo + "ya existe");
            }
        }

        /* Asegurar que se haya puesto una ruta para la creacion del archivo y en caso de que no exista dicha ruta se crea*/
        File directorio = archivo.getParentFile();
        if (directorio != null && !directorio.exists()) {
            directorio.mkdirs();
        }

        try (PrintWriter salida = new PrintWriter(archivo)) {
            System.out.print("Archivo creado correctamente: " + nombreArchivo);

        } catch (IOException e) {
            // Manejo de excepciones
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    
    public static void writerFiles(String nombreArchivo, String contenido) {

        while (contenido == null) {
            System.err.println("El contenido no puede ser null");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(contenido);
            System.out.println("Archivo escrito correctamente: " + nombreArchivo);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo: " + ex.getMessage());
        }
    }

    
    public static ArrayList<String>readFiles(String nombreArchivo){
        
        /* Lee el archivo y lo guarda en una lista para luego devolverlo como un ArrayList.
       Devuelve un ArrayList vacío si no pudo leer nada. */
        ArrayList<String> lineas = new ArrayList<>();
        try {
            List<String> contenido = Files.readAllLines(Paths.get(nombreArchivo));
            lineas.addAll(contenido);
        } catch (NoSuchFileException ex) {
            System.err.println("El archivo " + nombreArchivo + " no existe");
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + ex.getMessage());
        }
        return lineas;
    }

    
    //Este metodo elimina un archivo
    public static void deleteFiles(String nombreArchivo) {
        try {
            Path archivo = Paths.get(nombreArchivo);
            while (!Files.exists(archivo)) {
                if (!Files.exists(archivo)) {
                    System.err.println("El archivo " + nombreArchivo + " no existe");
                }
            }
            Files.delete(archivo);
            System.out.println("Archivo eliminado correctamente: " + nombreArchivo);

        } catch (IOException ex) {
            System.err.println("Error al eliminar el archivo: " + ex.getMessage());
        }
    }

    
    
    public static void saveObjectToBinaryFile(Object objeto, String nombreArchivo) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo); 
                
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(objeto);
            System.out.println("Objeto guardado correctamente en: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al guardar objeto: " + e.getMessage());
            throw e;
        }
    }

}
