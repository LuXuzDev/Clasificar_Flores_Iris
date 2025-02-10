/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ui.Init_Menu;

//public JFrame frame;

public class UIControllers {
    
    public void Flatlaf(JFrame frame)
    {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatMacLightLaf());
                SwingUtilities.updateComponentTreeUI(frame);
            } catch (UnsupportedLookAndFeelException ex) {
                //Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}


