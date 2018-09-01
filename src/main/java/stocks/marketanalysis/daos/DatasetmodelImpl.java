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
import stocks.marketanalysis.models.Datasetmodel;

/**
 *
 * @author Prakash Tyata
 */
public class DatasetmodelImpl implements IDatasetModel{
   
   
    public List<Datasetmodel> getDatasetmodel() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crt = session.createCriteria(Datasetmodel.class);
        List<Datasetmodel> sList = crt.list();
        session.clear();

        return sList;
       
    }
    
}
