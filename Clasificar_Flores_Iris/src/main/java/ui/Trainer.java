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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jfree.chart.ChartPanel;
import static ui.UIControllers.trainer;



public class Trainer extends javax.swing.JFrame {
    
    
    public Trainer() {
        initComponents();
        design();
    }
    
    //funcion para el diseño del jrame
    private void design ()
    {
        //UIControllers.setFontFamily("Arial");
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
        JPanel blankPanel1 = new JPanel();
        JPanel blankPanel2 = new JPanel(new BorderLayout());
        JTable table=new JTable();
        table.setVisible(true);
        blankPanel1.setBackground(Color.white);
        blankPanel2.setBackground(Color.white);
        JPanel panelGrafico = crearPanelGrafico();
        cardPanel.add(panelGrafico, "Grafico 1");
        cardPanel.add(blankPanel1);
        cardPanel.add(blankPanel2);
        
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
        // Método para añadir anotaciones (etiquetas) al gráfico
        // Personalizar el gráfico
        
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

        jPanel1 = new javax.swing.JPanel();
        cardPanel = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        buttonGraph2 = new javax.swing.JButton();
        buttonGraph3 = new javax.swing.JButton();
        buttonGraph4 = new javax.swing.JButton();
        buttonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 610, 340));
        setMinimumSize(new java.awt.Dimension(610, 340));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cardPanel.setBackground(new java.awt.Color(255, 255, 255));
        cardPanel.setLayout(new java.awt.CardLayout());
        jPanel1.add(cardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 250));

        buttonPanel.setBackground(new java.awt.Color(255, 255, 255));
        buttonPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGraph2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGraph2.setForeground(new java.awt.Color(0, 0, 0));
        buttonGraph2.setText("Grafico");
        buttonGraph2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGraph2ActionPerformed(evt);
            }
        });
        buttonPanel.add(buttonGraph2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        buttonGraph3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGraph3.setForeground(new java.awt.Color(0, 0, 0));
        buttonGraph3.setText("Metricas");
        buttonGraph3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGraph3ActionPerformed(evt);
            }
        });
        buttonPanel.add(buttonGraph3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        buttonGraph4.setBackground(new java.awt.Color(255, 255, 255));
        buttonGraph4.setForeground(new java.awt.Color(0, 0, 0));
        buttonGraph4.setText("Ver mas");
        buttonGraph4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGraph4ActionPerformed(evt);
            }
        });
        buttonPanel.add(buttonGraph4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        jPanel1.add(buttonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 600, 70));

        buttonBack.setIcon(new FlatSVGIcon("png/arrow.svg"));
        buttonBack.setBackground(new java.awt.Color(255, 255, 255));
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });
        jPanel1.add(buttonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGraph2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGraph2ActionPerformed
       CardLayout c1= (CardLayout)(cardPanel.getLayout());
        c1.show(cardPanel, "Grafico 1");
    }//GEN-LAST:event_buttonGraph2ActionPerformed

    private void buttonGraph3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGraph3ActionPerformed
        CardLayout c2= (CardLayout)(cardPanel.getLayout());
        c2.show(cardPanel, "");
    }//GEN-LAST:event_buttonGraph3ActionPerformed

    private void buttonGraph4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGraph4ActionPerformed
        CardLayout c3= (CardLayout)(cardPanel.getLayout());
        c3.show(cardPanel,"");
    }//GEN-LAST:event_buttonGraph4ActionPerformed

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
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonGraph2;
    private javax.swing.JButton buttonGraph3;
    private javax.swing.JButton buttonGraph4;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
