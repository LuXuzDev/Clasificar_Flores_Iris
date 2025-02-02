/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import neuralNetwork.NeuralNetwork;
import neuralNetwork.Normalizer;
import neuralNetwork.Trainer;

/**
 *
 * @author Angel Hernandez
 */
public class Main {
    public static void main(String[] args)
    {
        System.out.println("Ejecutando");
        NeuralNetwork redNeuronal = new NeuralNetwork(4, 5, 3);
        Trainer t = new Trainer();
        Normalizer n = new Normalizer();
        n.ajustar(t.getDataSet());
        double [][] dataSet = n.normalizar(t.getDataSet());

        System.out.println("Entrenando...");
        redNeuronal.entrenar(dataSet, t.getDataSetSalida(), 0.01, 500);

        
        ArrayList<Double> entrada1 = new ArrayList<>();
        entrada1.add(5.7);
        entrada1.add(2.8);
        entrada1.add(4.1);
        entrada1.add(1.3);

        String salida = redNeuronal.calcularSalidas(n.normalizarEntrada(entrada1));

        System.out.println("Salida red: " + salida);
    }
}
