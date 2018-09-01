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
import stocks.marketanalysis.models.AccuracyTest;

/**
 *
 * @author RajaramPakur
 */
public class AccuracyTestDaoImpl implements IGeneralizedDao<AccuracyTest> {

    public void insert(AccuracyTest objT) {
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

    public List<AccuracyTest> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crt = session.createCriteria(AccuracyTest.class);
        List<AccuracyTest> sList = crt.list();
        session.clear();
        return sList;
    }

    public AccuracyTest getById(AccuracyTest obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        AccuracyTest objStock = (AccuracyTest) session.get(AccuracyTest.class, obj.getId());
        return objStock;
    }
    
}
