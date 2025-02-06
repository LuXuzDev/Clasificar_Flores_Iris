/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
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
    private JPanel fuegoPanel;
    private JPanel buttonPanel;

    public Trainer() {
        initComponents();
        Flatlaf();
        
        setTitle("Gráfico de Líneas con JFreeChart");
        setSize(610, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para el gráfico
        fuegoPanel = new JPanel(new BorderLayout());
        add(fuegoPanel, BorderLayout.CENTER);

        // Panel para los botones
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(800, 150));
        add(buttonPanel, BorderLayout.SOUTH);

        // Agregar botones al panel de botones
        JButton zoomButton = new JButton("Ampliar");
        buttonPanel.add(zoomButton);

        // Crear y agregar el gráfico al panel fuego
        createChart();

        // Acción para ampliar el gráfico
        zoomButton.addActionListener(e -> {
            JFrame zoomFrame = new JFrame("Gráfico Ampliado");
            zoomFrame.setSize(800, 600);
            zoomFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel zoomPanel = new JPanel(new BorderLayout());
            zoomFrame.add(zoomPanel);
            createChart(zoomPanel);
            zoomFrame.setVisible(true);
        });
    }

    private void createChart() {
        createChart(fuegoPanel);
    }

    private void createChart(JPanel panel) {
        // Crear el dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, "Series1", "1");
        dataset.addValue(4, "Series1", "2");
        dataset.addValue(3, "Series1", "3");
        dataset.addValue(5, "Series1", "4");
        dataset.addValue(2, "Series1", "5");

        // Crear el gráfico
        JFreeChart chart = ChartFactory.createLineChart(
                "Gráfico de Líneas", // Título
                "X", // Etiqueta del eje X
                "Y", // Etiqueta del eje Y
                dataset, // Dataset
                PlotOrientation.VERTICAL,
                true, // Incluir leyenda
                true,
                false
        );

        // Personalizar el gráfico
        chart.setBackgroundPaint(Color.WHITE);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.LIGHT_GRAY);
        plot.setDomainGridlinePaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.WHITE);

        // Crear el panel del gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight()));
        chartPanel.setMouseZoomable(true); // Permitir zoom con el ratón

        // Agregar el panel del gráfico al panel especificado
        panel.removeAll();
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Trainer frame = new Trainer();
            frame.setVisible(true);
        });
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
