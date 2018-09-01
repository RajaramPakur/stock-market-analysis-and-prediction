/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.analysisDaoImpl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import stocks.marketanalysis.analysisDao.IStockData;
import stocks.marketanalysis.models.StockData;

/**
 *
 * @author Prakash Tyata
 */
public class StockDataImpl implements IStockData{

    public List<StockData> getAll() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Criteria crt = session.createCriteria(StockData.class);
        List<StockData> sList = crt.list();
        session.clear();
        return sList;
    }
    
    
    
}
