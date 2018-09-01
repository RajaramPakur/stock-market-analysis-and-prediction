package stocks.marketanalysis.charts;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;

import stocks.marketanalysis.datasets.DemoDatasetFactory;

public class BollingerChart extends JFrame {
	
	public BollingerChart(){
		 super("GBIME Bollinger Bands Chart");
	        final XYDataset dataSet = DemoDatasetFactory.createBollingerDataset();
	        
	        final JFreeChart chart = createChart(dataSet);
	        chart.getXYPlot().setOrientation(PlotOrientation.VERTICAL);
			final ChartPanel chartPanel = new ChartPanel(chart);
			chartPanel.setPreferredSize(new Dimension(1000, 700));
			chartPanel.setMouseZoomable(true);
			chartPanel.setMouseWheelEnabled(true);
			setContentPane(chartPanel);
	                
	        
	    }
	    
	    private JFreeChart createChart(final XYDataset dataset) {
	       
	        final JFreeChart chart = ChartFactory.createXYLineChart("GBIME Bollinger Bands Chart", "Time", "RSI", dataset);
		return chart;
	       
	    }

}
