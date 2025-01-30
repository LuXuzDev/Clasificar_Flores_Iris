/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package neuralNetwork;

import java.util.ArrayList;

/**
 *
 * @author Angel Hernandez
 */
public class Layer {
    public ArrayList<Neuron> neuronas;

    public Layer(int numNeuronas, int numEntradasPorNeurona) {
        neuronas = new ArrayList<>();
        for (int i = 0; i < numNeuronas; i++) {
            neuronas.add(new Neuron(numEntradasPorNeurona));
        }
    }

    
    public ArrayList<Double> calcularSalidas(ArrayList<Double> entradas) {
        ArrayList<Double> salidas = new ArrayList<>();
        for (Neuron neurona : neuronas) {
            salidas.add(neurona.calcularSalida(entradas));
        }
        return salidas;
    }
    
    
   public void ajustarPesos(ArrayList<Double> entradas, ArrayList<Double> errores, double tasaAprendizaje) {
        if (errores.size() != neuronas.size()) {
            throw new IllegalArgumentException("El tamaño de errores debe coincidir con el número de neuronas en la capa.");
        }
        for (int i = 0; i < neuronas.size(); i++) {
            neuronas.get(i).ajustarPesos(entradas, errores.get(i), tasaAprendizaje);
        }
    }
}
