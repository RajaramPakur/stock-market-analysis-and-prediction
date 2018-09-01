/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis;

import java.util.ArrayList;
import java.util.List;
import stocks.marketanalysis.daos.StockDataDao;
import stocks.marketanalysis.daos.StockDataDaoImpl;
import stocks.marketanalysis.models.StockData;

/**
 *
 * @author RajaramPakur
 */
public class TestClass {
    
    public static void main(String[] args) {
        StockData o = new StockData();
        o.setLtp(1.1);
        o.setClose(1.1);
        o.setDate("a");
        o.setHighest(5.2);
        o.setLowest(5.5);
        o.setOpen(5.5);
        o.setPercentchange(5);
        o.setTurnover(55);
        o.setVolume(500);
        StockDataDao obj = new StockDataDaoImpl();
        obj.insertStockValues(o);
        
        List<StockData> slist = new ArrayList<StockData>();
        slist = obj.getStockData();
        for(StockData l: slist){
            System.out.println(l.getDate());
        }
        
    }
    
}
