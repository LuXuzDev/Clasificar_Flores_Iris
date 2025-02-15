/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import back_end.Controller;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class TrainMenu extends javax.swing.JFrame {

    /**
     * Creates new form TrainMenu
     */
    private Controller controller;
    
    public TrainMenu() {
        initComponents();
        design();
        if (UIControllers.icon == true) {
            LabelIcon.setIcon(new FlatSVGIcon("png/notis.svg"));
        }
    }

    public void Flatlaf() {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatMacLightLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(TrainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    //funcion para diseño general del Jframe
    private void design() {
        Flatlaf();
        UIControllers.setFontFamily("Arial");
        setIconImage(UIControllers.design().getImage());
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(102, 153, 255));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_MAXIMIZE, false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICON, true);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICONIFFY, true);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonBack = new javax.swing.JButton();
        buttonEstadis = new javax.swing.JButton();
        buttonTrain = new javax.swing.JButton();
        buttonLoadTrain = new javax.swing.JButton();
        LabelIcon = new javax.swing.JLabel();
        LabelIndicationTrain = new javax.swing.JLabel();
        LabelResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iris");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonBack.setIcon(new FlatSVGIcon("png/arrow.svg"));
        buttonBack.setBackground(new java.awt.Color(255, 255, 255));
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });
        jPanel1.add(buttonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 10, 50, 40));

        buttonEstadis.setBackground(new java.awt.Color(255, 255, 255));
        buttonEstadis.setForeground(new java.awt.Color(0, 0, 0));
        buttonEstadis.setText("Estadisticas");
        buttonEstadis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEstadisActionPerformed(evt);
            }
        });
        jPanel1.add(buttonEstadis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 160, 30));

        buttonTrain.setBackground(new java.awt.Color(255, 255, 255));
        buttonTrain.setForeground(new java.awt.Color(0, 0, 0));
        buttonTrain.setText("Entrenar");
        buttonTrain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTrainActionPerformed(evt);
            }
        });
        jPanel1.add(buttonTrain, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 160, 30));

        buttonLoadTrain.setBackground(new java.awt.Color(255, 255, 255));
        buttonLoadTrain.setForeground(new java.awt.Color(0, 0, 0));
        buttonLoadTrain.setText("Cargar dataset");
        buttonLoadTrain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoadTrainActionPerformed(evt);
            }
        });
        jPanel1.add(buttonLoadTrain, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 160, 30));
        jPanel1.add(LabelIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 40, 30));
        jPanel1.add(LabelIndicationTrain, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 160, 30));
        jPanel1.add(LabelResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 160, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEstadisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEstadisActionPerformed
        new Trainer().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonEstadisActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        new InitMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonLoadTrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoadTrainActionPerformed
        UIControllers.NumberOptionPane=1;
        new JOptionpane(this,true).setVisible(true);
        FlatSVGIcon icon=new FlatSVGIcon("png/bluebell.svg");
        if (UIControllers.JoptionCombo==false) {
            LabelIndicationTrain.setText("");
            LabelResult.setText("");
        } else if (UIControllers.JoptionCombo==true) {
            JOptionPane.showOptionDialog(null, "Datos cargados correctamente", "Dataset", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, null, null);
            LabelIndicationTrain.setText("Dataset cargados:");
            LabelResult.setText(UIControllers.ComboboxName);
        }

    }//GEN-LAST:event_buttonLoadTrainActionPerformed

    private void buttonTrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTrainActionPerformed
        FlatSVGIcon icon = new FlatSVGIcon("png/bluebell.svg");
        if (!LabelIcon.isVisible()) {
            controller.train();
        } else {
            JOptionPane.showOptionDialog(null, "No se puede entrenar debe cargar dataset primero", "Entrenamiento", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, null, null);
        }
    }//GEN-LAST:event_buttonTrainActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelIcon;
    private javax.swing.JLabel LabelIndicationTrain;
    private javax.swing.JLabel LabelResult;
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonEstadis;
    private javax.swing.JButton buttonLoadTrain;
    private javax.swing.JButton buttonTrain;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
