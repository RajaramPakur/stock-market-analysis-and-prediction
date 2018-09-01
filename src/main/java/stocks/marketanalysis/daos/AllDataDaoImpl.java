/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.daos;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import stocks.marketanalysis.HibernateUtil;
import stocks.marketanalysis.models.AllData;

/**
 *
 * @author RajaramPakur
 */
public class AllDataDaoImpl implements AllDataDao{

    public List<AllData> getStockData() {
        
       Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crt = session.createCriteria(AllData.class);
        List<AllData> sList = crt.list();
        session.clear();

        return sList;
    }
    
}
