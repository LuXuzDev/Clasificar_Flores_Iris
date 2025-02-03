package infrastructure;

import java.io.*;

public class HandleFiles {

    public static void crearArchivos(String nombreArchivo) {

        File archivo = new File(nombreArchivo);

        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Archivo creado correctamente");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);

        }
    }

    public static void escribirArchivos(String nombreArchivo, String contenido) {

        File archivo = new File(nombreArchivo);

        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(contenido);
            salida.close();
            System.out.println("Archivo escrito correctamente");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);

        }
    }

    public static void leerArchivos(String nombreArchivo) {

        File archivo = new File(nombreArchivo);

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while (lectura != null) {
                System.out.println(lectura);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void eliminarArchivos(String nombreArchivo) {

        File archivo = new File(nombreArchivo);

        archivo.delete();
        System.out.println("Archivo eliminado correctamente");

    }
}
