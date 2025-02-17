/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui;

import back_end.TrainerResults;
import back_end.Validator;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Kris
 */
public class JOptionpane extends javax.swing.JDialog {

    
    public JOptionpane(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        UIControllers.newFilename="";
        UIControllers.ComboboxName="";
        UIControllers.TrainName="";
        
        initComponents();
        PanelTrainMenu.setVisible(true);
        PanelComboBox.setVisible(false);
        PanelTextField.setVisible(false);
        if(UIControllers.NumberOptionPane==1)
        {
            this.setTitle("Seleccionar dataset");
            PanelComboBox.setVisible(true);
            PanelTextField.setVisible(false);
            PanelTrainMenu.setVisible(false);
        }
        else if(UIControllers.NumberOptionPane==2)
        {
            this.setTitle("Crear dataset");
            PanelComboBox.setVisible(false);
            PanelTextField.setVisible(true);
            PanelTrainMenu.setVisible(false);
        }
        else if(UIControllers.NumberOptionPane==3)
        {
            this.setTitle("Crear entrenamiento");
            PanelTrainMenu.setVisible(true);
            PanelComboBox.setVisible(false);
            PanelTextField.setVisible(false);
        }
        design();
    }

   
    private void design()
    {
        
        UIControllers.Joption=false;
        FlatSVGIcon icon=new FlatSVGIcon("png/bluebell.svg");
        LabelIcon.setIcon(icon);
        LabelIconCombo.setIcon(icon);
        this.setSize(357, 171);
        UIControllers.setFontFamily("Arial");
        setIconImage(UIControllers.design().getImage());
        Flatlaf();
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(102, 153, 255));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_MAXIMIZE,false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICON,true);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICONIFFY,true);
        this.setLocationRelativeTo(null);
        
        //TrainmenuMetricas
        UIControllers.NamesLabelsTrainMenu(LabelEpocas, LabelAccuracy, LabelError);
        LabelCaution.setText("El nombre solo contiene letras");
        LabelCaution.setForeground(Color.red);
        LabelCaution.setText("Ingrese el nombre");
        LabelCaution.setForeground(new Color(102, 153, 255));
        FieldNameTrain.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(Validator.containsNumber(FieldNameTrain.getText()))
                {
                    FieldNameTrain.putClientProperty("JComponent.outline","error");
                    LabelCaution.setText("El nombre solo contiene letras");
                    LabelCaution.setForeground(Color.red);
                }
                else
                {
                    FieldNameTrain.putClientProperty("JComponent.outline",new Color(102, 153, 255));
                    LabelCaution.setText("");
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                if(Validator.containsNumber(FieldNameTrain.getText()))
                {
                    FieldNameTrain.putClientProperty("JComponent.outline","error");
                    LabelCaution.setText("El nombre solo contiene letras");
                    LabelCaution.setForeground(Color.red);
                }
                else
                {
                    FieldNameTrain.putClientProperty("JComponent.outline",new Color(102, 153, 255));
                    LabelCaution.setText("");
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                if(Validator.containsNumber(FieldNameTrain.getText()))
                {
                    FieldNameTrain.putClientProperty("JComponent.outline","error");
                    LabelCaution.setText("El nombre solo contiene letras");
                    LabelCaution.setForeground(Color.red);
                }
                else
                {
                    FieldNameTrain.putClientProperty("JComponent.outline",new Color(102, 153, 255));
                    LabelCaution.setText("");
                }
            }
        });
    
   
    
        
        //COMBOBOX DIALOG
        LabelIndicatorCombo.setText("Debe ingresar una opcion valida");
        LabelIndicatorCombo.setForeground(Color.red);
        LabelIndicatorCombo.setVisible(false);
        ComboBoxDialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) ComboBoxDialog.getSelectedItem();
                if (selectedItem.equals(" ")) {
                    LabelIndicatorCombo.setVisible(true);
                } else {
                    LabelIndicatorCombo.setVisible(false);
                }
            }
        });
        
        //TEXTFIELD DIALOG
        Labelprin.setText("Debe ingresar el nombre del dataset");
        Labelprin.setForeground(new Color(102, 153, 255));
        FieldPrin.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(!Validator.isCorrectInputOnlyLetter(FieldPrin.getText()))
                {
                    FieldPrin.putClientProperty("JComponent.outline","error");
                    Labelprin.setText("El texto debe contener letras");
                    Labelprin.setForeground(Color.red);
                }
                else
                {
                    FieldPrin.putClientProperty("JComponent.outline",new Color(102, 153, 255));
                    Labelprin.setText("");
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                if(Validator.containsNumber(FieldPrin.getText()))
                {
                    FieldPrin.putClientProperty("JComponent.outline","error");
                    Labelprin.setText("El texto no debe contener numeros");
                    Labelprin.setForeground(Color.red);
                }
                else
                {
                    FieldPrin.putClientProperty("JComponent.outline",new Color(102, 153, 255));
                    Labelprin.setText("");
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                if(Validator.containsNumber(FieldPrin.getText()))
                {
                    FieldPrin.putClientProperty("JComponent.outline","error");
                    Labelprin.setText("El texto no debe contener numeros");
                    Labelprin.setForeground(Color.red);
                }
                else
                {
                    FieldPrin.putClientProperty("JComponent.outline",new Color(102, 153, 255));
                    Labelprin.setText("");
                }
            }
        });
    
    }
    
    
        
    
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTrainMenu = new javax.swing.JPanel();
        FieldNameTrain = new javax.swing.JTextField();
        LabelEpocas = new javax.swing.JLabel();
        LabelError = new javax.swing.JLabel();
        LabelAccuracy = new javax.swing.JLabel();
        buttonSave = new javax.swing.JButton();
        buttonDiscard = new javax.swing.JButton();
        LabelCaution = new javax.swing.JLabel();
        PanelComboBox = new javax.swing.JPanel();
        ComboBoxDialog = new javax.swing.JComboBox<>();
        buttonYesCombo = new javax.swing.JButton();
        buttonNoCombo = new javax.swing.JButton();
        LabelIndicatorCombo = new javax.swing.JLabel();
        LabelIconCombo = new javax.swing.JLabel();
        PanelTextField = new javax.swing.JPanel();
        LabelIcon = new javax.swing.JLabel();
        buttonNO = new javax.swing.JButton();
        buttonYes = new javax.swing.JButton();
        FieldPrin = new javax.swing.JTextField();
        Labelprin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        PanelTrainMenu.setBackground(new java.awt.Color(255, 255, 255));
        PanelTrainMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelTrainMenu.add(FieldNameTrain, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 190, 30));

        LabelEpocas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelEpocas.setText("Epocas: ");
        PanelTrainMenu.add(LabelEpocas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 110, -1));

        LabelError.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelError.setText("Error: ");
        PanelTrainMenu.add(LabelError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, -1));

        LabelAccuracy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelAccuracy.setText("Metricas: ");
        PanelTrainMenu.add(LabelAccuracy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 110, -1));

        buttonSave.setBackground(new java.awt.Color(0, 153, 255));
        buttonSave.setForeground(new java.awt.Color(255, 255, 255));
        buttonSave.setText("Guardar");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });
        PanelTrainMenu.add(buttonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 90, 30));

        buttonDiscard.setText("Descartar");
        buttonDiscard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDiscardActionPerformed(evt);
            }
        });
        PanelTrainMenu.add(buttonDiscard, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 90, 30));

        LabelCaution.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTrainMenu.add(LabelCaution, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 180, 20));

        PanelComboBox.setBackground(new java.awt.Color(255, 255, 255));
        PanelComboBox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ComboBoxDialog.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Pepe", "Juan" }));
        ComboBoxDialog.setSelectedItem("");
        PanelComboBox.add(ComboBoxDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 170, 40));

        buttonYesCombo.setBackground(new java.awt.Color(0, 153, 255));
        buttonYesCombo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonYesCombo.setForeground(new java.awt.Color(255, 255, 255));
        buttonYesCombo.setText("Si");
        buttonYesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonYesComboActionPerformed(evt);
            }
        });
        PanelComboBox.add(buttonYesCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        buttonNoCombo.setText("No");
        buttonNoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNoComboActionPerformed(evt);
            }
        });
        PanelComboBox.add(buttonNoCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));
        PanelComboBox.add(LabelIndicatorCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 220, 20));
        PanelComboBox.add(LabelIconCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 70, 70));

        PanelTextField.setBackground(new java.awt.Color(255, 255, 255));
        PanelTextField.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelTextField.add(LabelIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 80));

        buttonNO.setText("No");
        buttonNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNOActionPerformed(evt);
            }
        });
        PanelTextField.add(buttonNO, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        buttonYes.setBackground(new java.awt.Color(0, 153, 255));
        buttonYes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonYes.setForeground(new java.awt.Color(255, 255, 255));
        buttonYes.setText("Si");
        buttonYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonYesActionPerformed(evt);
            }
        });
        PanelTextField.add(buttonYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));
        PanelTextField.add(FieldPrin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 190, 30));
        PanelTextField.add(Labelprin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 220, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelTrainMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelTrainMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonYesActionPerformed
        FlatSVGIcon icon2=new FlatSVGIcon("png/bluebell.svg");
        if (!Validator.containsNumber(FieldPrin.getText()) && !Validator.isEmptyInput(FieldPrin.getText())) {
            UIControllers.Joption=true;
            UIControllers.newFilename=FieldPrin.getText()+".data";
            this.dispose();
        }
        else
        {
            this.dispose();
            JOptionPane.showMessageDialog(null, "Los datos ingresados son erroneos no se guardaran los cambios", "Error", JOptionPane.ERROR_MESSAGE, icon2);
        }
        
    }//GEN-LAST:event_buttonYesActionPerformed

    private void buttonYesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonYesComboActionPerformed
        FlatSVGIcon icon=new FlatSVGIcon("png/bluebell.svg");
        if(ComboBoxDialog.getSelectedItem().equals(" "))
        {
            this.dispose();
            JOptionPane.showOptionDialog(null, "No se cargo el dataset.Datos incorrectos", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, null, null); 
        }
        else
        {
            this.dispose();
            UIControllers.JoptionCombo=true;
            UIControllers.ComboboxName=ComboBoxDialog.getSelectedItem().toString();
        }
    }//GEN-LAST:event_buttonYesComboActionPerformed

    private void buttonNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNOActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonNOActionPerformed

    private void buttonNoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNoComboActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonNoComboActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        FlatSVGIcon icon=new FlatSVGIcon("png/bluebell.svg");
        if (!Validator.containsNumber(FieldNameTrain.getText()) && !Validator.isEmptyInput(FieldNameTrain.getText())) {
            UIControllers.JoptionTrainMenu=true;
            UIControllers.TrainName=FieldNameTrain.getText();
            this.dispose();
        }
        else
        {
            this.dispose();
            JOptionPane.showMessageDialog(null, "Los datos ingresados son erroneos no se guardaran los cambios", "Error", JOptionPane.ERROR_MESSAGE, icon);
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonDiscardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDiscardActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonDiscardActionPerformed

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
            java.util.logging.Logger.getLogger(JOptionpane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JOptionpane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JOptionpane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JOptionpane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JOptionpane dialog = new JOptionpane(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxDialog;
    private javax.swing.JTextField FieldNameTrain;
    private javax.swing.JTextField FieldPrin;
    private javax.swing.JLabel LabelAccuracy;
    private javax.swing.JLabel LabelCaution;
    private javax.swing.JLabel LabelEpocas;
    private javax.swing.JLabel LabelError;
    private javax.swing.JLabel LabelIcon;
    private javax.swing.JLabel LabelIconCombo;
    private javax.swing.JLabel LabelIndicatorCombo;
    private javax.swing.JLabel Labelprin;
    private javax.swing.JPanel PanelComboBox;
    private javax.swing.JPanel PanelTextField;
    private javax.swing.JPanel PanelTrainMenu;
    private javax.swing.JButton buttonDiscard;
    private javax.swing.JButton buttonNO;
    private javax.swing.JButton buttonNoCombo;
    private javax.swing.JButton buttonSave;
    private javax.swing.JButton buttonYes;
    private javax.swing.JButton buttonYesCombo;
    // End of variables declaration//GEN-END:variables
}
