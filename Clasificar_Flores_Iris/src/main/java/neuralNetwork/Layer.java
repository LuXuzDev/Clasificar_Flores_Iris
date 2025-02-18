/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package neuralNetwork;

import java.io.Serializable;


/**
 *
 * @author Angel Hernandez
 */
import java.util.ArrayList;

public class Layer implements Serializable{
    public ArrayList<Neuron> neuronas;
    private boolean isOutputLayer; // Indica si es la capa de salida

    public Layer(int numNeuronas, int numEntradasPorNeurona, boolean isOutputLayer) {
        this.isOutputLayer = isOutputLayer; // Inicializa el indicador de capa de salida
        neuronas = new ArrayList<>();
        for (int i = 0; i < numNeuronas; i++) {
            neuronas.add(new Neuron(numEntradasPorNeurona, isOutputLayer)); // Pasar el indicador a la neurona
        }
    }

    public ArrayList<Double> calcularSalidas(ArrayList<Double> entradas) {
        ArrayList<Double> salidas = new ArrayList<>();
        for (Neuron neurona : neuronas) {
            salidas.add(neurona.calcularSalida(entradas));
        }

        // Si es la capa de salida, aplicar softmax
        if (isOutputLayer) {
            return Neuron.softmax(salidas); // Llama a softmax para obtener las probabilidades
        }

        return salidas; // Para capas ocultas, devuelve las salidas directamente
    }

    public void ajustarPesos(ArrayList<Double> entradas, ArrayList<Double> errores, double tasaAprendizaje, double lambda) {
    for (int i = 0; i < neuronas.size(); i++) {
        Neuron neurona = neuronas.get(i);
        neurona.ajustarPesos(entradas, errores.get(i), tasaAprendizaje, lambda);
    }
}
}