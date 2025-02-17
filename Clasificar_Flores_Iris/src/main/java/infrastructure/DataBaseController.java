/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infrastructure;

import back_end.Validator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Angel Hernandez
 */
public class DataBaseController {
    private static ArrayList<File> files  = new ArrayList<>();;
    static String packagePath = "src/main/java/dataBase_DataSet";
    static String trainerPath ="src/main/java/dataBase_Trainings/";
    
    public DataBaseController()
    {

    }
    

    public static ArrayList<File> getFilesInPackage() {
        ArrayList<File> fileList = new ArrayList<>();
        File directory = new File(packagePath);

        if (directory.exists() && directory.isDirectory()) {
            File[] filesInPackage = directory.listFiles();
            if (filesInPackage != null) {
                for (File file : filesInPackage) {
                    if (file.isFile()) {
                        fileList.add(file);
                        updateFile(file);
                    }
                }
            }
        }
        else
            System.out.println("El directorio no existe");
        return fileList;
    }
    
        public static ArrayList<File> getTrainnersInPackage() {
        ArrayList<File> fileList = new ArrayList<>();
        File directory = new File(trainerPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] filesInPackage = directory.listFiles();
            if (filesInPackage != null) {
                for (File file : filesInPackage) {
                    if (file.isFile()) {
                        fileList.add(file);
                        updateFile(file);
                    }
                }
            }
        }
        else
            System.out.println("El directorio no existe");
        return fileList;
    }

    
    private static void updateFile(File file) {
        
        if (files!= null && !files.contains(file)) 
            files.add(file);
        
    }
    
    public static File findFile(String name) {
        int i = 0;

        boolean founded = false;
        File file = null;
        while (i < files.size() && !founded) {
            if (!files.get(i).getName().equals(name)) i++;
            else {
                founded = true;
                file = files.get(i);
            }
        }
        return file;
    }
    
    public static void createFile(String name) throws IOException {
        System.out.println("Creando archivo");
        File file = HandleFiles.newFile(name);
        files.add(file);
        System.out.println("Archivo creado " + file.getPath());
    }

    public static void deleteFile(String name) throws Exception {
        File file = findFile(name);
        Validator.existFile(file);
        HandleFiles.deleteFiles(name);
    }

    public static void loadFile(String path) {
        HandleFiles.copyFile(path);
    }

    public static ArrayList<String> fileContent(String name) throws Exception {
        File file = findFile(name);
        Validator.existFile(file);
        return HandleFiles.readFiles(name);
    }

    public static ArrayList<String> editFile(String line, String name) throws Exception {
        File file = findFile(name);
        Validator.existFile(file);
        HandleFiles.writerFiles(name, line);
        return HandleFiles.readFiles(name);
    }
}
