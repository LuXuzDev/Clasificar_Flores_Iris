/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import back_end.Controller;
import back_end.Validator;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.util.FontUtils;
import java.awt.Color;
import java.util.ArrayList;
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
    
   
    private static ArrayList<String> data=new ArrayList<>(160);
    
    
    public ModifyDataset(ArrayList<String> datos) {
        data=datos;
        initComponents();
        design();
        labelIndication.setText("Archivo cargado: "+UIControllers.Filename);
        if(data.isEmpty() || data.get(0).isBlank())
        {
            datasetTabel(data);
        }
        
    }

    //funcion para diseño general del Jframe
    private void design()
    {
        setFontFamily("Arial");
        setIconImage(UIControllers.design().getImage());
        datasetTabel(data);
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
    
    //funcion para añadir cada elemento a la tbala
    public void datasetTabel(ArrayList<String> arreglo)
    {
        for(int i=0;i<arreglo.size();i++)
        {
            String [] rowData=arreglo.get(i).split(",");
            model.addRow(rowData);
        }
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
    
    private void setFontFamily(String fontFamily)
    {
        java.awt.Font font = UIManager.getFont("defaultFont");
        java.awt.Font newFont=FontUtils.getCompositeFont(fontFamily, font.getStyle(),font.getSize());
        UIManager.put("defaultFont", newFont);
        FlatLaf.updateUI();
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
        
    }
    
    //funcion para revisar en tiempo real los text field
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
    //funcion para poner color a los bordes del texte fiedl
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
    //funcion para poner borde de errror al text field
    private void Error(JTextField field)
    {
        field.putClientProperty("JComponent.outline","error");
    }
 
    //get de array con la informacion agregada
    private ArrayList<String> returnDataset(ArrayList<String> array)
    {
        return array;
    }
    
    //funcion para agregar a el array de datos ,lo q introduce el usuario
    private ArrayList<String> addData(int ultimo)
    {
        FlatSVGIcon icon2 = new FlatSVGIcon("png/bluebell.svg");
        data.add(widhLeaf.getText()+","+LongLeaf.getText()+","+widthStem.getText()+","+LongStem.getText()+","+ComboBoxIris.getSelectedItem().toString());
        model.setRowCount(0);
        datasetTabel(data);
        System.out.println(data.size());
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
        //Controller.getInstance().editFile(line, name);
        int ultimo=data.size();
        String[] botones = {"Si", "No"};
        FlatSVGIcon icon2=new FlatSVGIcon("png/bluebell.svg");
        if (data.isEmpty() || data.get(0).isBlank()) {
            if (Validator.isCorrectInputOnlyNumbers(widhLeaf.getText()) && Validator.isCorrectInputOnlyNumbers(widthStem.getText()) && Validator.isCorrectInputOnlyNumbers(LongLeaf.getText()) && Validator.isCorrectInputOnlyNumbers(LongStem.getText()) && ComboBoxIris.getSelectedItem() != " ") {
                //esto es el caso si la tabla esta vacia 
                //UIcontrollers.filename=nombre del archivo
                //data=array
                //la funcion de rellenar tabla
                
                JOptionPane.showMessageDialog(null, "Datos guardados exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE, icon2);
            } else {
                JOptionPane.showMessageDialog(null, "Debe Introducir datos correctos para agregar al dataset", "Informacion", JOptionPane.INFORMATION_MESSAGE, icon2);
            }
        }
        else
        {
            if (Validator.isCorrectInputOnlyNumbers(widhLeaf.getText()) && Validator.isCorrectInputOnlyNumbers(widthStem.getText()) && Validator.isCorrectInputOnlyNumbers(LongLeaf.getText()) && Validator.isCorrectInputOnlyNumbers(LongStem.getText()) && ComboBoxIris.getSelectedItem() != " ") {
                int resultado = JOptionPane.showOptionDialog(null, "Desea guardrar los cambios realizados", "Guardar cambios", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon2, botones, botones[0]);
                if (resultado == JOptionPane.YES_OPTION) {
                    if(Validator.MaxTam(data)==true)
                    {
                        JOptionPane.showMessageDialog(null, "Este es el ultimo cambio que puede guadar.Solo hasta 10 modificaciones", "Informacion", JOptionPane.INFORMATION_MESSAGE, icon2);
                        buttonEnter.setEnabled(false);
                    }
                    else
                    {
                        //esto es el caso si la tabla tiene elemtnos 
                        //UIcontrollers.filename=nombre del archivo
                        //data=arraydevalores
                        //la funcion de rellenar tabla
                        JOptionPane.showMessageDialog(null, "Datos guardados exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE, icon2);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se guardaron los cambios", "Informacion", JOptionPane.INFORMATION_MESSAGE, icon2);
                }
                
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelIndication;
    private javax.swing.JTable tableData;
    private javax.swing.JTextField widhLeaf;
    private javax.swing.JTextField widthStem;
    // End of variables declaration//GEN-END:variables
}
