/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;
import java.awt.*;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jfree.chart.ChartPanel;




public class Trainer extends javax.swing.JFrame {
    
    
    //Atributos
    private DefaultListModel<String> listModel= new DefaultListModel<>();
    
    
    //Constructor
    public Trainer() {
        initComponents();
        design();
        paneMetricas.setVisible(false);
        paneLabels.setVisible(false);
    }
    
    //metodo para el diseño del jrame
    private void design ()
    {
        Flatlaf();
        UIManager.put("TextComponent.arc",99);
        UIManager.put("Button.arc", 25);
        setTitle("Gráficos Iris");
        setSize(610, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(102, 153, 255));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_MAXIMIZE,false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICON,true);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICONIFFY,true);
        UIControllers.design();
        UIControllers.setFontFamily("Arial");
        setIconImage(UIControllers.design().getImage());
        JPanel panelGrafico = crearPanelGrafico();
        cardPanel.add(panelGrafico, "Grafico 1");
        UIControllers.AddJlist(ListData, listModel);
    }
    
    
    //metodo de disenno general
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
     
     
     //crear los graficos de prueba
     private JPanel crearPanelGrafico() {
        // Crear la serie de datos
        XYSeries series = new XYSeries("Error de Entrenamiento");

        // Agregar datos a la serie
        for (int i = 0; i < UIControllers.trainer.getErrorEntrenamiento().size(); i++) {
            series.add(i + 1,UIControllers.trainer.getErrorEntrenamiento().get(i)); // i + 1 para que las épocas empiecen desde 1
        }
        // Crear el conjunto de datos
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE); // Línea azul
        
        // Crear el gráfico
       JFreeChart chart = ChartFactory.createXYLineChart(
               "Error de Entrenamiento por Época"
               ,"Épocas"
               ,"Error"
               , dataset
               , PlotOrientation.VERTICAL
               , true, true, false);
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE); // Fondo blanco
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY); // Líneas de la cuadrícula
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
        plot.setRenderer(renderer);
        // Crear un panel para el gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(540, 280));
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(chartPanel, BorderLayout.CENTER);
        return panel;
    }
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panePrinc = new javax.swing.JPanel();
        paneMetricas = new javax.swing.JPanel();
        labelIndicationMetricas = new javax.swing.JLabel();
        ScrollList = new javax.swing.JScrollPane();
        ListData = new javax.swing.JList<>();
        paneLabels = new javax.swing.JPanel();
        LabelAccuracy = new javax.swing.JLabel();
        LabelSetosa = new javax.swing.JLabel();
        LabelError = new javax.swing.JLabel();
        Labelepoch = new javax.swing.JLabel();
        Labelversi = new javax.swing.JLabel();
        LabelVirgi = new javax.swing.JLabel();
        LabelacurracyTotal = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        buttonGraph = new javax.swing.JButton();
        buttonMetrics = new javax.swing.JButton();
        buttonInfo = new javax.swing.JButton();
        buttonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 610, 340));
        setMinimumSize(new java.awt.Dimension(610, 340));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panePrinc.setBackground(new java.awt.Color(255, 255, 255));
        panePrinc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneMetricas.setBackground(new java.awt.Color(255, 255, 255));
        paneMetricas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIndicationMetricas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelIndicationMetricas.setForeground(new java.awt.Color(102, 153, 255));
        labelIndicationMetricas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIndicationMetricas.setText("Datos Métricas");
        paneMetricas.add(labelIndicationMetricas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 300, 30));

        ScrollList.setViewportView(ListData);

        paneMetricas.add(ScrollList, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 450, 210));

        panePrinc.add(paneMetricas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, -1));

        paneLabels.setBackground(new java.awt.Color(255, 255, 255));
        paneLabels.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelAccuracy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelAccuracy.setForeground(new java.awt.Color(102, 153, 255));
        LabelAccuracy.setText("Precision Total: ");
        paneLabels.add(LabelAccuracy, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, 20));

        LabelSetosa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelSetosa.setForeground(new java.awt.Color(102, 153, 255));
        LabelSetosa.setText("Setosa: ");
        paneLabels.add(LabelSetosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 130, 20));

        LabelError.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelError.setForeground(new java.awt.Color(102, 153, 255));
        LabelError.setText("Error:");
        paneLabels.add(LabelError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 130, 20));

        Labelepoch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Labelepoch.setForeground(new java.awt.Color(102, 153, 255));
        Labelepoch.setText("Epocas:");
        paneLabels.add(Labelepoch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 130, 20));

        Labelversi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Labelversi.setForeground(new java.awt.Color(102, 153, 255));
        Labelversi.setText("Versicolor:");
        paneLabels.add(Labelversi, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 130, 20));

        LabelVirgi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelVirgi.setForeground(new java.awt.Color(102, 153, 255));
        LabelVirgi.setText("Virginica:");
        paneLabels.add(LabelVirgi, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 130, 20));

        LabelacurracyTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelacurracyTotal.setForeground(new java.awt.Color(102, 153, 255));
        LabelacurracyTotal.setText("Precision por clase :");
        paneLabels.add(LabelacurracyTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 180, 20));

        panePrinc.add(paneLabels, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 250));

        cardPanel.setBackground(new java.awt.Color(255, 255, 255));
        cardPanel.setLayout(new java.awt.CardLayout());
        panePrinc.add(cardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 250));

        buttonPanel.setBackground(new java.awt.Color(255, 255, 255));
        buttonPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGraph.setBackground(new java.awt.Color(255, 255, 255));
        buttonGraph.setForeground(new java.awt.Color(0, 0, 0));
        buttonGraph.setText("Gráfico");
        buttonGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGraphActionPerformed(evt);
            }
        });
        buttonPanel.add(buttonGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        buttonMetrics.setBackground(new java.awt.Color(255, 255, 255));
        buttonMetrics.setForeground(new java.awt.Color(0, 0, 0));
        buttonMetrics.setText("Métricas");
        buttonMetrics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMetricsActionPerformed(evt);
            }
        });
        buttonPanel.add(buttonMetrics, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        buttonInfo.setBackground(new java.awt.Color(255, 255, 255));
        buttonInfo.setForeground(new java.awt.Color(0, 0, 0));
        buttonInfo.setText("Información");
        buttonInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInfoActionPerformed(evt);
            }
        });
        buttonPanel.add(buttonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        panePrinc.add(buttonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 600, 70));

        buttonBack.setIcon(new FlatSVGIcon("png/arrow.svg"));
        buttonBack.setBackground(new java.awt.Color(255, 255, 255));
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });
        panePrinc.add(buttonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 40, 30));

        getContentPane().add(panePrinc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void buttonGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGraphActionPerformed
        cardPanel.setVisible(true);
        paneMetricas.setVisible(false);
        paneLabels.setVisible(false);
        CardLayout c1= (CardLayout)(cardPanel.getLayout());
        c1.show(cardPanel, "Grafico 1");
    }//GEN-LAST:event_buttonGraphActionPerformed

    private void buttonMetricsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMetricsActionPerformed
        cardPanel.setVisible(false);
        paneMetricas.setVisible(true);
        paneLabels.setVisible(false);
    }//GEN-LAST:event_buttonMetricsActionPerformed

    private void buttonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInfoActionPerformed
        UIControllers.NamesLabelsTrainer(Labelepoch, LabelAccuracy, LabelError, LabelSetosa, LabelVirgi, Labelversi);
        cardPanel.setVisible(false);
        paneMetricas.setVisible(false);
        paneLabels.setVisible(true);
    }//GEN-LAST:event_buttonInfoActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        new TrainMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonBackActionPerformed
public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Trainer().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelAccuracy;
    private javax.swing.JLabel LabelError;
    private javax.swing.JLabel LabelSetosa;
    private javax.swing.JLabel LabelVirgi;
    private javax.swing.JLabel LabelacurracyTotal;
    private javax.swing.JLabel Labelepoch;
    private javax.swing.JLabel Labelversi;
    private javax.swing.JList<String> ListData;
    private javax.swing.JScrollPane ScrollList;
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonGraph;
    private javax.swing.JButton buttonInfo;
    private javax.swing.JButton buttonMetrics;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JLabel labelIndicationMetricas;
    private javax.swing.JPanel paneLabels;
    private javax.swing.JPanel paneMetricas;
    private javax.swing.JPanel panePrinc;
    // End of variables declaration//GEN-END:variables
}
