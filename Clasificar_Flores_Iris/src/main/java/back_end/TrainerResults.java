/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back_end;

import java.util.ArrayList;

/**
 *
 * @author Angel Hernandez
 */
public class TrainerResults {
    
    //Attributes
    private double acurracyTotal;
    private int epoch;
    private ArrayList<Double> errorEntrenamiento;
    private ArrayList<String> metricasEpoca;
    private int[] aciertosPorClase = new int[3];
    private int[] totalPorClase = new int[3];

    
    
    //Builder
    public TrainerResults(double acurracyTotal, int epoch,ArrayList<Double> errorEntrenamiento
                        ,ArrayList<String> metricasEpoca, int[] aciertoClase,int[] totalPorClase)
    {
        this.acurracyTotal=acurracyTotal;
        this.epoch = epoch;
        this.errorEntrenamiento=errorEntrenamiento;
        this.metricasEpoca=metricasEpoca;
        this.aciertosPorClase=aciertosPorClase;
        this.totalPorClase=totalPorClase;
    }
    
    


    
    //Getters
    public double getAcurracyTotal() {return acurracyTotal;}
    public int getEpoch() {return epoch;}
    public ArrayList<Double> getErrorEntrenamiento() {return errorEntrenamiento;}
    public ArrayList<String> getMetricasEpoca() {return metricasEpoca;}
    public int[] getAciertosPorClase() {return aciertosPorClase;}
    public int[] getTotalPorClase() {return totalPorClase;}
}
