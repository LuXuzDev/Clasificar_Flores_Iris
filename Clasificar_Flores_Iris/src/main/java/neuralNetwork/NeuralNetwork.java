/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package neuralNetwork;

import back_end.TrainerResults;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class NeuralNetwork implements Serializable{

    private final Layer capaEntrada;
    private final Layer capaOculta; // Solo una capa oculta
    private final Layer capaSalida;
    private static final long serialVersionUID = 1L;

    // Constructor modificado para incluir solo una capa oculta
    public NeuralNetwork(int numEntradas, int numNeuronasOculta, int numSalidas) {
        capaEntrada = new Layer(numEntradas, numEntradas, false); // Capa de entrada
        capaOculta = new Layer(numNeuronasOculta, numEntradas, false); // Primera capa oculta
        capaSalida = new Layer(numSalidas, numNeuronasOculta, true); // Capa de salida

    }

    // Método para calcular las salidas de la red
    public int calcularSalidas(ArrayList<Double> entradas) {
        ArrayList<Double> salidasOculta = capaOculta.calcularSalidas(entradas);
        ArrayList<Double> salidasRed = capaSalida.calcularSalidas(salidasOculta);

        // Aplicar softmax a las salidas de la capa de salida
        ArrayList<Double> salidasSoftmax = Neuron.softmax(salidasRed);

        // Encontrar el índice de la salida con la probabilidad máxima
        int indiceMaximo = 0;
        double maximo = salidasSoftmax.get(0);
        for (int i = 1; i < salidasSoftmax.size(); i++) {
            if (salidasSoftmax.get(i) > maximo) {
                maximo = salidasSoftmax.get(i);
                indiceMaximo = i;
            }
        }
        return indiceMaximo;
    }

    // Función de pérdida de entropía cruzada
    public double crossEntropyLoss(ArrayList<Double> predicciones, int claseReal) {
        double epsilon = 1e-10; // Un pequeño valor para evitar log(0)
        return -Math.log(predicciones.get(claseReal) + epsilon);
    }

    public TrainerResults entrenar(double[][] dataSet, int[] salidas, double tasaAprendizaje, int epochs, double lambda) {

        ArrayList<String> metricas = new ArrayList<String>();
        ArrayList<Double> errorEntrenamiento = new ArrayList<Double>();
        double mejorError = Double.MAX_VALUE;
        int paciencia = 50;
        int contador = 0;

        Object[] shuffledData = mezclarDataSet(dataSet, salidas);
        dataSet = (double[][]) shuffledData[0];
        salidas = (int[]) shuffledData[1];

        for (int epoch = 0; epoch < epochs; epoch++) {
            double errorTotal = 0.0;
            int aciertos = 0;

            for (int i = 0; i < dataSet.length; i++) {
                ArrayList<Double> entradas = new ArrayList<>();
                for (double valor : dataSet[i]) {
                    entradas.add(valor);
                }

                // Forward pass
                ArrayList<Double> salidasOculta = capaOculta.calcularSalidas(entradas);
                ArrayList<Double> salidasRed = capaSalida.calcularSalidas(salidasOculta);
                ArrayList<Double> salidasSoftmax = Neuron.softmax(salidasRed);

                // Calcular error
                double[] salidaEsperada = new double[salidasRed.size()];
                Arrays.fill(salidaEsperada, 0.0); // Inicializar a cero
                salidaEsperada[salidas[i]] = 1.0; // Establecer la clase esperada

                double errorSalida = crossEntropyLoss(salidasSoftmax, salidas[i]);
                errorTotal += errorSalida; // Sumar el error total

                // Backpropagation
                ArrayList<Double> erroresSalida = new ArrayList<>();
                for (int j = 0; j < salidasSoftmax.size(); j++) {
                    double error = salidaEsperada[j] - salidasSoftmax.get(j);
                    erroresSalida.add(error);
                }

                // Ajustar pesos en la capa de salida
                capaSalida.ajustarPesos(salidasOculta, erroresSalida, tasaAprendizaje, lambda);

                // Calcular errores para la capa oculta
                ArrayList<Double> erroresOculta = new ArrayList<>();
                for (int j = 0; j < capaOculta.neuronas.size(); j++) {
                    double errorOculta = 0.0;
                    for (int k = 0; k < erroresSalida.size(); k++) {
                        errorOculta += erroresSalida.get(k) * capaSalida.neuronas.get(k).weights.get(j);
                    }
                    erroresOculta.add(errorOculta);
                }

                // Ajustar pesos en la capa oculta
                capaOculta.ajustarPesos(entradas, erroresOculta, tasaAprendizaje, lambda);

                // Calcular aciertos
                int prediccion = calcularSalidas(entradas);
                if (prediccion == salidas[i]) {
                    aciertos++;
                }
            }

            // Early stopping
            if (errorTotal < mejorError) {
                mejorError = errorTotal;
                contador = 0;
            } else {
                contador++;
            }

            if (contador >= paciencia) {
                System.out.println("Detenido en Epoca " + epoch);
                break;
            }

            String metrica = "Epoca: " + epoch + ", Error: " + errorTotal + ", Precision: " + (double) aciertos / dataSet.length;
            metricas.add(metrica);
            errorEntrenamiento.add(errorTotal);
        }
        return guardarEntrenamiento(dataSet, salidas, metricas, errorEntrenamiento);
    }

    
    private Object[] mezclarDataSet(double[][] dataSet, int[] salidas) {
        int[] indices = new int[dataSet.length];
        for (int i = 0; i < dataSet.length; i++) {
            indices[i] = i;
        }

        Random random = new Random();
        for (int i = dataSet.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            // Intercambia los índices
            int temp = indices[i];
            indices[i] = indices[j];
            indices[j] = temp;
        }

        double[][] dataSetMezclado = new double[dataSet.length][dataSet[0].length];
        int[] salidasMezcladas = new int[salidas.length];
        for (int i = 0; i < dataSet.length; i++) {
            dataSetMezclado[i] = dataSet[indices[i]];
            salidasMezcladas[i] = salidas[indices[i]];
        }
        return new Object[]{dataSetMezclado, salidasMezcladas};
    }

    
    private TrainerResults guardarEntrenamiento(double[][] dataSetPrueba, int[] salidasReales, ArrayList<String> metricas, ArrayList<Double> error) {

        int aciertos = 0;
        int[] aciertosPorClase = new int[3];
        int[] totalPorClase = new int[3];
        double precision;

        ArrayList<Double> errorEntrenamiento = error;
        ArrayList<String> metricasEpoca = metricas;
        ArrayList<Double> precisionClase = new ArrayList<>();

        TrainerResults results;

        for (int i = 0; i < dataSetPrueba.length; i++) {
            ArrayList<Double> entradas = new ArrayList<>();
            for (double valor : dataSetPrueba[i]) {
                entradas.add(valor);
            }

            int prediccion = calcularSalidas(entradas);

            if (prediccion == salidasReales[i]) {
                aciertos++;
                aciertosPorClase[salidasReales[i]]++;
            }
            totalPorClase[salidasReales[i]]++;
        }

        precision = (double) aciertos / dataSetPrueba.length;

        for (int i = 0; i < 3; i++) {
            if (totalPorClase[i] > 0) {
                precisionClase.add((double) aciertosPorClase[i] / totalPorClase[i]);
            }
        }

        results = new TrainerResults(precision, dataSetPrueba.length, errorEntrenamiento, metricasEpoca, precisionClase);
        return results;
    }
}
