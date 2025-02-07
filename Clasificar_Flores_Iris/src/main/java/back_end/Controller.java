/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back_end;

import java.util.ArrayList;
import neuralNetwork.NeuralNetwork;
import neuralNetwork.Normalizer;
import neuralNetwork.Trainer;

/**
 *
 * @author Angel Hernandez
 */
public class Controller {
    private NeuralNetwork neuralNetwork;
    private Validator validator;
    private Trainer t;
    private Normalizer n;
    

    public Controller()
    {
        neuralNetwork = new NeuralNetwork(4,50, 3); 
        
        // Crear el entrenador y normalizador
        t = new Trainer();
        n = new Normalizer();
        
        validator = new Validator("admin");
    }
    
    
    public String flowerType(String widthLeaf, String lengthLeaf, String widthStem, String lengthStem)
    {
        int output = neuralNetwork.calcularSalidas(n.normalizarEntrada(takeInput(widthLeaf, lengthLeaf, widthStem, lengthStem)));
        System.out.println("La clasifica como: "+classifierOutput(output));
        return classifierOutput(output);
    }
    
    
    private ArrayList<Double> takeInput(String widthLeaf, String lengthLeaf, String widthStem, String lengthStem )
    {
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
    
    
    private String classifierOutput(int output)
    {
        String flowerType="Iris-Setosa";
        
        if(output==1)
            flowerType ="Iris-Virginica";
        else if(output==2)
            flowerType ="Iris-Versicolor";
        return flowerType;
        
    }
    
    
    private double stringToDouble(String num)
    {
        double temp = Double.parseDouble(num);
        return temp;
    }
    
    
    public void train() {

        n.ajustar(t.getDataSet());
        double[][] dataSet = n.normalizar(t.getDataSet());

        // Imprimir el conjunto de datos normalizado
        System.out.println("Conjunto de datos normalizado:");

        // Entrenar la red neuronal
        System.out.println("Entrenando...");
        neuralNetwork.entrenar(dataSet, t.getDataSetSalida(), 0.0001, 2500, 0.05);

        // Iris Setosa
        ArrayList<Double> entrada1 = new ArrayList<>();
        entrada1.add(5.1);
        entrada1.add(3.5);
        entrada1.add(1.4);
        entrada1.add(0.2);

        // Iris Virginica
        ArrayList<Double> entrada2 = new ArrayList<>();
        entrada2.add(4.9);
        entrada2.add(2.4);
        entrada2.add(3.3);
        entrada2.add(1.0);

        // Iris Versicolor
        ArrayList<Double> entrada3 = new ArrayList<>();
        entrada3.add(6.3);
        entrada3.add(3.3);
        entrada3.add(6.0);
        entrada3.add(2.5);

        /*
                    0-Setosa
                    1-Virginica
                    2-Versicolor
                    Mejor Precision = 0.73
         */
        neuralNetwork.mostrar(dataSet, t.getDataSetSalida());
        System.out.println("Salida red: " + neuralNetwork.calcularSalidas(n.normalizarEntrada(entrada1)));
    }
}
