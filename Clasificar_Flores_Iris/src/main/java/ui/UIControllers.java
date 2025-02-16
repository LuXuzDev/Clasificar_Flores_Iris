/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.util.FontUtils;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ui.InitMenu;

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
    
}


