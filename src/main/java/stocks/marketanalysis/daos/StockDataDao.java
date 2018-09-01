package stocks.marketanalysis.daos;

import java.util.List;

import stocks.marketanalysis.models.StockData;

public interface StockDataDao {

	public void insertStockValues(StockData stockData);
	
	public List<StockData> getStockData();
}
