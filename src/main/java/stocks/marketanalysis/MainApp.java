package stocks.marketanalysis;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.jfree.ui.RefineryUtilities;

import stocks.marketanalysis.charts.BollingerChart;
import stocks.marketanalysis.charts.CandlestickChart;
import stocks.marketanalysis.charts.RsiLineChart;
import stocks.marketanalysis.daos.AllDataDao;
import stocks.marketanalysis.daos.AllDataDaoImpl;
import stocks.marketanalysis.models.AllData;

public class MainApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable stockTable;
	private JButton btnCandlestick;
	private JButton btnRsi;
	private JButton btnBollingerBands;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SessionFactory sessionFactory = new Configuration()
							.configure().buildSessionFactory();
					MainApp frame = new MainApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainApp() {
              
		setTitle("Stock Market Analysis & Prediction");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getBtnCandlestick());
		contentPane.add(getBtnRsi());
		contentPane.add(getBtnBollingerBands());
		populateData();
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 153, 914, 297);
			scrollPane.setViewportView(getStockTable());
		}
		return scrollPane;
	}

	private JTable getStockTable() {
		if (stockTable == null) {
			stockTable = new JTable();
			stockTable.setModel(new DefaultTableModel(new Object[][] {},
					new String[] {"ID", "DATE", "OPEN", "CLOSE", "HIGH", "LOW", "VOLUMN"}));

		}
		return stockTable;
	}
	
	//populate data in a Jtable
	
		private void populateData()
		{
			AllDataDao sas = new AllDataDaoImpl();
			List<AllData> sList = sas.getStockData();
			DefaultTableModel model = (DefaultTableModel) stockTable.getModel();
			model.setRowCount(0);
			for(AllData s: sList)
			{
				model.addRow(new Object[]{s.getId(),s.getDate(),s.getOpen(),s.getClose(),s.getHighest(),s.getLowest(),s.getVolume()});
			}
			
			
		}
	private JButton getBtnCandlestick() {
		if (btnCandlestick == null) {
			btnCandlestick = new JButton("Candle Stick");
			btnCandlestick.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					final CandlestickChart demo = new CandlestickChart("GBIME Candlestick Chart");
					demo.pack();
					RefineryUtilities.centerFrameOnScreen(demo);
					demo.setVisible(true);
          		}
			});
			btnCandlestick.setToolTipText("Candlestick line Chart");
			btnCandlestick.setBounds(10, 11, 105, 46);
		}
		return btnCandlestick;
	}
	private JButton getBtnRsi() {
		if (btnRsi == null) {
			btnRsi = new JButton("RSI");
			btnRsi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					 final RsiLineChart lineChart = new RsiLineChart();
                     lineChart.pack();
                     RefineryUtilities.centerFrameOnScreen(lineChart);
                     lineChart.setVisible(true);
				}
			});
			btnRsi.setToolTipText("RSI line Chart");
			btnRsi.setBounds(129, 11, 77, 46);
		}
		return btnRsi;
	}
	private JButton getBtnBollingerBands() {
		if (btnBollingerBands == null) {
			btnBollingerBands = new JButton("BB");
			btnBollingerBands.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					final BollingerChart lineChart = new BollingerChart();
                    lineChart.pack();
                    RefineryUtilities.centerFrameOnScreen(lineChart);
                    lineChart.setVisible(true);
				}
			});
			btnBollingerBands.setToolTipText("Bollinger Bands line Chart");
			btnBollingerBands.setBounds(217, 11, 115, 46);
		}
		return btnBollingerBands;
	}
}
