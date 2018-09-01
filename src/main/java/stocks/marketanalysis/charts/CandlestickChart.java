package stocks.marketanalysis.charts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SegmentedTimeline;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import org.jfree.data.xy.DefaultHighLowDataset;
import org.jfree.date.DateUtilities;
import org.jfree.ui.RefineryUtilities;

import stocks.marketanalysis.datasets.DemoDatasetFactory;

public class CandlestickChart extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final DateFormat READABLE_TIME_FORMAT = new SimpleDateFormat(
			"yyyy/mm/dd");
	private OHLCSeries ohlcSeries;
	private TimeSeries volumeSeries;

	public static void main(String[] args) {
		final CandlestickChart demo = new CandlestickChart(
				"GBIME Candlestick Chart");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}

	public CandlestickChart(final String title) {

		super(title);
		final DefaultHighLowDataset dataset = DemoDatasetFactory
				.createHighLowDataset();
	
		final JFreeChart chart = createChart(dataset);
		chart.getXYPlot().setOrientation(PlotOrientation.VERTICAL);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(1000, 700));
		chartPanel.setMouseZoomable(true);
		chartPanel.setMouseWheelEnabled(true);
		setContentPane(chartPanel);
		/*
		 * // Create OHLC series for the chart OHLCSeriesCollection
		 * seriesCollection = createSeriesCollection(); // Store to variable for
		 * being accessible from other methods // in future ohlcSeries =
		 * seriesCollection.getSeries(0);
		 * 
		 * // Create new chart final JFreeChart candlestickChart =
		 * createChart(seriesCollection); // Create new chart panel final
		 * ChartPanel chartPanel = new ChartPanel(candlestickChart);
		 * chartPanel.setPreferredSize(new Dimension(900, 500)); // Enable
		 * zooming chartPanel.setMouseZoomable(true);
		 * chartPanel.setMouseWheelEnabled(true);
		 * this.add(chartPanel,BorderLayout.CENTER);
		 */
	}

	private JFreeChart createChart(final DefaultHighLowDataset dataset) {

		/*
		 * Creating candlestick subplot
		 */

		final JFreeChart chart = ChartFactory.createCandlestickChart(
				"GBIME Candlestick Chart", "Time", "Price", dataset, true);
		return chart;
		
/*
		// Create OHLCSeriesCollection as a price dataset for candlestick chart
		OHLCSeriesCollection candlestickDataset = new OHLCSeriesCollection();
		ohlcSeries = new OHLCSeries("Price");
		candlestickDataset.addSeries(ohlcSeries);
		// Create candlestick chart priceAxis
		NumberAxis priceAxis = new NumberAxis("Price");
		priceAxis.setAutoRangeIncludesZero(false);
		
		// create candlestick chart renderer
		CandlestickRenderer candlestickRenderer = new CandlestickRenderer(
				CandlestickRenderer.WIDTHMETHOD_AVERAGE, false,
				new CustomHighLowItemLabelGenerator(new SimpleDateFormat(
						"kk:mm"), new DecimalFormat("0.000")));

		// Create candlestick subplot
		XYPlot candlestickSubplot = new XYPlot(candlestickDataset, null,
				priceAxis, candlestickRenderer);
		candlestickSubplot.setBackgroundPaint(Color.WHITE);

		
		 * Creating volume subplot
		 
		// creates TimeSeriesCollection as a volume dataset for volume chart
		TimeSeriesCollection volumeDataset = new TimeSeriesCollection();
		volumeSeries = new TimeSeries("Volume");
		volumeDataset.addSeries(volumeSeries);
		// Create volume chart volumeAxis
		NumberAxis volumeAxis = new NumberAxis("Volume");
		volumeAxis.setAutoRangeIncludesZero(false);
		// set to no decimal
		volumeAxis.setNumberFormatOverride(new DecimalFormat("0"));
		// Create volume chart renderer
		XYBarRenderer timeRenderer = new XYBarRenderer();
		timeRenderer.setShadowVisible(false);
		timeRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator(
				"Volume --> Time={1} Size{2}", new SimpleDateFormat("kk:mm"),
				new DecimalFormat("0")));
		// Create volumesubplot
		XYPlot volumeSubplot = new XYPlot(volumeDataset, null, volumeAxis,
				timeRenderer);
		volumeSubplot.setBackgroundPaint(Color.white);
		
		
		 * Create chart main plot with two
		 * subplots(candlestickSubplot,volumeSubplot) and common dateAxis
		 
		// Creating charts common dateAxis
		DateAxis dateAxis = new DateAxis("Time");
		dateAxis.setDateFormatOverride(new SimpleDateFormat("kk:mm"));
		//reduce the default left/right margin from 0.05 to 0.02
		dateAxis.setLowerMargin(0.02);
		dateAxis.setUpperMargin(0.02);
		// Create mainPlot
		CombinedDomainXYPlot mainPlot = new CombinedDomainXYPlot(dateAxis);
		mainPlot.setGap(10.0);
		mainPlot.add(candlestickSubplot, 3);
		mainPlot.add(volumeSubplot, 1);
		mainPlot.setOrientation(PlotOrientation.VERTICAL);
		
		JFreeChart chart1 = new JFreeChart("Title", JFreeChart.DEFAULT_TITLE_FONT, mainPlot, true);
		chart.removeLegend();
		return chart1;
		*/
	}

}
