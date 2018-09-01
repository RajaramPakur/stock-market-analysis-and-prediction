/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.analysisDaoImpl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import stocks.marketanalysis.analysisDao.IBollingerBand;
import stocks.marketanalysis.analysisDao.IStockData;
import stocks.marketanalysis.models.BollingerBand;
import stocks.marketanalysis.models.StockData;

/**
 *
 * @author Prakash Tyata
 */
public class BollingerBandImpl implements IBollingerBand {

    
    private  SessionFactory objsession=new Configuration().buildSessionFactory();
    private Session session=objsession.openSession();
    
   
    public void insert(BollingerBand objBB) {
       
        this.session.save(objBB);
       
    }

    public List<BollingerBand> getAll() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Criteria crt = session.createCriteria(BollingerBand.class);
        List<BollingerBand> sList = crt.list();
        session.clear();
        return sList;
    }

    public BollingerBand getById(long id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        return (BollingerBand) session.get(BollingerBand.class, id);
    }

    public void initialCalculation() {

        double sma, cal, upper, middle, lower;
        int count1 = 0;
        List<Double> list = new ArrayList<Double>();
        List<StockData> stockList = new ArrayList<StockData>();

        IStockData objStockData = new StockDataImpl();
        stockList = objStockData.getAll();

//        Print stockList size here;
        double[] array = new double[stockList.size()];
        for (StockData l : stockList) {
            array[count1] = l.getLtp();
            count1++;
        }

        int count2 = 0, x = 0;
        for (int i = 0; i < array.length; i++) {
            sma = 0.0;
            if (count2 < 20) {
                sma = sma + array[i];
                count2++;
                for (int l = 0; l < 20; l++) {
                    list.add(array[l]);
                    break;
                }
            } else {
                for (int j = i - 20; j <= i; j++) {
                    sma = sma + array[j];
                    for (int l = 20; l < array.length; l++) {
                        list.add(array[l]);
                        break;
                    }
                }
            }
            cal = sma / 20;
            double std = stDev(list);
//                 Middle Band = 20-day simple moving average (SMA)
//                * Upper Band = 20-day SMA + (20-day standard deviation of price x 2) 
//                * Lower Band = 20-day SMA - (20-day standard deviation of price x 2)

            middle = cal;
            upper = cal + (std * 2);
            lower = cal - (std * 2);

            for (StockData l : stockList) {
                BollingerBand objBB = new BollingerBand();
                objBB.setId(l.getId());
                objBB.setDate(l.getDate());
                if (x < 21) {
                    middle = 0;
                    std = 0;
                    upper = 0;
                    lower = 0;
                    objBB.setMiddlebandValue(middle);
                    objBB.setStandardDeviation(std);
                    objBB.setUpperbandValue(upper);
                    objBB.setLowerbandValue(lower);
                    x++;
                } else {
                    objBB.setMiddlebandValue(middle);
                    objBB.setStandardDeviation(std);
                    objBB.setUpperbandValue(upper);
                    objBB.setLowerbandValue(lower);
                }
                insert(objBB);
                break;

            }
        }
    }

    private static double stDev(List<Double> list) {
        double sum = 0.0;
        double mean = 0.0;
        double num = 0.0;
        double numi = 0.0;

        for (double i : list) {
            sum += i;
            //System.out.println("hello"+i);
        }
        mean = sum / list.size();

        for (double i : list) {
            numi = Math.pow((i - mean), 2);
            num += numi;
        }
        return Math.sqrt(num / list.size());
    }

    public void instantCalculation(BollingerBand objBB) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
