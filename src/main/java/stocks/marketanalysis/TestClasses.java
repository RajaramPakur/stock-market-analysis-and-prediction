/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis;

import stocks.marketanalysis.analysisDao.IBollingerBand;
import stocks.marketanalysis.analysisDaoImpl.BollingerBandImpl;

/**
 *
 * @author Prakash Tyata
 */
public class TestClasses {
    
    public static void main(String[] args) {
        
        IBollingerBand objBB = new BollingerBandImpl();
        objBB.initialCalculation();
        
        
        
    }
    
}
