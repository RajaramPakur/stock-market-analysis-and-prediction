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
import stocks.marketanalysis.models.NetworkConfiguration;

/**
 *
 * @author RajaramPakur
 */
public class NetworkConfigurationDaoImpl implements IGeneralizedDao<NetworkConfiguration> {

   

    public void insert(NetworkConfiguration objT) {
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

    public List<NetworkConfiguration> getAll() {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crt = session.createCriteria(NetworkConfiguration.class);
        List<NetworkConfiguration> sList = crt.list();
        session.clear();

        return sList;
    }

}
