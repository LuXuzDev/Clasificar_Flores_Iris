/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import back_end.Controller;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.util.FontUtils;
import com.mycompany.placeholdermaven.TextPrompt;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import neuralNetwork.NeuralNetwork;
import neuralNetwork.Normalizer;
import neuralNetwork.Trainer;


public class Init_Menu extends javax.swing.JFrame {


    //Attributes
    private Controller controller;
    public static Timer timer;
  
    public Init_Menu() {
        controller = new Controller();
        initComponents();
        design();
        check(FieldAnchoPetalo);
        check(FieldAnchoSepalo);
        check(FieldLongitudPetalo);
        check(FieldLongitudSepalo);
        controller.train();
        
        //el icono va a ser mejor tranqui
        FlatSVGIcon icon=new FlatSVGIcon("png/bluebell.svg");
        setIconImage(icon.getImage());
        
        //el timer tengo q ponerlo aqui obligado sino da bateo
        timer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckAndStart();
            }
        });
        timer.setRepeats(false);
    }
    
    private void design()
    {
        Flatlaf();
        
        setFontFamily("Arial");
        
        UIManager.put("TextComponent.arc",99);
        UIManager.put("Button.arc", 25);
        
        this.setLocationRelativeTo(null);
        
        ProgressBar.setStringPainted(true);
        ProgressBar.setVisible(false);
        
        JprogressbarLabel.setVisible(false);
        
        FieldAnchoPetalo.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Ancho Petalo");
        FieldAnchoSepalo.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Ancho Sepalo");
        FieldLongitudPetalo.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Longitud Petalo");
        FieldLongitudSepalo.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Longitud Sepalo");
        FieldAnchoPetalo.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true);
        FieldAnchoSepalo.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true);
        FieldLongitudPetalo.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true);
        FieldLongitudSepalo.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(102, 153, 255));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_MAXIMIZE,false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICON,true);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICONIFFY,true);
        
    }
     
    //funcion para ver si no esta vacio un textfield
    private boolean CheckTextField(JTextField field)
    {
        boolean salir = false;
        if (!field.getText().trim().isEmpty()) {
            salir = true;
        }
        
        return salir;
    }
    
    //Funcion para verificar los textField en tiempo real
    private void check(JTextField field)
    {
        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                restartTimer();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                restartTimer();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                restartTimer();
            }
        });
    }
    //funcion para reiniciar los timers de la busqueda en tiempo real de los text field
    private void restartTimer()
    {
        timer.stop();
        timer.start();
    }
    //funcion para verificar si todos estan llenos y empezar el analisis automatico
    public void CheckAndStart()
    {
        boolean salir=false;
        if(CheckTextField(FieldAnchoSepalo)==true && CheckTextField(FieldAnchoPetalo)==true && CheckTextField(FieldLongitudPetalo)==true && CheckTextField(FieldLongitudSepalo)==true)
        {
            JprogressbarLabel.setVisible(true);
            ProgressBar.setVisible(true);
            startProgress(ProgressBar);
        }
       
    }
 
   //analisis automatico de la barraprogress con hilos y reiniciar los datos
    private void startProgress(JProgressBar progressBar)
    {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i <= 100; i++) {
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        progressBar.setValue(i);
                        FieldAnchoPetalo.setEnabled(false);
                        FieldAnchoSepalo.setEnabled(false);
                        FieldLongitudPetalo.setEnabled(false);
                        FieldLongitudSepalo.setEnabled(false);
                       
                    }
                    SwingUtilities.invokeLater(()->restart());
                    jLabel_Resultado.setText(controller.flowerType(FieldLongitudSepalo.getText(),FieldAnchoSepalo.getText()
                                                ,FieldLongitudPetalo.getText(), FieldAnchoPetalo.getText()));
                }
            }).start();
            
             
    }
    
    //funcion para reestablecer los datos
    private void restart()
    {
        if(ProgressBar.getValue()==100)
        {
            ProgressBar.setValue(0);
            ProgressBar.setVisible(false);
            JprogressbarLabel.setVisible(false);
            FieldAnchoPetalo.setEnabled(true);
            FieldAnchoSepalo.setEnabled(true);
            FieldLongitudPetalo.setEnabled(true);
            FieldLongitudSepalo.setEnabled(true);
            
        }
        
    }
   /*
   //funcion para poner el texto de indicacion a cada textField con lo q debe poner en cada uno
    public void placeHolder(String text,JTextField field)
    {
        TextPrompt placeholder;
        placeholder = new TextPrompt(text, field);
        placeholder.changeAlpha(0.75f);
        placeholder.changeStyle(java.awt.Font.BOLD);
    }
    */
    //funcion de diseño de flatlaf
    public void Flatlaf()
    {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatMacLightLaf());
                SwingUtilities.updateComponentTreeUI(this);
                /*placeHolder("     Ancho del petalo", FieldAnchoPetalo);
                placeHolder("   Longitud del sepalo", FieldLongitudSepalo);
                placeHolder("     Ancho del sepalo", FieldAnchoSepalo);
                placeHolder("   Longitud del petalo", FieldLongitudPetalo);
*/
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Init_Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
   //Funcion para poner un font general en el Jframe
    private void setFontFamily(String fontFamily)
    {
        java.awt.Font font = UIManager.getFont("defaultFont");
        java.awt.Font newFont=FontUtils.getCompositeFont(fontFamily, font.getStyle(),font.getSize());
        UIManager.put("defaultFont", newFont);
        FlatLaf.updateUI();
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ButtonTrain = new javax.swing.JButton();
        buttonDatabase = new javax.swing.JButton();
        FieldAnchoPetalo = new javax.swing.JTextField();
        FieldLongitudSepalo = new javax.swing.JTextField();
        FieldAnchoSepalo = new javax.swing.JTextField();
        FieldLongitudPetalo = new javax.swing.JTextField();
        jLabel_Resultado = new javax.swing.JLabel();
        Imagen = new javax.swing.JLabel();
        ProgressBar = new javax.swing.JProgressBar();
        JprogressbarLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iris");
        setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonTrain.setForeground(new java.awt.Color(0, 0, 0));
        ButtonTrain.setText("Entrenar");
        ButtonTrain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTrainActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonTrain, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 130, 30));

        buttonDatabase.setForeground(new java.awt.Color(0, 0, 0));
        buttonDatabase.setText("Base de datos");
        buttonDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDatabaseActionPerformed(evt);
            }
        });
        jPanel1.add(buttonDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 130, 30));

        FieldAnchoPetalo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        FieldAnchoPetalo.setForeground(new java.awt.Color(0, 0, 0));
        FieldAnchoPetalo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FieldAnchoPetalo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        FieldAnchoPetalo.setKeymap(null);
        FieldAnchoPetalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldAnchoPetaloActionPerformed(evt);
            }
        });
        jPanel1.add(FieldAnchoPetalo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 170, -1));

        FieldLongitudSepalo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        FieldLongitudSepalo.setForeground(new java.awt.Color(0, 0, 0));
        FieldLongitudSepalo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FieldLongitudSepalo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        FieldLongitudSepalo.setKeymap(null);
        FieldLongitudSepalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldLongitudSepaloActionPerformed(evt);
            }
        });
        jPanel1.add(FieldLongitudSepalo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 170, -1));

        FieldAnchoSepalo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        FieldAnchoSepalo.setForeground(new java.awt.Color(0, 0, 0));
        FieldAnchoSepalo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FieldAnchoSepalo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        FieldAnchoSepalo.setKeymap(null);
        FieldAnchoSepalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldAnchoSepaloActionPerformed(evt);
            }
        });
        jPanel1.add(FieldAnchoSepalo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 170, -1));

        FieldLongitudPetalo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        FieldLongitudPetalo.setForeground(new java.awt.Color(0, 0, 0));
        FieldLongitudPetalo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FieldLongitudPetalo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        FieldLongitudPetalo.setKeymap(null);
        FieldLongitudPetalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldLongitudPetaloActionPerformed(evt);
            }
        });
        jPanel1.add(FieldLongitudPetalo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 170, -1));

        jLabel_Resultado.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel_Resultado.setForeground(new java.awt.Color(102, 153, 255));
        jLabel_Resultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel_Resultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 160, 30));

        Imagen.setIcon(new FlatSVGIcon("png/bluebell.svg"));
        jPanel1.add(Imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 70, 60));

        ProgressBar.setBackground(new java.awt.Color(255, 255, 255));
        ProgressBar.setToolTipText("Analizando...");
        ProgressBar.setOpaque(true);
        jPanel1.add(ProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 234, 170, 20));

        JprogressbarLabel.setBackground(new java.awt.Color(255, 255, 255));
        JprogressbarLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JprogressbarLabel.setForeground(new java.awt.Color(102, 153, 255));
        JprogressbarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JprogressbarLabel.setText("Analizando...");
        jPanel1.add(JprogressbarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 206, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonTrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTrainActionPerformed
        SecurityPassword secu2= new SecurityPassword(this,true,2);
       secu2.setVisible(true);
        
    }//GEN-LAST:event_ButtonTrainActionPerformed

    private void buttonDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDatabaseActionPerformed
       SecurityPassword secu= new SecurityPassword(this,true,1);
       secu.setVisible(true);
    }//GEN-LAST:event_buttonDatabaseActionPerformed

    private void FieldAnchoPetaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldAnchoPetaloActionPerformed
        
    }//GEN-LAST:event_FieldAnchoPetaloActionPerformed

    private void FieldLongitudSepaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldLongitudSepaloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldLongitudSepaloActionPerformed

    private void FieldAnchoSepaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldAnchoSepaloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldAnchoSepaloActionPerformed

    private void FieldLongitudPetaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldLongitudPetaloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldLongitudPetaloActionPerformed

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
            java.util.logging.Logger.getLogger(Init_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Init_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Init_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Init_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Init_Menu init = new Init_Menu();
                init.setVisible(true);
                
                
               
        
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonTrain;
    private javax.swing.JTextField FieldAnchoPetalo;
    private javax.swing.JTextField FieldAnchoSepalo;
    private javax.swing.JTextField FieldLongitudPetalo;
    private javax.swing.JTextField FieldLongitudSepalo;
    private javax.swing.JLabel Imagen;
    private javax.swing.JLabel JprogressbarLabel;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JButton buttonDatabase;
    private javax.swing.JLabel jLabel_Resultado;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
