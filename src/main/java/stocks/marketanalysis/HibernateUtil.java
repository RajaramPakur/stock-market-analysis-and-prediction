/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author RajaramPakur
 */
public class HibernateUtil {
    
    private static SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory(){
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.err.println("session creation error");
            e.printStackTrace();
        }
        return new Configuration().configure().buildSessionFactory();
    }
    
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
