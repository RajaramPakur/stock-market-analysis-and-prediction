package stocks.marketanalysis.daos;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import stocks.marketanalysis.HibernateUtil;
import stocks.marketanalysis.models.NormalizedTrainData;

import stocks.marketanalysis.models.StockAnalysis;

public class StockAnalysisDaoImpl implements StockAnalysisDao {

    /*
	Insertion of stock analysis value
     */
    public void insertValues(StockAnalysis stockAnalysis) {

        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(stockAnalysis);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    /*
	get stock analysis value by id
     */
    public StockAnalysis getAnalysisById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        StockAnalysis objStock = (StockAnalysis) session.get(StockAnalysis.class, id);
        return objStock;
    }

}
