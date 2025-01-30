/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package neuralNetwork;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Angel Hernandez
 */
public class Neuron {
    
    public ArrayList<Double> weigths;
    private double bias;
    private Random random;

    public Neuron(int numEntradas) {
        weigths = new ArrayList<>();
        random = new Random();
        // Inicializa los pesos y el bias aleatoriamente
        for (int i = 0; i < numEntradas; i++) {
            weigths.add(i,random.nextDouble() * 0.1 - 0.05);
        }
        bias = random.nextDouble() * 0.1 - 0.05; 
    }

    
    public double calcularSalida(ArrayList<Double> entradas) {
        double suma = 0.0;
        for (int i = 0; i < entradas.size(); i++) {
            suma += entradas.get(i) * weigths.get(i);
        }
        suma += bias;
        return sigmoide(suma); // Usar sigmoide
    }

    
    private double sigmoide(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    
    public void ajustarPesos(ArrayList<Double> entradas, double error, double tasaAprendizaje) {
        for (int i = 0; i < weigths.size(); i++) {
            weigths.set(i, weigths.get(i) + tasaAprendizaje * error * entradas.get(i));
        }
        bias += tasaAprendizaje * error;
    }
}
