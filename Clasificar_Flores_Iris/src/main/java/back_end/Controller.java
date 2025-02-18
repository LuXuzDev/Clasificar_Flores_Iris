/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back_end;

import infrastructure.DataBaseController;
import infrastructure.DataBaseTrainnerController;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import neuralNetwork.NeuralNetwork;
import neuralNetwork.Normalizer;
import neuralNetwork.Trainer;

/**
 *
 * @author Angel Hernandez
 */
public class Controller {
    private static Controller instance; // Instancia única de Controller
    private static NeuralNetwork neuralNetwork;
    private static TrainerResults trainnerResults;
    private final Trainer trainer;
    private static Normalizer normalizer;
    private File dataSetLoaded;
    private boolean loaded;



    // Constructor privado para evitar instanciación externa
    private Controller() {
        loaded=false;
        neuralNetwork = new NeuralNetwork(4, 50, 3);
        
        // Crear Entrenador y Normalizador
        trainer = new Trainer();
        normalizer = new Normalizer();
        DataBaseController.getFilesInPackage();
    }

    

    //Metodo para clasificar la flor
    public String flowerType(String widthLeaf, String lengthLeaf, String widthStem, String lengthStem) {
        int output = neuralNetwork.calcularSalidas(normalizer.normalizarEntrada(takeInput(widthLeaf, lengthLeaf, widthStem, lengthStem)));
        return classifierOutput(output);
    }

    
    //Metodo para tomar los valores de entrada
    private ArrayList<Double> takeInput(String widthLeaf, String lengthLeaf, String widthStem, String lengthStem) {
        double wLeaf = stringToDouble(widthLeaf);
        double lLeaf = stringToDouble(lengthLeaf);
        double wStem = stringToDouble(widthStem);
        double lStem = stringToDouble(lengthStem);
        ArrayList<Double> inputs = new ArrayList<>();
        inputs.add(wLeaf);
        inputs.add(lLeaf);
        inputs.add(wStem);
        inputs.add(lStem);
        return inputs;
    }

    
    //Metodo para elegir la clasificacion de flor
    private String classifierOutput(int output) {
        String flowerType = "Iris-Setosa";
        
        if (output == 1)
            flowerType = "Iris-Virginica";
        else if (output == 2)
            flowerType = "Iris-Versicolor";
        
        return flowerType;
    }

    
    //Metodo para convertir de String a Double
    private double stringToDouble(String num) {
        return Double.parseDouble(num);
    }

    
    //Metodo para entrenar la red neuronal y devolver los resultados del entrenamiento
    public TrainerResults train() throws Exception {
        
        //Validar Datos
        if(dataSetLoaded==null)
            throw new Exception("No hay dataSet cargados");
    
        trainer.processInput(DataBaseController.fileContent(dataSetLoaded.getName()));
        
        //Normalizar Datos
        normalizer.ajustar(trainer.getDataSet());
        double[][] dataSet = normalizer.normalizar(trainer.getDataSet());

        // Imprimir el conjunto de datos normalizado
        System.out.println("Conjunto de datos normalizado:");

        // Entrenar la red neuronal
        System.out.println("Entrenando...");
        TrainerResults results = neuralNetwork.entrenar(dataSet, trainer.getDataSetSalida(), 0.0001, 2500, 0.05);
        System.out.println(results);

        // Ejemplo de entradas
        ArrayList<Double> entrada1 = new ArrayList<>();
        entrada1.add(5.1);
        entrada1.add(3.5);
        entrada1.add(1.4);
        entrada1.add(0.2);
        ArrayList<Double> entrada2 = new ArrayList<>();
        entrada2.add(7.7);
        entrada2.add(3.0);
        entrada2.add(6.1);
        entrada2.add(2.3);
        ArrayList<Double> entrada3 = new ArrayList<>();
        entrada3.add(6.3);
        entrada3.add(3.4);
        entrada3.add(5.6);
        entrada3.add(2.4);

        System.out.println("Salida red: " + neuralNetwork.calcularSalidas(normalizer.normalizarEntrada(entrada1))+" esperada 0");
        System.out.println("Salida red: " + neuralNetwork.calcularSalidas(normalizer.normalizarEntrada(entrada2))+" esperada 1");
        System.out.println("Salida red: " + neuralNetwork.calcularSalidas(normalizer.normalizarEntrada(entrada3))+" esperada 2");
        
        trainnerResults=results;
        return results;
    }

    
    //Metodo que de retorna los nombres de los dataset almacenados en dataBase_DataSet
    public ArrayList<String> loadedFilesName() {
        ArrayList<File> files = DataBaseController.getFilesInPackage();
        ArrayList<String> names = new ArrayList<>();
        
        for (File f : files) {
            names.add(f.getName());
        }
        return names;
    }

    
    //Metodo que de retorna los nombres de los entrenamientos almacenados en dataBase_Trainings
    public ArrayList<String> loadedTrainnersName() {
        ArrayList<File> files = DataBaseTrainnerController.getFileOutputStreams();
        ArrayList<String> names = new ArrayList<>();

        for (File f : files) {
            names.add(f.getName());
        }
        return names;
    }
    
    
    //Metodo para crear un fichero
    public void createFile(String name) throws IOException {
        DataBaseController.createFile(name);
    }

    
    //Metodo para eliminar un fichero
    public void deleteFile(String name) throws Exception {
        DataBaseController.deleteFile(name);
    }

    
    //Metodo para importar un fichero
    public void importFile(String path) {
        DataBaseController.loadFile(path);
    }

    
    //Metodo que devuelve el contenido de un archivo
    public ArrayList<String> fileContent(String name) throws Exception {
        return DataBaseController.fileContent(name);
    }
    
    
    //Metodo para editar un fichero
    public ArrayList<String> editFile(String line,String name) throws Exception
    {
        DataBaseController.editFile(line, name);
        return fileContent(name);
    }

    
    //Metodo para crear un fichero que guarda en binario el estado de la red neuronal y el resultado del entrenamiento
    public void saveTrain (String name) throws IOException
    {
        DataBaseTrainnerController.saveTrain(neuralNetwork, trainnerResults, name);
    }
    
    
    //Metodo qque carga de un fichero .dat la red neuronal y el resultado del entrenamiento
    public void loadTrain(String name) throws IOException, ClassNotFoundException
    {
        trainnerResults = DataBaseTrainnerController.getBinaryTrainnerResults(name);
        neuralNetwork = DataBaseTrainnerController.getBinaryNeuralNetwork(name);
        
        if (neuralNetwork != null && trainnerResults != null) 
            System.out.println("Entrenamiento cargado correctamente.");
        else 
            System.out.println("Error al cargar entrenamiento.");
    }
    
    

    //Getters and Setters
    
    
    // Método estático para obtener la instancia única
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    
    public static TrainerResults getTrainnerResults() {return trainnerResults;}

    
    public static void setTrainnerResults(TrainerResults trainnerResults) {Controller.trainnerResults = trainnerResults;}

    
    public static void setNeuralNetwork(NeuralNetwork neuralNetwork) {Controller.neuralNetwork = neuralNetwork;}

    
    public static Normalizer getNormalizer() {return normalizer;}
    
    
    public File getDataSetLoaded() {return dataSetLoaded;}

    
    public TrainerResults getTrainerResultsLoaded() {return trainnerResults;}

    
    public boolean isLoaded() { return loaded;}

    
    public void setLoaded(boolean loaded) {this.loaded = loaded;}
    
    
    public Trainer getTrainer() {return trainer;}
    
    
    public void setDataSetLoaded(String dataSetName) throws Exception {
        File file = DataBaseController.findFile(dataSetName);
        Validator.existFile(file);
        dataSetLoaded = file;
    }  
}