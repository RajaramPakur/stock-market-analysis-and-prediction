/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.charts;

import java.awt.Dimension;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xy.XYDataset;
import stocks.marketanalysis.datasets.DemoDatasetFactory;

/**
 *
 * @author RajaramPakur
 */
public class RsiLineChart extends JFrame{
    
    public RsiLineChart(){
        
        super("GBIME RSI Chart");
        final XYDataset dataSet = DemoDatasetFactory.createRsiDataset();
        
        final JFreeChart chart = createChart(dataSet);
        chart.getXYPlot().setOrientation(PlotOrientation.VERTICAL);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(1000, 700));
		chartPanel.setMouseZoomable(true);
		chartPanel.setMouseWheelEnabled(true);
		setContentPane(chartPanel);
                
        
    }
    
    private JFreeChart createChart(final XYDataset dataset) {
       
        final JFreeChart chart = ChartFactory.createXYLineChart("GBIME RSI Chart", "Time", "RSI", dataset);
	return chart;
       
    }
    
    private JFreeChart createLineChart(final CategoryDataset dataset){
        final JFreeChart chart = ChartFactory.createLineChart("GBIME RSI Chart", "Time", "RSI", dataset, PlotOrientation.VERTICAL, false, true, true);
        return chart;
    }
}
