/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import back_end.Validator;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import static ui.UIControllers.path;



public class DataBaseMenu extends javax.swing.JFrame {

    private static boolean check=false;
    private boolean valid=false;
    private static Timer timer;
    private DefaultListModel<String> listModel= new DefaultListModel<>();
    private static Object [][] datos = new Object[160][5];
    private static Object [][] datos1 = new Object[160][5];
    private boolean trainCheck=false;
    
 
    public DataBaseMenu() {
        initComponents();
        design();
        if(addMouse()==true)
        {
           this.dispose();
            
        }
        if(!UIControllers.path.isEmpty())
        {
            addStringList(UIControllers.path,UIControllers.pathNumber);
        }
        timer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LabelSuccess.setText("");
                LabelSuccess.setVisible(false);
            }
        });
        timer.setRepeats(false);
        
       
    }
    
    //funcion para diseño general del Jframe
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
    
    
    //metodo para agregarle el funcionamiento del doble click en el jlist
    private boolean addMouse()
    {
        ListTrain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Verificar si fue un doble clic
                if (e.getClickCount() == 2) {
                    ArrayList<String> meta = new ArrayList<>();
                    FlatSVGIcon icon2 = new FlatSVGIcon("png/bluebell.svg");
                    if (ListTrain.getSelectedValue() != null && ListTrain.getSelectedValue().endsWith(".data")) {
                        check = true;
                        String path2 = ListTrain.getSelectedValue().toString();
                        UIControllers.Filename = path2;
                        new ModifyDataset(datos).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar en la lista un dataset para modificar", "Informacion", JOptionPane.INFORMATION_MESSAGE, icon2);
                    }
                }
            }
        });
        return check;
    }
    //metodo para reestablecer el timer para enseñar el JLabel de archivo cargado
    private void restartTimer()
    {
        timer.stop();
        timer.start();
    }
    
     public void Flatlaf()
    {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatMacLightLaf());
                SwingUtilities.updateComponentTreeUI(this);
                

            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(DataBaseMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
     //cargar lista de nombres de ficheros para el JList
     public void addStringList(ArrayList<String> path,int number)
     {
         
         if (ListTrain.getModel() instanceof DefaultListModel) {
             listModel = (DefaultListModel<String>) ListTrain.getModel();
         } else {
             listModel = new DefaultListModel<>();
             ListTrain.setModel(listModel);
         }
         for(int i=number;i<path.size();i++)
         {
             listModel.add(i, path.get(i));
         }
     }
     //
      public void createTable(boolean add,String filename)
    {
        if(add==true)
        {
            listModel.addElement(filename);
        }
    }
     
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ButtonBack = new javax.swing.JButton();
        ButtonEdit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(null);
        jPanel1.setPreferredSize(new java.awt.Dimension(610, 340));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonBack.setIcon(new FlatSVGIcon("png/arrow.svg"));
        ButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBackActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 40, 30));

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
        jPanel1.add(ButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 130, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dataset Cargados");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 220, 30));

        ButtonLoad.setText("Cargar dataset");
        ButtonLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoadActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 130, 30));

        LabelSuccess.setBackground(new java.awt.Color(255, 255, 255));
        LabelSuccess.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LabelSuccess.setForeground(new java.awt.Color(0, 0, 0));
        LabelSuccess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelSuccess.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 153, 255)));
        jPanel1.add(LabelSuccess, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 220, 20));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 220, 150));

        ButtonCreate.setText("Crear dataset");
        ButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCreateActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, 30));

        buttonDelete.setText("Eliminar");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(buttonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 223, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
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
        ArrayList<String> retorno= new ArrayList<>();
        int opcion = filetxt.showOpenDialog(this);
        valid = false;
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File file = filetxt.getSelectedFile();
            String FileName = file.getName();
            if (FileName.endsWith(".data")) {
                valid = true;
                String path = filetxt.getSelectedFile().getAbsolutePath();
                DefaultListModel<String> listModel;
                if (ListTrain.getModel() instanceof DefaultListModel) {
                    listModel = (DefaultListModel<String>) ListTrain.getModel();
                } else {
                    listModel = new DefaultListModel<>();
                    ListTrain.setModel(listModel);
                }
                if (FileName != null) {
                    listModel.addElement(FileName);
                    UIControllers.icon = true;
                    LabelSuccess.setVisible(true);
                    LabelSuccess.setText("Archivo cargado");
                    restartTimer();
                    UIControllers.path.add(FileName);
                    UIControllers.pathNumber++;
                }
                //aqui va la funcion q devuelve arrayString te mando la ruta del archivo path
                //retorno=readArchivodat(path);
            } else {
                JOptionPane.showMessageDialog(null, "El archivo no es un .data Selecciono un archivo invalido", "Error", JOptionPane.ERROR_MESSAGE,icon);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se selecciono ningun archivo", "Error", JOptionPane.ERROR_MESSAGE,icon);
        }
    }//GEN-LAST:event_ButtonLoadActionPerformed

    private void ButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditActionPerformed
        ArrayList<String> meta=new ArrayList<>();
        FlatSVGIcon icon2=new FlatSVGIcon("png/bluebell.svg");
        if (!Validator.checkNumber(UIControllers.pathNumber) == true) {
            if (Validator.checkList(ListTrain) == true) {
                String path2 = ListTrain.getSelectedValue().toString();
                UIControllers.Filename = path2;
                new ModifyDataset(datos).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar en la lista un dataset para modificar", "Informacion", JOptionPane.INFORMATION_MESSAGE, icon2);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No hay dataset para modificar", "Informacion", JOptionPane.INFORMATION_MESSAGE, icon2);
        }
        
    }//GEN-LAST:event_ButtonEditActionPerformed

    private void ButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCreateActionPerformed
        FlatSVGIcon icon=new FlatSVGIcon("png/bluebell.svg");
        String juego;
        JTextField field= new JTextField();
        JLabel label= new JLabel();
        label.setText("Debe ingresar el nombre del dataset");
        label.setForeground(new Color(102, 153, 255));
        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(Validator.containsNumber(field.getText()))
                {
                    field.putClientProperty("JComponent.outline","error");
                    label.setText("El texto no debe contener numeros");
                    label.setForeground(Color.red);
                }
                else
                {
                    field.putClientProperty("JComponent.outline",new Color(102, 153, 255));
                    label.setText("");
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                if(Validator.containsNumber(field.getText()))
                {
                    field.putClientProperty("JComponent.outline","error");
                    label.setText("El texto no debe contener numeros");
                    label.setForeground(Color.red);
                }
                else
                {
                    field.putClientProperty("JComponent.outline",new Color(102, 153, 255));
                    label.setText("");
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                if(Validator.containsNumber(field.getText()))
                {
                    field.putClientProperty("JComponent.outline","error");
                    label.setText("El texto no debe contener numeros");
                    label.setForeground(Color.red);
                }
                else
                {
                    field.putClientProperty("JComponent.outline",new Color(102, 153, 255));
                    label.setText("");
                }
            }
        });
        JPanel panel5= new JPanel(new BorderLayout());
        panel5.add(field,BorderLayout.CENTER);
        panel5.add(field,BorderLayout.SOUTH);
        panel5.add(label,BorderLayout.NORTH);
        int option=JOptionPane.showConfirmDialog(null, panel5, "Crear dataset", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
        if(option==JOptionPane.YES_OPTION)
        {
            LabelSuccess.setVisible(true);
            LabelSuccess.setText("Archivo cargado");
            restartTimer();
            UIControllers.path.add(field.getText() + ".data");
            addStringList(path, UIControllers.pathNumber);
            UIControllers.pathNumber++;
        }
    }//GEN-LAST:event_ButtonCreateActionPerformed

    private void ListTrainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListTrainMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ListTrainMouseClicked

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        FlatSVGIcon icon2=new FlatSVGIcon("png/bluebell.svg");
        if(Validator.checkNumber(UIControllers.pathNumber))
        {
            JOptionPane.showMessageDialog(null, "No hay dataset para eliminar", "Informacion", JOptionPane.INFORMATION_MESSAGE, icon2);
        }
        else
        {
            if(Validator.checkList(ListTrain)==true)
        {
            String[] botones = {"Si", "No"};
            int resultado = JOptionPane.showOptionDialog(null, "Seguro desea eliminar este dataset?", "Eliminar dataset", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon2, botones, botones[0]);
            if (resultado == JOptionPane.YES_OPTION) {
                int selectedindex = ListTrain.getSelectedIndex();
                if(selectedindex!=-1)
                {
                    listModel.remove(selectedindex);
                    UIControllers.path.removeLast();
                    UIControllers.pathNumber--;
                    addStringList(path,UIControllers.pathNumber);  
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar en la lista un dataset para eliminarlo", "Informacion", JOptionPane.INFORMATION_MESSAGE, icon2);
        
        }
        }
        
    }//GEN-LAST:event_buttonDeleteActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
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
    private javax.swing.JLabel LabelSuccess;
    private javax.swing.JList<String> ListTrain;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
