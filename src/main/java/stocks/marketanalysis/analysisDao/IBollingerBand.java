/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.analysisDao;

import java.util.List;
import stocks.marketanalysis.models.BollingerBand;

/**
 *
 * @author Prakash Tyata
 */
public interface IBollingerBand {
    
    public void insert(BollingerBand objBB);
    
    public List<BollingerBand> getAll();
    
    public BollingerBand getById(long id);
    
    public void initialCalculation();
    
    public void instantCalculation(BollingerBand objBB);
    
    
}
