/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import back_end.Controller;
import back_end.TrainerResults;
import back_end.Validator;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import neuralNetwork.NeuralNetwork;


public class TrainMenu extends javax.swing.JFrame {

    /**
     * Creates new form TrainMenu
     */
    
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
                //funcion q mamda joption pane con el string como mensaje deljoption pane
                //UIControllers.JOptioncatch(String);
            }
        });
    }
    //funcion para diseño general del Jframe
    private void design() {
        if(UIControllers.SetDataset==false)
        {
            LabelIndicationTrain.setText("Dataset Cargado: ");
            LabelResult.setText("Entrenamiento cargado: ");
        }
        else
        {
            LabelIndicationTrain.setText(UIControllers.SetDatasetName);
            LabelResult.setText(UIControllers.SetTrainName);
        }
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
        buttonLoadDataset = new javax.swing.JButton();
        LabelIcon = new javax.swing.JLabel();
        LabelIndicationTrain = new javax.swing.JLabel();
        LabelResult = new javax.swing.JLabel();
        buttonLoadtrain = new javax.swing.JButton();

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

        buttonLoadDataset.setBackground(new java.awt.Color(255, 255, 255));
        buttonLoadDataset.setForeground(new java.awt.Color(0, 0, 0));
        buttonLoadDataset.setText("Cargar dataset");
        buttonLoadDataset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoadDatasetActionPerformed(evt);
            }
        });
        jPanel1.add(buttonLoadDataset, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 160, 30));
        jPanel1.add(LabelIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 40, 30));

        LabelIndicationTrain.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelIndicationTrain.setForeground(new java.awt.Color(102, 153, 255));
        LabelIndicationTrain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(LabelIndicationTrain, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 260, 20));

        LabelResult.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelResult.setForeground(new java.awt.Color(102, 153, 255));
        LabelResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(LabelResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 280, 20));

        buttonLoadtrain.setText("Cargar Entrenamiento");
        buttonLoadtrain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoadtrainActionPerformed(evt);
            }
        });
        jPanel1.add(buttonLoadtrain, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 160, 30));

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
        UIControllers.SetDatasetName=LabelIndicationTrain.getText();
        UIControllers.SetTrainName=LabelResult.getText();
        try {
            Validator.loadedTrainner();
            new Trainer().setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            UIControllers.JOptioncatch(ex.getMessage());
        }
    }//GEN-LAST:event_buttonEstadisActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        UIControllers.SetDatasetName=LabelIndicationTrain.getText();
        UIControllers.SetTrainName=LabelResult.getText();
        UIControllers.SetDataset=true;
        new InitMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonLoadDatasetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoadDatasetActionPerformed
        UIControllers.NumberOptionPane=1;
        UIControllers.JoptionCombo=false;
        new JOptionpane(this,true).setVisible(true);
        FlatSVGIcon icon=new FlatSVGIcon("png/bluebell.svg");
        if (UIControllers.JoptionCombo==false) {
            UIControllers.JOptioncatch("No se guardo el dataset");
        } else if (UIControllers.JoptionCombo==true) {
            JOptionPane.showOptionDialog(null, "Datos cargados correctamente", "Dataset", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, null, null);
            try {
                Controller.getInstance().setDataSetLoaded(UIControllers.ComboboxName);
            } catch (Exception ex) {
                UIControllers.JOptioncatch(ex.getMessage());
            }
            LabelIndicationTrain.setText("Dataset Cargado: "+UIControllers.ComboboxName);
        }

    }//GEN-LAST:event_buttonLoadDatasetActionPerformed

    private void buttonTrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTrainActionPerformed
        UIControllers.NumberOptionPane = 3;

        FlatSVGIcon icon = new FlatSVGIcon("png/bluebell.svg");

        try {
            Validator.loadedDataSet();
            TrainerResults results = Controller.getInstance().train();
            UIControllers.trainer = results;
            new JOptionpane(this, true).setVisible(true);
            
            if (UIControllers.JoptionTrainMenu == false) {
                UIControllers.JOptioncatch("No se guardo el entrenamiento");
                
                UIControllers.trainer=null;
                Controller.setNeuralNetwork(new NeuralNetwork(4, 50, 3));
            } 
            else if (UIControllers.JoptionTrainMenu == true) 
            {
                
                Controller.getInstance().saveTrain(UIControllers.TrainName);

                JOptionPane.showOptionDialog(null, "Datos guardados correctamente", "Dataset", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, null, null);
                LabelResult.setText("Entrenamiento cargado: " + UIControllers.TrainName);
                Controller.getInstance().setLoaded(true);
            }

        } catch (Exception ex) {
            UIControllers.JOptioncatch(ex.getMessage());
        }
    }//GEN-LAST:event_buttonTrainActionPerformed

    
    private void buttonLoadtrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoadtrainActionPerformed
        FlatSVGIcon icon = new FlatSVGIcon("png/bluebell.svg");
        UIControllers.JoptionCombo=false;
        UIControllers.NumberOptionPane=4;
        new JOptionpane(this,true).setVisible(true);
        
        if (UIControllers.JoptionCombo == false) {
            UIControllers.JOptioncatch("No se cargo el entrenamiento");
        } 
        else if (UIControllers.JoptionCombo == true) 
        {
            JOptionPane.showOptionDialog(null, "Entrenamiento cargado ", "Entrenamiento", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, null, null);
            LabelResult.setText("Entrenamiento cargado: " + UIControllers.ComboboxName);
            try {
                Controller.getInstance().loadTrain(UIControllers.ComboboxName);
                Controller.getInstance().setLoaded(true);
            } catch (IOException ex) {
                UIControllers.JOptioncatch(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                UIControllers.JOptioncatch(ex.getMessage());
            }
        }
        
    }//GEN-LAST:event_buttonLoadtrainActionPerformed

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
    private javax.swing.JButton buttonLoadDataset;
    private javax.swing.JButton buttonLoadtrain;
    private javax.swing.JButton buttonTrain;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
