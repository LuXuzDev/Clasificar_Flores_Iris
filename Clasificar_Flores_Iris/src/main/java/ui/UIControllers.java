/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;


import back_end.TrainerResults;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.util.FontUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


//public JFrame frame;

public class UIControllers {
    
    public static boolean icon=false;
    public static String Filename="";
    public static int Security=0;
    public static boolean Joption=false;
    public static String newFilename="";
    public static boolean JoptionCombo=false;
    public static String ComboboxName="";
    public static int NumberOptionPane=0;
    public static String TrainName="";
    public static boolean JoptionTrainMenu=false;
    public static TrainerResults trainer;
    
    public static void setFontFamily(String fontFamily)
    {
        java.awt.Font font = UIManager.getFont("defaultFont");
        java.awt.Font newFont=FontUtils.getCompositeFont(fontFamily, font.getStyle(),font.getSize());
        UIManager.put("defaultFont", newFont);
        FlatLaf.updateUI();
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    }
    
    public static FlatSVGIcon design()
    {
        UIManager.put("TextComponent.arc",99);
        UIManager.put("Button.arc", 25);
        FlatSVGIcon icon=new FlatSVGIcon("png/bluebell.svg");
        
        return icon;
    }
    
    public static void JOptioncatch(String error)
    {
        FlatSVGIcon icon2 = new FlatSVGIcon("png/bluebell.svg");
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.INFORMATION_MESSAGE, icon2);
    }
    
    public static void NamesLabelsTrainMenu(JLabel epoch,JLabel accuracy,JLabel error)
    {
        epoch.setText("Epocas: "+trainer.getEpoch());
        accuracy.setText("Precision: "+trainer.getAcurracyTotal()+"%");
        error.setText("Error: "+trainer.getErrorEntrenamiento().getLast());
    }
}


