/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import back_end.Validator;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.util.FontUtils;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kris
 */
public class ModifyDataset extends javax.swing.JFrame {

    
    String[] columnas={"Ancho petalo","Ancho sepalo","Longitud petalo","Longitud sepalo","Resultado"};
    DefaultTableModel model=new DefaultTableModel(columnas, 0)
    {
        @Override
        public boolean isCellEditable(int row,int column)
        {
            return false;
        }
    };
    
    public ModifyDataset() {
        initComponents();
        Flatlaf();
        setFontFamily("Arial");
        UIManager.put("TextComponent.arc",9);
        UIManager.put("Button.arc", 25);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(102, 153, 255));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_MAXIMIZE,false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICON,true);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICONIFFY,true);
        FlatSVGIcon icon=new FlatSVGIcon("png/bluebell.svg");
        setIconImage(icon.getImage());
        this.setLocationRelativeTo(null);
    }

    
    public void Flatlaf()
    {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatMacLightLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Init_Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
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

        PanelPrin = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable(model);
        buttonBack = new javax.swing.JButton();
        textField1 = new javax.swing.JTextField();
        textField2 = new javax.swing.JTextField();
        textField3 = new javax.swing.JTextField();
        textField4 = new javax.swing.JTextField();
        buttonEnter = new javax.swing.JButton();
        labelIndication = new javax.swing.JLabel();
        textField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iris");

        PanelPrin.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tableData.setModel(model);
        jScrollPane1.setViewportView(tableData);

        PanelPrin.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 460, 210));

        buttonBack.setIcon(new FlatSVGIcon("png/arrow.svg"));
        buttonBack.setBackground(new java.awt.Color(255, 255, 255));
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });
        PanelPrin.add(buttonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 50, 40));

        textField1.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrin.add(textField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 110, -1));

        textField2.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrin.add(textField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        textField3.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrin.add(textField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        textField4.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrin.add(textField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, -1));

        buttonEnter.setBackground(new java.awt.Color(255, 255, 255));
        buttonEnter.setForeground(new java.awt.Color(0, 0, 0));
        buttonEnter.setText("Entrar");
        buttonEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnterActionPerformed(evt);
            }
        });
        PanelPrin.add(buttonEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 70, -1));

        labelIndication.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelIndication.setForeground(new java.awt.Color(102, 153, 255));
        labelIndication.setText("Nuevo.dat");
        PanelPrin.add(labelIndication, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 340, -1));

        textField5.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrin.add(textField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 60, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrin, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrin, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnterActionPerformed
        
        if(Validator.isCorrectInputOnlyNumbers(textField2.getText()) && Validator.isCorrectInputOnlyNumbers(textField4.getText()) && Validator.isCorrectInputOnlyNumbers(textField3.getText())  &&  Validator.isCorrectInputOnlyNumbers(textField1.getText()))
                {
                    Object[] fila={textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText(),textField1.getText()};
                    model.addRow(fila);
                }
        Object[] fila={textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText(),textField1.getText()};
        model.addRow(fila);
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        
    }//GEN-LAST:event_buttonEnterActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        new DataBaseMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonBackActionPerformed

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
            java.util.logging.Logger.getLogger(ModifyDataset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyDataset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyDataset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyDataset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyDataset().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrin;
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonEnter;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelIndication;
    private javax.swing.JTable tableData;
    private javax.swing.JTextField textField1;
    private javax.swing.JTextField textField2;
    private javax.swing.JTextField textField3;
    private javax.swing.JTextField textField4;
    private javax.swing.JTextField textField5;
    // End of variables declaration//GEN-END:variables
}
