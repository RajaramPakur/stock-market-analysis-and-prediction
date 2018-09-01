package stocks.marketanalysis.daos;

import java.util.List;
import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import stocks.marketanalysis.HibernateUtil;

import stocks.marketanalysis.models.StockData;

public class StockDataDaoImpl implements StockDataDao {

    /*
	Insert stock data
     */
    public void insertStockValues(StockData stockData) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(stockData);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            session.flush();
            session.close();
        }
        
    }

    /*
	 * return all stock data in list
     */
    public List<StockData> getStockData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crt = session.createCriteria(StockData.class);
        List<StockData> sList = crt.list();
        session.clear();

        return sList;
    }
}
