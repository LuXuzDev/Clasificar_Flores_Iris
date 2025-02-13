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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



public class DataBaseMenu extends javax.swing.JFrame {

    private static boolean check=false;
    private boolean valid=false;
    private static Timer timer;
    private DefaultListModel<String> listModel= new DefaultListModel<>();
    private static Object [][] datos = new Object[160][5];
    private static Object [][] datos1 = new Object[160][5];
    private static ArrayList<String> array=new ArrayList<>();
    private boolean trainCheck=false;
    
    public DataBaseMenu() {
        
        
        
        initComponents();
        Flatlaf();
        if(!UIControllers.path.isEmpty())
        {
            addStringList(UIControllers.path);
        }
        if(addMouse()==true)
        {
            this.dispose();
        }
       // setFontFamily("Arial");
        setIconImage(UIControllers.design().getImage());
        this.setLocationRelativeTo(null); 
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(102, 153, 255));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_MAXIMIZE,false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICON,true);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICONIFFY,true);
        timer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LabelSuccess.setText("");
                LabelSuccess.setVisible(false);
            }
        });
        timer.setRepeats(false);
        LabelSuccess.setVisible(false);
       
    }
    
  /* public void setFontFamily(String fontFamily)
    {
        java.awt.Font font = UIManager.getFont("defaultFont");
        System.out.println(font);
        java.awt.Font newFont=FontUtils.getCompositeFont(fontFamily, font.getStyle(),font.getSize());
        UIManager.put("defaultFont", newFont);
        FlatLaf.updateUI();
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
        
    }*/
    
    
    public Object[][] readArchivodat(String path)
    {
        Object[][] datos = new Object[160][5];
        int i=0;
        int j=0;
        
        float [] arreglo={0};
         try
         {
             Scanner scanner= new Scanner(new File(path));
             while(scanner.hasNextLine())
             {
                 String linea = scanner.nextLine();
                 String [] partes = linea.split(",");
                 if (partes.length == 5) 
                 {
                    j=0;
                    
                    float float1=Float.parseFloat(partes[0]);
                    float float2=Float.parseFloat(partes[1]);
                    float float3=Float.parseFloat(partes[2]);
                    float float4=Float.parseFloat(partes[3]);
                    datos[i][j++]=(float)float1;
                    datos[i][j++]=(float)float2;
                    datos[i][j++]=(float)float3;
                    datos[i][j++]=(float)float4;
                    
                   
                    String texto=partes[4];
                    datos[i][j++]=((String)texto);
                    System.out.println("Floats: "+datos[i][0]+", "+datos[i][1]+", "+datos[i][2]+", "+datos[i][3]);
                    System.out.println("String: "+texto);
                    i++;
                 }
                 else
                 {
                     System.out.println("Error");
                 }
             }
             scanner.close();
         }catch(FileNotFoundException e)
         {
             System.out.println("El archivo no fue encontrado"+e.getMessage());
         }catch(NumberFormatException e)
         {
             System.out.println("Error al convertir un valor a float"+e.getMessage());
         }
          
         return datos;
    }
    
    private boolean addMouse()
    {
        ListTrain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Verificar si fue un doble clic
                if (e.getClickCount() == 2) 
                {
                    ArrayList<String> meta = new ArrayList<>();
                    FlatSVGIcon icon2 = new FlatSVGIcon("png/bluebell.svg");
                    if (ListTrain.getSelectedValue() != null && ListTrain.getSelectedValue().endsWith(".data")) 
                    {
                        check=true;
                        String path2 = ListTrain.getSelectedValue().toString();
                        UIControllers.Filename = path2;
                        new ModifyDataset(datos).setVisible(true);
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar en la lista un dataset para modificar", "Informacion", JOptionPane.INFORMATION_MESSAGE, icon2);
                    }
                }}
        });
        return check;
    }
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
                /*placeHolder("     Ancho del petalo", FieldAnchoPetalo);
                placeHolder("   Longitud del sepalo", FieldLongitudSepalo);
                placeHolder("     Ancho del sepalo", FieldAnchoSepalo);
                placeHolder("   Longitud del petalo", FieldLongitudPetalo);
*/
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(DataBaseMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
     
     public void addStringList(ArrayList<String> path)
     {
         //DefaultListModel<String> model= new DefaultListModel<>();
         if (ListTrain.getModel() instanceof DefaultListModel) {
             listModel = (DefaultListModel<String>) ListTrain.getModel();
         } else {
             listModel = new DefaultListModel<>();
             ListTrain.setModel(listModel);
         }
         for(int i=0;i<path.size();i++)
         {
             listModel.add(i, path.get(i));
         }
     }
     
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ButtonBack = new javax.swing.JButton();
        ButtonEdit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ButtonCreate = new javax.swing.JButton();
        LabelSuccess = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListTrain = new javax.swing.JList<>();
        ButtonLoad2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iris");
        setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        setPreferredSize(new java.awt.Dimension(610, 340));
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
        jPanel1.add(ButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 130, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Entrenamientos Cargados");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 220, 30));

        ButtonCreate.setText("Cargar dataset");
        ButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCreateActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 130, 30));

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
        jScrollPane1.setViewportView(ListTrain);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 220, 150));

        ButtonLoad2.setText("Crear dataset");
        ButtonLoad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoad2ActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonLoad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 130, 30));

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

    private void ButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCreateActionPerformed
        JFileChooser filetxt=new JFileChooser();
        int opcion=filetxt.showOpenDialog(this);
        valid=false;
        if(opcion == JFileChooser.APPROVE_OPTION)
        {
            File file= filetxt.getSelectedFile();
            System.out.println(file.getName());
            String FileName=file.getName();
            if(FileName.endsWith(".data"))
            {
                valid=true;
                String path = filetxt.getSelectedFile().getAbsolutePath();
                
                DefaultListModel<String> listModel;
                if(ListTrain.getModel() instanceof DefaultListModel)
                {
                    listModel=(DefaultListModel<String>)ListTrain.getModel();
                }
                else
                {
                    listModel= new DefaultListModel<>();
                    ListTrain.setModel(listModel);
                }
                if(FileName!=null)
                {
                    listModel.addElement(FileName);
                    UIControllers.icon=true;
                    LabelSuccess.setVisible(true);
                    LabelSuccess.setText("Archivo cargado");
                    restartTimer();
                    UIControllers.path.add(FileName);
                }
               if(FileName.equals("iris.data"))
               {
                   datos=readArchivodat(path);
               }
               else
               {
                   datos1=readArchivodat(path);
               }
                
                
            }
            else
            {
                JOptionPane.showMessageDialog(null,"El archivo no es un .data Selecciono un archivo invalido","Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else
        {
            System.out.println("No se selecciono ningun archivo");
        }
        
        
    }//GEN-LAST:event_ButtonCreateActionPerformed

    private void ButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditActionPerformed
        
        ArrayList<String> meta=new ArrayList<>();
        FlatSVGIcon icon2=new FlatSVGIcon("png/bluebell.svg");
        if(ListTrain.getSelectedValue()!=null && ListTrain.getSelectedValue().endsWith(".data"))
        {
            String path2=ListTrain.getSelectedValue().toString();
            UIControllers.Filename=path2;
            new ModifyDataset(datos).setVisible(true);
            this.dispose();
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar en la lista un dataset para modificar", "Informacion", JOptionPane.INFORMATION_MESSAGE, icon2);
        }
        
    }//GEN-LAST:event_ButtonEditActionPerformed

    private void ButtonLoad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoad2ActionPerformed
         FlatSVGIcon icon=new FlatSVGIcon("png/bluebell.svg");
        JOptionPane.showInputDialog(null, "Escriba el nombre del dataset", "Crear Dataset", JOptionPane.QUESTION_MESSAGE, icon, null, "");
    }//GEN-LAST:event_ButtonLoad2ActionPerformed

   
    public void createTable(boolean add,String filename)
    {
        
        if(add==true)
        {
            listModel.addElement(filename);
        }
    }
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
    private javax.swing.JButton ButtonLoad2;
    private javax.swing.JLabel LabelSuccess;
    private javax.swing.JList<String> ListTrain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
