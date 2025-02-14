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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kris
 */
public class ModifyDataset extends javax.swing.JFrame {

    String[] columnas={"Ancho petalo","Longitud petalo","Ancho sepalo","Longitud sepalo","Resultado"};
    DefaultTableModel model = new DefaultTableModel(columnas, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private static Object [][] data= new Object[160][5];
    private static Object [][] dataTest= new Object[160][5];
    private static ArrayList<String> array=new ArrayList<>();
    
    
    public ModifyDataset(Object[][] datos) {
        data=datos;
        dataTest=datos;
        initComponents();
        design();
        if(!UIControllers.Filename.isBlank())
        {
            labelIndication.setText("Archivo cargado: "+UIControllers.Filename);
        }
        if(data[0][0]!=null)
        {
            datasetTabel(data);
        }
        
    }

    //funcion para diseño general del Jframe
    private void design()
    {
        setFontFamily("Arial");
        setIconImage(UIControllers.design().getImage());
        buttonSafe.setEnabled(false);
        Flatlaf();
        widhLeaf.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"AnchoP");
        widthStem.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"AnchoS");
        LongLeaf.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Long P");
        LongStem.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT," Long S");
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(102, 153, 255));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_MAXIMIZE,false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICON,true);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICONIFFY,true);
        this.setLocationRelativeTo(null);
        realTimeCheck(widhLeaf);
        realTimeCheck(LongLeaf);
        realTimeCheck(widthStem);
        realTimeCheck(LongStem);
    }
    
    
    private void datasetTabel(Object[][] datos)
    {
        for (Object[] fila : data)
        {
            model.addRow(fila);
        }
    }
    
    public void Flatlaf()
    {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatMacLightLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(InitMenu.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private void realTimeCheck(JTextField field)
    {
        field.getDocument().addDocumentListener(new DocumentListener()
        {
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
    private void check(JTextField field)
    {
        if (!Validator.isCorrectInputOnlyNumbers(field.getText())) {
            Error(field);
        }
        else
        {
            field.putClientProperty("JComponent.outline",new Color(102, 153, 255));
        }
    }
    
    private void Error(JTextField field)
    {
        field.putClientProperty("JComponent.outline","error");
    }
    
    private int lastIndex(Object[][] datos)
    {
        int i=0;
        int j=0;
        int retorno=0;
        boolean end=true;
        
        
        for(i=0;i<datos.length && end==true;i++)
        {
            for(j=0;j<datos[i].length;j++)
            {
                if(datos[i][j]== null)
                {
                    retorno=i;
                    
                    end=false;
                }
            }
        }
        return retorno;
    }
    
    private Object[][] returnDataset(Object[][] datos)
    {
        return datos;
    }
    
    private Object[][] addData(int ultimo)
    {
        FlatSVGIcon icon2 = new FlatSVGIcon("png/bluebell.svg");
        ultimo = lastIndex(data);
        data[ultimo][0] = widhLeaf.getText();
        data[ultimo][1] = LongLeaf.getText();
        data[ultimo][2] = widthStem.getText();
        data[ultimo][3] = LongStem.getText();
        data[ultimo++][4] = ComboBoxIris.getSelectedItem().toString();
        model.setRowCount(0);
        datasetTabel(data);
        if (ultimo == 160) {
            JOptionPane.showMessageDialog(null, "Ya alcanzo el maximo de elementos a agregar en el dataset", "Advertencia", JOptionPane.INFORMATION_MESSAGE, icon2);
            buttonEnter.setEnabled(false);
        }
        System.out.println(data.length);
        return data;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrin = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable(model);
        buttonBack = new javax.swing.JButton();
        widhLeaf = new javax.swing.JTextField();
        LongLeaf = new javax.swing.JTextField();
        widthStem = new javax.swing.JTextField();
        buttonEnter = new javax.swing.JButton();
        labelIndication = new javax.swing.JLabel();
        LongStem = new javax.swing.JTextField();
        ComboBoxIris = new javax.swing.JComboBox<>();
        buttonSafe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iris");
        setResizable(false);

        PanelPrin.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tableData.setModel(model);
        jScrollPane1.setViewportView(tableData);

        PanelPrin.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 460, 210));

        buttonBack.setIcon(new FlatSVGIcon("png/arrow.svg"));
        buttonBack.setBackground(new java.awt.Color(255, 255, 255));
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });
        PanelPrin.add(buttonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 50, 40));

        widhLeaf.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrin.add(widhLeaf, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 70, -1));

        LongLeaf.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrin.add(LongLeaf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 70, -1));

        widthStem.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrin.add(widthStem, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 70, -1));

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
        labelIndication.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelPrin.add(labelIndication, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 340, -1));

        LongStem.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrin.add(LongStem, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 70, -1));

        ComboBoxIris.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ","Iris-setosa", "Iris-versicolor", "Iris-virginica", }));
        PanelPrin.add(ComboBoxIris, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 110, 30));

        buttonSafe.setText("Guardar");
        buttonSafe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSafeActionPerformed(evt);
            }
        });
        PanelPrin.add(buttonSafe, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, -1, -1));

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
        
        //Object[] fila2={widhLeaf.getText(),LongLeaf.getText(),widthStem.getText(),LongStem.getText(),ComboBoxIris.getSelectedItem().toString()};
        //model.addRow(fila2);
        int ultimo=0;
        buttonSafe.setEnabled(true);
        FlatSVGIcon icon2=new FlatSVGIcon("png/bluebell.svg");
        if (data[0][0] == null) {
            if (Validator.isCorrectInputOnlyNumbers(widhLeaf.getText()) && Validator.isCorrectInputOnlyNumbers(widthStem.getText()) && Validator.isCorrectInputOnlyNumbers(LongLeaf.getText()) && Validator.isCorrectInputOnlyNumbers(LongStem.getText()) && ComboBoxIris.getSelectedItem() != " ") {
                Object[] fila3 = {widhLeaf.getText(), LongLeaf.getText(), widthStem.getText(), LongStem.getText(), ComboBoxIris.getSelectedItem().toString()};
                model.addRow(fila3);
            } else {
                JOptionPane.showMessageDialog(null, "Debe Introducir datos correctos para agregar al dataset", "Informacion", JOptionPane.INFORMATION_MESSAGE, icon2);
            }
        }
        else
        {
            if (Validator.isCorrectInputOnlyNumbers(widhLeaf.getText()) && Validator.isCorrectInputOnlyNumbers(widthStem.getText()) && Validator.isCorrectInputOnlyNumbers(LongLeaf.getText()) && Validator.isCorrectInputOnlyNumbers(LongStem.getText()) && ComboBoxIris.getSelectedItem() != " ") {
                addData(ultimo);
            } else {
                JOptionPane.showMessageDialog(null, "Debe Introducir datos correctos para agregar al dataset", "Informacion", JOptionPane.INFORMATION_MESSAGE, icon2);
            }
        } 
        ComboBoxIris.setSelectedItem(" ");
        widhLeaf.setText("");
        LongLeaf.setText("");
        widthStem.setText("");
        LongStem.setText("");
        widhLeaf.putClientProperty("JComponent.outline",new Color(102, 153, 255));
        LongLeaf.putClientProperty("JComponent.outline",new Color(102, 153, 255));
        widthStem.putClientProperty("JComponent.outline",new Color(102, 153, 255));
        LongStem.putClientProperty("JComponent.outline",new Color(102, 153, 255));
    }//GEN-LAST:event_buttonEnterActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        new DataBaseMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonSafeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSafeActionPerformed
        FlatSVGIcon icon2=new FlatSVGIcon("png/bluebell.svg");
        String [] botones={"Si","No"};
        int resultado=JOptionPane.showOptionDialog(null, "Desea guardrar los cambios realizados", "Guardar cambios", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon2, botones, botones[0]);
        if(resultado==JOptionPane.YES_OPTION)
        {
            returnDataset(data);
        }
        else
        {
            returnDataset(dataTest);
        }
        
    }//GEN-LAST:event_buttonSafeActionPerformed

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
                new ModifyDataset(data).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxIris;
    private javax.swing.JTextField LongLeaf;
    private javax.swing.JTextField LongStem;
    private javax.swing.JPanel PanelPrin;
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonEnter;
    private javax.swing.JButton buttonSafe;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelIndication;
    private javax.swing.JTable tableData;
    private javax.swing.JTextField widhLeaf;
    private javax.swing.JTextField widthStem;
    // End of variables declaration//GEN-END:variables
}
