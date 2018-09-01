package stocks.marketanalysis.RsiAnalysis;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import stocks.marketanalysis.daos.StockDataDao;
import stocks.marketanalysis.daos.StockDataDaoImpl;
import stocks.marketanalysis.models.StockData;

public class RsiIndicator {
	
	private double averageGainIndicator;
    private double averageLossIndicator;
    List<Double> avgGain = new ArrayList<Double>();
    ArrayList<Double> avgLoss = new ArrayList<Double>();
    
    public RsiIndicator(int timeFrame) {
        
    }

    public RsiIndicator(double avgGainIndicator, double avgLossIndicator) {
        averageGainIndicator = avgGainIndicator;
        averageLossIndicator = avgLossIndicator;
    }
    
    public void avgGainLossCalculate(){
    	
    	StockDataDao stockData = new StockDataDaoImpl();
    	List<StockData> sList = stockData.getStockData();
    	for (StockData sd : sList) {
			if(sd.getPercentchange()<=0){
				avgLoss.add(sd.getPercentchange() * (-1));
			}else{
				avgGain.add(sd.getPercentchange());
			}
		}
    }
    


}
