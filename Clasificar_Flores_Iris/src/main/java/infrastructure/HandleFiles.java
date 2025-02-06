package infrastructure;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import back_end.Validator;

public class HandleFiles {

    public static boolean crearArchivos(String nombreArchivo) {

        if (!Validator.isCorrectFile(nombreArchivo)) {
            System.err.println("El nombre del archivo no puede ser null o vacío");
            return false;
        }

        File archivo = new File(nombreArchivo);

        // Verificar si el archivo ya existe
        if (archivo.exists()) {
            System.out.println("El archivo " + nombreArchivo + "ya existe");
            return false;
        }

        /* Asegurar que se haya puesto una ruta para la creacion
        del archivo y en caso de que no exista dicha ruta se crea*/
        File directorio = archivo.getParentFile();
        if (directorio != null && !directorio.exists()) {
            directorio.mkdirs();
        }

        try (PrintWriter salida = new PrintWriter(archivo)) {
            System.out.println("Archivo creado correctamente: " + nombreArchivo);
            return true;

        } catch (FileNotFoundException ex) {
            System.err.println("Error al crear el archivo: " + ex.getMessage());
            return false;
        }
    }

    public static boolean escribirArchivos(String nombreArchivo, String contenido) {
        if (contenido == null) {
            System.err.println("El contenido no puede ser null");
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(contenido);
            System.out.println("Archivo escrito correctamente: " + nombreArchivo);
            return true;
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo: " + ex.getMessage());
            return false;
        }
    }

    public static String[] leerArchivos(String nombreArchivo) {

        /*lee el archivo y lo guarda en una lista para luego llevarlo a un arreglo
     devuelve un arreglo vacio si no pudo leer nada*/
        try {
            return Files.readAllLines(Paths.get(nombreArchivo)).toArray(new String[0]);
        } catch (NoSuchFileException ex) {
            System.err.println("El archivo " + nombreArchivo + " no existe");
            return new String[0];
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + ex.getMessage());
            return new String[0];
        }
    }

    public static boolean eliminarArchivos(String nombreArchivo) {
        try {
            Path archivo = Paths.get(nombreArchivo);
            if (!Files.exists(archivo)) {
                System.err.println("El archivo " + nombreArchivo + " no existe");
                return false;
            }

            Files.delete(archivo);
            System.out.println("Archivo eliminado correctamente: " + nombreArchivo);
            return true;
        } catch (IOException ex) {
            System.err.println("Error al eliminar el archivo: " + ex.getMessage());
            return false;
        }
    }
}
