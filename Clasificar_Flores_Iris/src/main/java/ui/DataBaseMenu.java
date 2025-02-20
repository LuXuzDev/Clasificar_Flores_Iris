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
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class DataBaseMenu extends javax.swing.JFrame {

    private static boolean check=false;
    private static Timer timer;
    private DefaultListModel<String> listModel= new DefaultListModel<>();
    private static ArrayList<String> datos= new ArrayList<>(160);

 
    public DataBaseMenu() {
        initComponents();
        design();
        addStringList(Controller.getInstance().loadedFilesName());
        
        timer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LabelSuccess.setText("");
                LabelSuccess.setVisible(false);
            }
        });
        timer.setRepeats(false);
    }
    
    
    //metodo para diseño general del Jframe
    private void design()
    {
        LabelSuccess.setVisible(false);
        Flatlaf();
        setIconImage(UIControllers.design().getImage());
        this.setLocationRelativeTo(null); 
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(102, 153, 255));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_MAXIMIZE,false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICON,true);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICONIFFY,true);
    }
    
    
    //metodo para reestablecer el timer para enseñar el JLabel de archivo cargado
    private void restartTimer()
    {
        timer.stop();
        timer.start();
    }
    
    
    //metodo de diseño 
     public void Flatlaf()
    {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatMacLightLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (UnsupportedLookAndFeelException ex) {
                UIControllers.JOptioncatch(ex.getMessage());
            }
        });
    }
     
     
     
     //metodo cargar lista de nombres de ficheros para el JList
     private void addStringList(ArrayList<String> path) {

        // Verifica si ListTrain tiene un modelo de lista
        if (Validator.ListInstanceOf(ListTrain)) {
            listModel = (DefaultListModel<String>) ListTrain.getModel();
        } else {
            listModel = new DefaultListModel<>();
            ListTrain.setModel(listModel);
        }

        // Vacía el modelo de lista antes de cargar nuevos elementos
        listModel.clear();

        // Agrega los nuevos elementos desde la lista path
        for (int i = 0; i < path.size(); i++) {
            listModel.add(i, path.get(i));
        }
    }
     
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrinc = new javax.swing.JPanel();
        ButtonBack = new javax.swing.JButton();
        ButtonEdit = new javax.swing.JButton();
        LabelDatasetLoaded = new javax.swing.JLabel();
        ButtonLoad = new javax.swing.JButton();
        LabelSuccess = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListTrain = new javax.swing.JList<>();
        ButtonCreate = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iris");
        setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        setResizable(false);

        panelPrinc.setBackground(new java.awt.Color(255, 255, 255));
        panelPrinc.setFont(null);
        panelPrinc.setPreferredSize(new java.awt.Dimension(610, 340));
        panelPrinc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonBack.setIcon(new FlatSVGIcon("png/arrow.svg"));
        ButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBackActionPerformed(evt);
            }
        });
        panelPrinc.add(ButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 40, 30));

        ButtonEdit.setText("Modificar dataset");
        ButtonEdit.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                ButtonEditComponentResized(evt);
            }
        });
        ButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditActionPerformed(evt);
            }
        });
        panelPrinc.add(ButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 130, 30));

        LabelDatasetLoaded.setBackground(new java.awt.Color(255, 255, 255));
        LabelDatasetLoaded.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelDatasetLoaded.setForeground(new java.awt.Color(102, 153, 255));
        LabelDatasetLoaded.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelDatasetLoaded.setText("Dataset Cargados");
        panelPrinc.add(LabelDatasetLoaded, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 220, 30));

        ButtonLoad.setText("Importar dataset");
        ButtonLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoadActionPerformed(evt);
            }
        });
        panelPrinc.add(ButtonLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 130, 30));

        LabelSuccess.setBackground(new java.awt.Color(255, 255, 255));
        LabelSuccess.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LabelSuccess.setForeground(new java.awt.Color(0, 0, 0));
        LabelSuccess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelSuccess.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 153, 255)));
        panelPrinc.add(LabelSuccess, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 220, 20));

        ListTrain.setBackground(new java.awt.Color(255, 255, 255));
        ListTrain.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ListTrain.setForeground(new java.awt.Color(102, 153, 255));
        ListTrain.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        ListTrain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListTrainMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListTrain);

        panelPrinc.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 220, 150));

        ButtonCreate.setText("Crear dataset");
        ButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCreateActionPerformed(evt);
            }
        });
        panelPrinc.add(ButtonCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, 30));

        buttonDelete.setText("Eliminar");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });
        panelPrinc.add(buttonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 223, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrinc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrinc, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void ButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackActionPerformed
        new InitMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonBackActionPerformed

    private void ButtonEditComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ButtonEditComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEditComponentResized
//boton cargar action
    private void ButtonLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoadActionPerformed
        FlatSVGIcon icon=new FlatSVGIcon("png/bluebell.svg");
        JFileChooser filetxt = new JFileChooser();
        int option = filetxt.showOpenDialog(this);
        if (Validator.aprooveJfilechooser(option)) {
            File file = filetxt.getSelectedFile();
            String FileName = file.getName();
            
                String path = filetxt.getSelectedFile().getAbsolutePath();
                DefaultListModel<String> listModel;
                if (Validator.ListInstanceOf(ListTrain)) {
                    listModel = (DefaultListModel<String>) ListTrain.getModel();
                } else {
                    listModel = new DefaultListModel<>();
                    ListTrain.setModel(listModel);
                }
                if (Validator.isEmptyInput(FileName)) {
                    listModel.addElement(FileName);
                    UIControllers.icon = true;
                    LabelSuccess.setVisible(true);
                    LabelSuccess.setText("Archivo cargado");
                    restartTimer();
                    
                }
            try {
                Controller.getInstance().importFile(path);
            } catch (Exception ex) {
                UIControllers.JOptioncatch(ex.getMessage());
            }
                addStringList(Controller.getInstance().loadedFilesName());

        } else {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningun archivo", "Error", JOptionPane.ERROR_MESSAGE, icon);
        }
    }//GEN-LAST:event_ButtonLoadActionPerformed

    private void ButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditActionPerformed
        FlatSVGIcon icon2=new FlatSVGIcon("png/bluebell.svg");
        
        if (Validator.checkList(ListTrain) == true) {
            String path2 = ListTrain.getSelectedValue();
            try {
                System.out.println("Path2" + path2);
                UIControllers.Filename = path2;
                new ModifyDataset(Controller.getInstance().fileContent(path2)).setVisible(true);
                this.dispose();
            } catch (Exception ex) {
                UIControllers.JOptioncatch(ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar en la lista un dataset para modificar", "Error", JOptionPane.INFORMATION_MESSAGE, icon2);
        }     
    }//GEN-LAST:event_ButtonEditActionPerformed

    private void ButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCreateActionPerformed
        UIControllers.NumberOptionPane=2;
        JOptionpane pane = new JOptionpane(this, true);
        pane.setVisible(true);
        if(UIControllers.Joption==true)
        {
            LabelSuccess.setVisible(true);
            LabelSuccess.setText("Archivo cargado");
            restartTimer();
            
            try {
                UIControllers.Filename = UIControllers.newFilename;
                Controller.getInstance().createFile(UIControllers.Filename);
                addStringList(Controller.getInstance().loadedFilesName());
            } catch (IOException ex) {
                 UIControllers.JOptioncatch(ex.getMessage());
            }
        }
    }//GEN-LAST:event_ButtonCreateActionPerformed

    private void ListTrainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListTrainMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ListTrainMouseClicked

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        FlatSVGIcon icon2 = new FlatSVGIcon("png/bluebell.svg");

        if (Validator.checkList(ListTrain) == true) {
            String[] botones = {"Si", "No"};
            int result = JOptionPane.showOptionDialog(null, "¿Seguro desea eliminar este dataset?", "Eliminar dataset", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon2, botones, botones[0]);
            if (Validator.YesOptionJOption(result) && Validator.checkList(ListTrain)) {
                String selectedValue = ListTrain.getSelectedValue();
                try {
                    Controller.getInstance().deleteFile(selectedValue);
                    addStringList(Controller.getInstance().loadedFilesName());
                } catch (Exception ex) {
                    UIControllers.JOptioncatch(ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar en la lista un dataset para eliminarlo", "Información", JOptionPane.INFORMATION_MESSAGE, icon2);
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new DataBaseMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBack;
    private javax.swing.JButton ButtonCreate;
    private javax.swing.JButton ButtonEdit;
    private javax.swing.JButton ButtonLoad;
    private javax.swing.JLabel LabelDatasetLoaded;
    private javax.swing.JLabel LabelSuccess;
    private javax.swing.JList<String> ListTrain;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelPrinc;
    // End of variables declaration//GEN-END:variables
}
