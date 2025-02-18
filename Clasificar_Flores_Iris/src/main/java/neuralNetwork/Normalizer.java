/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package neuralNetwork;

import infrastructure.DataBaseController;
import java.util.ArrayList;

/**
 *
 * @author Angel Hernandez
 */
public class Normalizer {
    
    private double[] minimos;
    private double[] maximos;

    public double[] getMinimos() {
        return minimos;
    }

    public double[] getMaximos() {
        return maximos;
    }
    


    public void ajustar(double[][] dataSet) {
        int numAtributos = dataSet[0].length;
        minimos = new double[numAtributos];
        maximos = new double[numAtributos];

        // Inicializar minimos y maximos
        for (int i = 0; i < numAtributos; i++) {
            minimos[i] = Double.MAX_VALUE;
            maximos[i] = Double.MIN_VALUE;
        }

        // Calcular minimos y maximos
        for (double[] fila : dataSet) {
            for (int i = 0; i < numAtributos; i++) {
                if (fila[i] < minimos[i]) {
                    minimos[i] = fila[i];
                }
                if (fila[i] > maximos[i]) {
                    maximos[i] = fila[i];
                }
            }
        }
    }
    
    public ArrayList<Double> normalizarEntrada(ArrayList<Double> dataSet) {
        ArrayList<Double> dataSetNormalizado = new ArrayList<>(dataSet.size());

        // Inicializar la lista con ceros o valores predeterminados
        for (int i = 0; i < dataSet.size(); i++) {
            dataSetNormalizado.add(0.0);
        }

        for (int i = 0; i < dataSet.size(); i++) {
            // Normalizar correctamente
            dataSetNormalizado.set(i, (dataSet.get(i) - minimos[i]) / (maximos[i] - minimos[i]));
        }
        return dataSetNormalizado;
    }

    
    public double[][] normalizar(double[][] dataSet) {
        int numAtributos = dataSet[0].length - 1; // Última columna es la clase
        double[][] dataSetNormalizado = new double[dataSet.length][dataSet[0].length];

        for (int i = 0; i < dataSet.length; i++) {
            for (int j = 0; j < numAtributos; j++) {
                dataSetNormalizado[i][j] = (dataSet[i][j] - minimos[j]) / (maximos[j] - minimos[j]);
            }
            dataSetNormalizado[i][numAtributos] = dataSet[i][numAtributos]; // Copiar la clase sin normalizar
        }

        return dataSetNormalizado;
    }
}
