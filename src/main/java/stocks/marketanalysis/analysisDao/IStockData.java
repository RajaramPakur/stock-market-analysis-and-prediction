/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.analysisDao;

import java.util.List;
import stocks.marketanalysis.models.StockData;


/**
 *
 * @author Prakash Tyata
 */
public interface IStockData {
    
    public List<StockData> getAll();
}
