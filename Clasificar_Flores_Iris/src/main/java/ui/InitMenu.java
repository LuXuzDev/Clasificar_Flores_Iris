/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import back_end.Controller;
import back_end.Validator;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import infrastructure.DataBaseController;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class InitMenu extends javax.swing.JFrame {

    public InitMenu() {
        initComponents();
        design();
    }
    
    //Metodo para diseño general del Jframe
    private void design()
    {
        Flatlaf();
        UIControllers.setFontFamily("Arial");
        setIconImage(UIControllers.design().getImage());
        this.setLocationRelativeTo(null);
        barAnalize.setStringPainted(true);
        barAnalize.setVisible(false);
        JprogressbarLabel.setVisible(false);
        FieldAnchoPetalo.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"            Ancho Pétalo");
        FieldAnchoSepalo.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"            Ancho Sépalo");
        FieldLongitudPetalo.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"          Longitud Pétalo");
        FieldLongitudSepalo.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"          Longitud Sépalo");
        FieldAnchoPetalo.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true);
        FieldAnchoSepalo.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true);
        FieldLongitudPetalo.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true);
        FieldLongitudSepalo.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON,true);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(102, 153, 255));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_MAXIMIZE,false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICON,true);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICONIFFY,true);
        realTimeCheck(FieldAnchoPetalo);
        realTimeCheck(FieldAnchoSepalo);
        realTimeCheck(FieldLongitudPetalo);
        realTimeCheck(FieldLongitudSepalo);  
    }
     
    
    
    //metodo para dar el color rojo de back al textfield
    private void Error(JTextField field)
    {
        field.putClientProperty("JComponent.outline","error");
    }
    
    
    
    //metodo para revisar en tiempo real un jtextfield
    private void realTimeCheck(JTextField field)
    {
        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                check(field);
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                check(field);
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                check(field);
            }
        });
    }

    
    
    //metodo para revisar el jText field y poner el background 
    private void check(JTextField field)
    {
        if (!Validator.isCorrectInputOnlyNumbers(field.getText())) {
            Error(field);
        } else {
            field.putClientProperty("JComponent.outline", new Color(102, 153, 255));
        }
    }
    
    //metodo para verificar si todos estan llenos y empezar el analisis automatico
    public boolean checkAndStart()
    {
        boolean isCorrectInput=false;
        if (Validator.isCorrectInputOnlyNumbers(FieldAnchoPetalo.getText()) && 
            Validator.isCorrectInputOnlyNumbers(FieldAnchoSepalo.getText()) && 
            Validator.isCorrectInputOnlyNumbers(FieldLongitudPetalo.getText()) &&
            Validator.isCorrectInputOnlyNumbers(FieldLongitudSepalo.getText()))
            isCorrectInput=true;
        return isCorrectInput;
    }
 
    
   //metodo para analisis automatico de la barraprogress con hilos y reiniciar los datos
    private void startProgress(JProgressBar progressBar)
    {
        buttonAnalize.setEnabled(false);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i <= 100; i++) {
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            UIControllers.JOptioncatch(ex.getMessage());
                        }
                        progressBar.setValue(i);
                        FieldAnchoPetalo.setEnabled(false);
                        FieldAnchoSepalo.setEnabled(false);
                        FieldLongitudPetalo.setEnabled(false);
                        FieldLongitudSepalo.setEnabled(false);
                       
                    }
                    SwingUtilities.invokeLater(()->restart());
                    
                    LabelResultado.setText(Controller.getInstance().flowerType(FieldLongitudSepalo.getText(),FieldAnchoSepalo.getText()
                                                ,FieldLongitudPetalo.getText(), FieldAnchoPetalo.getText()));
                }
            }).start();
            
             
    }
    
    
    
    //metodo para reestablecer los datos
    private void restart()
    {
        if(barAnalize.getValue()==100)
        {
            barAnalize.setValue(0);
            barAnalize.setVisible(false);
            JprogressbarLabel.setVisible(false);
            FieldAnchoPetalo.setEnabled(true);
            FieldAnchoSepalo.setEnabled(true);
            FieldLongitudPetalo.setEnabled(true);
            FieldLongitudSepalo.setEnabled(true);
            buttonAnalize.setEnabled(true);
        }
    }

    
    //metodo de diseño de flatlaf
    public void Flatlaf()
    {
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
    
    
   //Funcion para poner un font general en el Jframe
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrinc = new javax.swing.JPanel();
        ButtonTrain = new javax.swing.JButton();
        buttonDatabase = new javax.swing.JButton();
        FieldAnchoPetalo = new javax.swing.JTextField();
        FieldLongitudSepalo = new javax.swing.JTextField();
        FieldAnchoSepalo = new javax.swing.JTextField();
        FieldLongitudPetalo = new javax.swing.JTextField();
        LabelResultado = new javax.swing.JLabel();
        Imagen = new javax.swing.JLabel();
        barAnalize = new javax.swing.JProgressBar();
        JprogressbarLabel = new javax.swing.JLabel();
        buttonAnalize = new javax.swing.JButton();
        buttonAnalize2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iris");
        setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrinc.setBackground(new java.awt.Color(255, 255, 255));
        panelPrinc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonTrain.setForeground(new java.awt.Color(0, 0, 0));
        ButtonTrain.setText("Entrenar");
        ButtonTrain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTrainActionPerformed(evt);
            }
        });
        panelPrinc.add(ButtonTrain, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 130, 30));

        buttonDatabase.setForeground(new java.awt.Color(0, 0, 0));
        buttonDatabase.setText("Base de datos");
        buttonDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDatabaseActionPerformed(evt);
            }
        });
        panelPrinc.add(buttonDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 130, 30));

        FieldAnchoPetalo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        FieldAnchoPetalo.setForeground(new java.awt.Color(0, 0, 0));
        FieldAnchoPetalo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FieldAnchoPetalo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        FieldAnchoPetalo.setKeymap(null);
        FieldAnchoPetalo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FieldInputsKeyReleased(evt);
            }
        });
        panelPrinc.add(FieldAnchoPetalo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 170, -1));

        FieldLongitudSepalo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        FieldLongitudSepalo.setForeground(new java.awt.Color(0, 0, 0));
        FieldLongitudSepalo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FieldLongitudSepalo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        FieldLongitudSepalo.setKeymap(null);
        FieldLongitudSepalo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FieldInputsKeyReleased(evt);
            }
        });
        panelPrinc.add(FieldLongitudSepalo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 170, -1));

        FieldAnchoSepalo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        FieldAnchoSepalo.setForeground(new java.awt.Color(0, 0, 0));
        FieldAnchoSepalo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FieldAnchoSepalo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        FieldAnchoSepalo.setKeymap(null);
        FieldAnchoSepalo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FieldInputsKeyReleased(evt);
            }
        });
        panelPrinc.add(FieldAnchoSepalo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 170, -1));

        FieldLongitudPetalo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        FieldLongitudPetalo.setForeground(new java.awt.Color(0, 0, 0));
        FieldLongitudPetalo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FieldLongitudPetalo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        FieldLongitudPetalo.setKeymap(null);
        FieldLongitudPetalo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FieldInputsKeyReleased(evt);
            }
        });
        panelPrinc.add(FieldLongitudPetalo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 170, -1));

        LabelResultado.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        LabelResultado.setForeground(new java.awt.Color(102, 153, 255));
        LabelResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelPrinc.add(LabelResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 160, 30));

        Imagen.setIcon(new FlatSVGIcon("png/bluebell.svg"));
        panelPrinc.add(Imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 70, 60));

        barAnalize.setBackground(new java.awt.Color(255, 255, 255));
        barAnalize.setToolTipText("Analizando...");
        barAnalize.setOpaque(true);
        panelPrinc.add(barAnalize, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 234, 170, 20));

        JprogressbarLabel.setBackground(new java.awt.Color(255, 255, 255));
        JprogressbarLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JprogressbarLabel.setForeground(new java.awt.Color(102, 153, 255));
        JprogressbarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JprogressbarLabel.setText("Analizando...");
        panelPrinc.add(JprogressbarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 206, 90, 30));

        buttonAnalize.setForeground(new java.awt.Color(0, 0, 0));
        buttonAnalize.setText("Analizar");
        buttonAnalize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnalizeActionPerformed(evt);
            }
        });
        panelPrinc.add(buttonAnalize, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 140, 30));

        buttonAnalize2.setForeground(new java.awt.Color(0, 0, 0));
        buttonAnalize2.setText("Inicar Modelo");
        buttonAnalize2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnalize2ActionPerformed(evt);
            }
        });
        panelPrinc.add(buttonAnalize2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 140, 30));

        getContentPane().add(panelPrinc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonTrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTrainActionPerformed
        UIControllers.Security=2;
        new SecurityPassword(this,true).setVisible(true);
    }//GEN-LAST:event_ButtonTrainActionPerformed

    private void buttonDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDatabaseActionPerformed
        UIControllers.Security=1;
        new SecurityPassword(this,true).setVisible(true);
    }//GEN-LAST:event_buttonDatabaseActionPerformed

    private void FieldInputsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FieldInputsKeyReleased
        // TODO add your handling code here:
        //Cambiar Color de los inputs aqui
    }//GEN-LAST:event_FieldInputsKeyReleased

    private void buttonAnalizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnalizeActionPerformed
        //crear icono
        FlatSVGIcon icon = new FlatSVGIcon("png/bluebell.svg");
        try {
            Validator.loadedTrainner();
            Validator.loadedDataSet();
            if(Controller.getNormalizer().getMaximos()==null || Controller.getNormalizer().getMinimos()==null)
                throw new Exception("Debe inicializar el modelo");
            
            if (checkAndStart() == true) {
                JprogressbarLabel.setVisible(true);
                barAnalize.setVisible(true);
                startProgress(barAnalize);
            } else {
                JOptionPane.showMessageDialog(null, "Debe Introducir datos correctos para analizar", "Informacion", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        } catch (Exception ex) {
            UIControllers.JOptioncatch(ex.getMessage());
        }
    }//GEN-LAST:event_buttonAnalizeActionPerformed

    private void buttonAnalize2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnalize2ActionPerformed
        FlatSVGIcon icon = new FlatSVGIcon("png/bluebell.svg");
        System.out.println(UIControllers.TrainName);
        try {
            Controller.getInstance().getTrainer().processInput(DataBaseController.fileContent(Controller.getInstance().getDataSetLoaded().getName()));
            Controller.getNormalizer().ajustar(Controller.getInstance().getTrainer().getDataSet());
            JOptionPane.showMessageDialog(null, "Modelo iniciado", "Informacion", JOptionPane.INFORMATION_MESSAGE,icon);
        } catch (Exception ex) {
            UIControllers.JOptioncatch("Error al iniciar el modelo");
        }
        
        
        //Normalizar Datos

    }//GEN-LAST:event_buttonAnalize2ActionPerformed

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
            java.util.logging.Logger.getLogger(InitMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InitMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InitMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InitMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                InitMenu init = new InitMenu();
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
    private javax.swing.JLabel LabelResultado;
    private javax.swing.JProgressBar barAnalize;
    private javax.swing.JButton buttonAnalize;
    private javax.swing.JButton buttonAnalize2;
    private javax.swing.JButton buttonDatabase;
    private javax.swing.JPanel panelPrinc;
    // End of variables declaration//GEN-END:variables
}
