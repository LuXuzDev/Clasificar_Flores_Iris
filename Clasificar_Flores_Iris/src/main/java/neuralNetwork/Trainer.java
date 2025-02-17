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
public class Trainer {
    private  double [][] dataSet;
    private  int [] salida;
    
    
    
    public double [][] getDataSet()
    {
        return dataSet;
    }
    

    
    public int [] getDataSetSalida()
    {
        return salida;
    }
    
    public void processInput(ArrayList<String> data) throws Exception {
        // Crear un arreglo bidimensional para los números
        try{
        dataSet = new double[data.size()-1][]; // Inicializa el arreglo con el tamaño del ArrayList
        salida = new int[data.size()-1]; // Arreglo para clasificaciones

        // Recorrer cada entrada en el ArrayList
        for (int i = 0; i < data.size()-1; i++) {
            String input = data.get(i); // Obtener la entrada actual
            String[] parts = input.split(","); // Dividir la cadena por comas

 
            // Crear un arreglo para los números de la entrada actual
            dataSet[i] = new double[parts.length - 1]; // El último elemento es la clasificación

            // Convertir los números de String a double
            for (int j = 0; j < dataSet[i].length; j++) {
                dataSet[i][j] = Double.parseDouble(parts[j]); // Convertir cada parte a double
            }

            // Asignar la clasificación
            String classificationString = parts[parts.length - 1]; // Obtener la clasificación
            salida[i] = getClassification(classificationString); // Convertir a int
            }
        }catch(Exception e)
        {
            throw new Exception("Error al leer el data-set");
        }
    }

    // Método para convertir la clasificación de String a int
    private  int getClassification(String classification) {
        switch (classification.toLowerCase()) {
            case "iris-setosa":
                return 0;
            case "iris-virginica":
                return 1;
            case "iris-versicolor":
                return 2;
            default:
                throw new IllegalArgumentException("Clasificación desconocida: " + classification);
        }
    }
}
