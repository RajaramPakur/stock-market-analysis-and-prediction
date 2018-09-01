package stocks.marketanalysis.daos;

import stocks.marketanalysis.models.StockAnalysis;

public interface StockAnalysisDao {
	
	public void insertValues(StockAnalysis stockAnalysis);
	
	public StockAnalysis getAnalysisById(int id);

}
