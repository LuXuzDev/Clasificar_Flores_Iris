/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infrastructure;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Angel Hernandez
 */
public class DataBaseController {
    private static ArrayList<File> files;
    static String packagePath = "src/main/java/dataBase_DataSet";
    
    public DataBaseController()
    {
        files = new ArrayList<>();
        
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

    
    private static void updateFile(File file) {
        
        if (files!= null && !files.contains(file)) 
            files.add(file);
        
    }
    
    
    public void createFile(String directionURL) throws IOException
    {
        File file = HandleFiles.newFile(directionURL);
        files.add(file);   
        System.out.println("Archivo creado");
    }
}
