/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.daos;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import stocks.marketanalysis.HibernateUtil;
import stocks.marketanalysis.models.NormalizedTestData;

/**
 *
 * @author RajaramPakur
 */
public class NormalizedTestDataDaoImpl implements IGeneralizedDao<NormalizedTestData> {

        
    public void insert(NormalizedTestData objT) {
       Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(objT);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            session.flush();
            session.close();
        }
    }

    public List<NormalizedTestData> getAll() {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crt = session.createCriteria(NormalizedTestData.class);
        List<NormalizedTestData> sList = crt.list();
        session.clear();

        return sList;
    }
    
}
