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
public class NeuralNetwork {

    private Layer capaEntrada;
    private Layer capaOculta;
    private Layer capaSalida;

    public NeuralNetwork(int numEntradas, int numNeuronasOculta, int numSalidas) {
        capaEntrada = new Layer(numEntradas, numEntradas);
        capaOculta = new Layer(numNeuronasOculta, numEntradas);
        capaSalida = new Layer(numSalidas, numNeuronasOculta);
    }

    public String calcularSalidas(ArrayList<Double> entradas) {
        ArrayList<Double> salidasOculta = capaOculta.calcularSalidas(entradas);
        ArrayList<Double> salidasRed = capaSalida.calcularSalidas(salidasOculta);

        int indiceMaximo = 0;
        double maximo = salidasRed.get(0);
        for (int i = 1; i < salidasRed.size(); i++) {
            if (salidasRed.get(i) > maximo) {
                maximo = salidasRed.get(i);
                indiceMaximo = i;
            }
        }

        System.out.println(indiceMaximo);
        // Devolver la clase correspondiente
        switch (indiceMaximo) {
            case 0:
                return "Iris Setosa";
            case 1:
                return "Iris Virginica";
            case 2:
                return "Iris Versicolor";
            default:
                throw new IllegalStateException("Índice de salida no válido.");
        }
    }

    public void entrenar(double[][] dataSet, int[] salidas, double tasaAprendizaje, int epochs) {
        for (int epoch = 0; epoch < epochs; epoch++) {
            for (int i = 0; i < dataSet.length; i++) {
                // Obtener las entradas
                ArrayList<Double> entradas = new ArrayList<>();
                for (double nota : dataSet[i]) {
                    entradas.add(nota);
                }

                // Calcular las salidas de la red
                ArrayList<Double> salidasOculta = capaOculta.calcularSalidas(entradas);
                ArrayList<Double> salidasRed = capaSalida.calcularSalidas(salidasOculta);

                // Calcular la salida esperada en formato one-hot
                double[] salidaEsperada = new double[3]; // Suponiendo 3 clases
                salidaEsperada[salidas[i]] = 1.0; // Establecer la clase esperada

                // Calcular el error para cada salida
                ArrayList<Double> erroresSalida = new ArrayList<>();
                for (int j = 0; j < salidasRed.size(); j++) {
                    double errorSalida = salidaEsperada[j] - salidasRed.get(j);
                    erroresSalida.add(errorSalida); // Agregar el error a la lista
                }

                // Ajustar pesos en la capa de salida
                capaSalida.ajustarPesos(salidasOculta, erroresSalida, tasaAprendizaje);

                // Calcular errores para la capa oculta
                ArrayList<Double> erroresOculta = new ArrayList<>();
                for (int j = 0; j < capaOculta.neuronas.size(); j++) {
                    double errorOculta = 0.0;
                    for (int k = 0; k < erroresSalida.size(); k++) {
                        errorOculta += erroresSalida.get(k) * capaSalida.neuronas.get(k).weigths.get(j); // Propagación hacia atrás
                    }
                    erroresOculta.add(errorOculta);
                }

                // Ajustar pesos en la capa oculta
                capaOculta.ajustarPesos(salidasOculta, erroresOculta, tasaAprendizaje);
            }
        }
    }
}
