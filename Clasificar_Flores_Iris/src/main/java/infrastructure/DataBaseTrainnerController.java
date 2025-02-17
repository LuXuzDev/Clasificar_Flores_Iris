/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infrastructure;


import back_end.TrainerResults;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import neuralNetwork.NeuralNetwork;

/**
 *
 * @author Angel Hernandez
 */
public class DataBaseTrainnerController {
    private static ArrayList<File> trainnigs;
    static String packagePath = "src/main/java/dataBase_Trainings";
    
    
    public DataBaseTrainnerController() {
        trainnigs = new ArrayList<>();
    }

    public static ArrayList<File> getFileOutputStreams() {
        ArrayList<File> fileList = new ArrayList<>();
        File directory = new File(packagePath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".data")) {
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

    
    private static void updateFile(File file) {
        if (trainnigs.isEmpty()) {
            trainnigs.add(file);
        } else if (!trainnigs.contains(file)) {
            trainnigs.add(file);
        }
    }
    
    
    public void saveTrain(NeuralNetwork neuralNetwork,TrainerResults trainnerResults,String name) throws IOException
    {
        HandleFiles.saveObjectsToBinaryFile(neuralNetwork, trainnerResults, name);
    }
    
    
    public NeuralNetwork getBinaryNeuralNetwork(String name) throws IOException, ClassNotFoundException
    {
        Object[] binaryFile = HandleFiles.readObjectsFromBinaryFile(name);
        NeuralNetwork temp = (NeuralNetwork)binaryFile[0];
        return temp;
    }
    
    
    public TrainerResults getBinaryTrainnerResults(String name) throws IOException, ClassNotFoundException
    {
        Object[] binaryFile = HandleFiles.readObjectsFromBinaryFile(name);
        TrainerResults temp = (TrainerResults)binaryFile[1];
        return temp;
    }
}
