/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.util.FontUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
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
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;


public class Trainer extends javax.swing.JFrame {
    /**
     * Creates new form Trainer
     */
    
    //private CardLayout cardLayout;
    //JPanel cardPanel;
    
    public Trainer() {
        initComponents();
        Flatlaf();
        //setFontFamily("Arial");
        UIManager.put("TextComponent.arc",99);
        UIManager.put("Button.arc", 25);
        
        this.setLocationRelativeTo(null);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(102, 153, 255));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_MAXIMIZE,false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICON,true);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICONIFFY,true);
        FlatSVGIcon icon=new FlatSVGIcon("png/bluebell.svg");
        setIconImage(icon.getImage());
        setTitle("Gráficos Iris");
        setSize(610, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
            JPanel panelGrafico = crearPanelGrafico(1);
            cardPanel.add(panelGrafico, "Grafico 1");
            JPanel panelGrafico2 = crearPanelGrafico(2);
            cardPanel.add(panelGrafico2, "Grafico 2");
            JPanel panelGrafico3 = crearPanelGrafico(3);
            cardPanel.add(panelGrafico3, "Grafico 3");
            JPanel panelGrafico4 = crearPanelGrafico(4);
            cardPanel.add(panelGrafico4, "Grafico 4");
            JPanel panelGrafico5 = crearPanelGrafico(5);
            cardPanel.add(panelGrafico5, "Grafico 5");
        
        

        // Panel para el gráfico
       

        // Agregar botones al panel de botones
        

        // Crear y agregar el gráfico al panel fuego
        

        // Acción para ampliar el gráfico
        /*zoomButton.addActionListener(e -> {
            JFrame zoomFrame = new JFrame("Gráfico Ampliado");
            zoomFrame.setSize(800, 600);
            zoomFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel zoomPanel = new JPanel(new BorderLayout());
            zoomFrame.add(zoomPanel);
            createChart(zoomPanel);
            zoomFrame.setVisible(true);
        });*/
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
                Logger.getLogger(Trainer.class.getName()).log(Level.SEVERE, null, ex);
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
     
     private JPanel crearPanelGrafico(int numeroGrafico) {
        // Crear una serie de datos
        XYSeries series = new XYSeries("Datos");

        // Generar datos aleatorios para el gráfico
        Random rand = new Random(numeroGrafico); // Semilla para gráficos diferentes
        for (int i = 0; i < 10; i++) {
            series.add(i, rand.nextDouble() * 100);
        }

        // Crear un conjunto de datos
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        // Crear el gráfico de líneas
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Gráfico " + numeroGrafico, // Título
                "X", // Etiqueta del eje X
                "Y", // Etiqueta del eje Y
                dataset, // Datos
                PlotOrientation.VERTICAL,
                true, // Incluir leyenda
                true,
                false
        );

        // Personalizar el gráfico
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE); // Fondo blanco
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY); // Líneas de la cuadrícula
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE); // Línea azul
        plot.setRenderer(renderer);

        // Crear un panel para el gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(540, 280));
        
        JPanel panel= new JPanel(new BorderLayout());
        panel.add(chartPanel, BorderLayout.CENTER);
        return panel;
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cardPanel = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        buttonGraph1 = new javax.swing.JButton();
        buttonGraph2 = new javax.swing.JButton();
        buttonGraph3 = new javax.swing.JButton();
        buttonGraph4 = new javax.swing.JButton();
        buttonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 610, 340));
        setMinimumSize(new java.awt.Dimension(610, 340));
        setPreferredSize(new java.awt.Dimension(630, 370));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cardPanel.setBackground(new java.awt.Color(255, 255, 255));
        cardPanel.setLayout(new java.awt.CardLayout());
        jPanel1.add(cardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 250));

        buttonPanel.setBackground(new java.awt.Color(255, 255, 255));
        buttonPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGraph1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGraph1.setForeground(new java.awt.Color(0, 0, 0));
        buttonGraph1.setText("Grafico4");
        buttonGraph1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGraph1ActionPerformed(evt);
            }
        });
        buttonPanel.add(buttonGraph1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        buttonGraph2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGraph2.setForeground(new java.awt.Color(0, 0, 0));
        buttonGraph2.setText("Grafico1");
        buttonGraph2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGraph2ActionPerformed(evt);
            }
        });
        buttonPanel.add(buttonGraph2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        buttonGraph3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGraph3.setForeground(new java.awt.Color(0, 0, 0));
        buttonGraph3.setText("Grafico2");
        buttonGraph3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGraph3ActionPerformed(evt);
            }
        });
        buttonPanel.add(buttonGraph3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        buttonGraph4.setBackground(new java.awt.Color(255, 255, 255));
        buttonGraph4.setForeground(new java.awt.Color(0, 0, 0));
        buttonGraph4.setText("Grafico3");
        buttonGraph4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGraph4ActionPerformed(evt);
            }
        });
        buttonPanel.add(buttonGraph4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jPanel1.add(buttonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 610, 60));

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
        System.out.println("annadiendo grafico 1");
    }//GEN-LAST:event_buttonGraph2ActionPerformed

    private void buttonGraph3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGraph3ActionPerformed
        CardLayout c2= (CardLayout)(cardPanel.getLayout());
        c2.show(cardPanel, "Grafico 2");
        System.out.println("annadiendo grafico 2");
        
    }//GEN-LAST:event_buttonGraph3ActionPerformed

    private void buttonGraph4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGraph4ActionPerformed
        CardLayout c3= (CardLayout)(cardPanel.getLayout());
        c3.show(cardPanel, "Grafico 3");
        System.out.println("annadiendo grafico 3");
    }//GEN-LAST:event_buttonGraph4ActionPerformed

    private void buttonGraph1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGraph1ActionPerformed
        CardLayout c4= (CardLayout)(cardPanel.getLayout());
        c4.show(cardPanel, "Grafico 4");
        System.out.println("annadiendo grafico 4");
    }//GEN-LAST:event_buttonGraph1ActionPerformed

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
    private javax.swing.JButton buttonGraph1;
    private javax.swing.JButton buttonGraph2;
    private javax.swing.JButton buttonGraph3;
    private javax.swing.JButton buttonGraph4;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
