/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back_end;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Angel Hernandez
 */
public class TrainerResults implements Serializable{
    
    //Attibutos
    private double acurracyTotal;
    private int epoch;
    private ArrayList<Double> errorEntrenamiento;
    private ArrayList<String> metricasEpoca;
    private ArrayList<Double> acurracyClass;
    private static final long serialVersionUID = 1L;

    
    
    //Constructor
    public TrainerResults(double acurracyTotal, int epoch,ArrayList<Double> errorEntrenamiento
                        ,ArrayList<String> metricasEpoca, ArrayList<Double> acurracyClass)
    {
        this.acurracyTotal=acurracyTotal;
        this.epoch = epoch;
        this.errorEntrenamiento=errorEntrenamiento;
        this.metricasEpoca=metricasEpoca;
        this.acurracyClass=acurracyClass;
    }
  


    //Getters
    public double getAcurracyTotal() {return acurracyTotal;}
    public int getEpoch() {return epoch;}
    public ArrayList<Double> getErrorEntrenamiento() {return errorEntrenamiento;}
    public ArrayList<String> getMetricasEpoca() {return metricasEpoca;}
    public ArrayList<Double> getAcurracyClass() {return acurracyClass;}

}
