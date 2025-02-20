/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;


import back_end.TrainerResults;
import back_end.Validator;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.util.FontUtils;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;



public class UIControllers {
    
    
    //Atributos globales a usar en todo el paquete UI
    public static boolean icon=false;
    public static boolean Joption=false;
    public static boolean JoptionCombo=false;
    public static boolean SetDataset=false;
    public static boolean JoptionTrainMenu=false;
    public static String Filename="";
    public static String newFilename="";
    public static String ComboboxName="";
    public static String TrainName="";
    public static String SetDatasetName="";
    public static String SetTrainName="";
    public static int Security=0;
    public static int NumberOptionPane=0;
    //instancia de la clase de backend TrainerResults
    public static TrainerResults trainer;
    
 
    
    //metodo general para el font general de cada menu
    public static void setFontFamily(String fontFamily)
    {
        java.awt.Font font = UIManager.getFont("defaultFont");
        java.awt.Font newFont=FontUtils.getCompositeFont(fontFamily, font.getStyle(),font.getSize());
        UIManager.put("defaultFont", newFont);
        FlatLaf.updateUI();
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    }
    
    
    //metodo para la curvatura de componentes y para la creacion del icono del proyecto
    public static FlatSVGIcon design()
    {
        UIManager.put("TextComponent.arc",99);
        UIManager.put("Button.arc", 25);
        FlatSVGIcon icon=new FlatSVGIcon("png/bluebell.svg");
        
        return icon;
    }
    
    
    //metodo para mostrar un JOptionPane en los catch con un mensaje 
    public static void JOptioncatch(String error)
    {
        FlatSVGIcon icon2 = new FlatSVGIcon("png/bluebell.svg");
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.INFORMATION_MESSAGE, icon2);
    }
    
    
    //metodo para rellenar 3labels con los getters de la instancia trainer 
    public static void NamesLabelsTrainMenu(JLabel epoch,JLabel accuracy,JLabel error)
    {
        epoch.setText("Epocas: "+trainer.getEpoch());
        accuracy.setText("Precision: "+Math.round(trainer.getAcurracyTotal()*100)+"%");
        error.setText("Error: "+Math.round(trainer.getErrorEntrenamiento().getLast()));
    }
    
    
    //metodo para rellenar 6labels con los getters de la instancia trainer
    public static void NamesLabelsTrainer(JLabel epoch,JLabel accuracy,JLabel error,JLabel setosa,JLabel virgi,JLabel versi)
    {
        epoch.setText("Epocas: "+trainer.getEpoch());
        accuracy.setText("Precision: "+Math.round(trainer.getAcurracyTotal()*100)+"%");
        error.setText("Error: "+Math.round(trainer.getErrorEntrenamiento().getLast()));
        setosa.setText("Setosa: "+Math.round(trainer.getAcurracyClass().get(0)*100 )+"%");
        virgi.setText("Virginica: "+Math.rint(trainer.getAcurracyClass().get(1)*100) +"%");
        versi.setText("Versicolor: "+Math.round(trainer.getAcurracyClass().get(2)*100) +"%");
    }
            
    
    //metodo para rellenar el model de los comboBox con un arraylist de string
    public static void updateComboBox(ArrayList<String> names,JComboBox<String> comboBox)
    {
        for (String n : names) {
            comboBox.addItem(n);
        }
    }
    
    
    //metodo para rellenar una jlist
    public static void AddJlist(JList ListData,DefaultListModel listModel)
    {
        // Verifica si ListTrain tiene un modelo de lista
        if (Validator.ListInstanceOf(ListData)) {
            listModel = (DefaultListModel<String>) ListData.getModel();
        } else {
            listModel = new DefaultListModel<>();
            ListData.setModel(listModel);
        }

        // Vacía el modelo de lista antes de cargar nuevos elementos
        listModel.clear();

        // Agrega los nuevos elementos desde la lista path
        for (int i = 0; i < trainer.getMetricasEpoca().size(); i++) {
            listModel.add(i, trainer.getMetricasEpoca().get(i));
        }
    }
}


