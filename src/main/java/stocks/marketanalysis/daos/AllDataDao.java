/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.daos;

import java.util.List;
import stocks.marketanalysis.models.AllData;

/**
 *
 * @author RajaramPakur
 */
public interface AllDataDao {
    
    public List<AllData> getStockData();
    
}
