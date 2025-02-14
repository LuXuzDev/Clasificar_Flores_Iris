/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back_end;


import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Angel Hernandez
 */
public class DataBaseTrainnerController {
    private static ArrayList<File> trainnigs;
    static String packagePath = "src/main/java/dataBase_Trainings";
    
    
    public DataBaseTrainnerController()
    {
        trainnigs = new ArrayList<>();
    }
    
  public static ArrayList<File> getFileOutputStreams(String directoryPath) {
        ArrayList<File> fileList = new ArrayList<>();
        File directory = new File(directoryPath);

       
        if (directory.exists() && directory.isDirectory()) { 
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {   
                    if (file.isFile() && file.getName().endsWith(".dat")) {
                        fileList.add(file);
                        updateFile(file);
                    }
                }
            }
        } else {
            System.out.println("El directorio no existe o no es un directorio válido.");
        }

        return fileList;
    }

    
    private static void updateFile(File file)
    {
        if(trainnigs.isEmpty())
            trainnigs.add(file);
        else if(!trainnigs.contains(file))
            trainnigs.add(file);
    }
}
