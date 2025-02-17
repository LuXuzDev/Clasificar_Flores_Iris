/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package neuralNetwork;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Neuron implements Serializable{
    
    public ArrayList<Double> weights; // Pesos de la neurona
    private double bias;
    private Random random;
    private boolean isOutputNeuron; // Indica si es una neurona de salida
    private final double alpha; // Parámetro para Leaky ReLU

    // Constructor que acepta un parámetro para indicar si es una neurona de salida
    public Neuron(int numEntradas, boolean isOutputNeuron) {
         this.isOutputNeuron = isOutputNeuron;
        this.alpha = 0.01;
        weights = new ArrayList<>();
        random = new Random();

        // Inicialización de He
        if (!isOutputNeuron) { // Si es neurona de capa oculta (usa Leaky ReLU)
            double limite = Math.sqrt(2.0 / numEntradas); // He initialization
            for (int i = 0; i < numEntradas; i++) {
                weights.add(random.nextGaussian() * limite); // Distribución normal
            }
        } else { // Si es neurona de salida
            for (int i = 0; i < numEntradas; i++) {
                weights.add(random.nextDouble() * 2 - 1); // Inicialización aleatoria simple
            }
        }

        bias = random.nextDouble() * 2 - 1;
    }

    public double calcularSalida(ArrayList<Double> entradas) {
        double suma = 0.0;
        for (int i = 0; i < entradas.size(); i++) {
            suma += entradas.get(i) * weights.get(i);
        }
        suma += bias;

        // Usar la función de activación adecuada
        return isOutputNeuron ? suma : leakyReLU(suma); // Para capas ocultas, usar Leaky ReLU
    }

    private double leakyReLU(double x) {
        return (x > 0) ? x : alpha * x; // Leaky ReLU
    }

    public static ArrayList<Double> softmax(ArrayList<Double> logits) {
        ArrayList<Double> softmaxOutputs = new ArrayList<>();
        double maxLogit = Double.NEGATIVE_INFINITY;

        // Encuentra el valor máximo para estabilidad numérica
        for (double logit : logits) {
            if (logit > maxLogit) {
                maxLogit = logit;
            }
        }

        double sum = 0.0;
        for (double logit : logits) {
            sum += Math.exp(logit - maxLogit); // Resta el máximo para estabilidad
        }

        for (double logit : logits) {
            softmaxOutputs.add(Math.exp(logit - maxLogit) / sum);
        }

        return softmaxOutputs;
    }

    public void ajustarPesos(ArrayList<Double> entradas, double error, double tasaAprendizaje, double lambda) {
    for (int i = 0; i < weights.size(); i++) {
        // Actualizar pesos con L2 regularization
        weights.set(i, weights.get(i) + tasaAprendizaje * (error * entradas.get(i) - lambda * weights.get(i)));
    }
    bias += tasaAprendizaje * error; // Actualizar bias
}
}