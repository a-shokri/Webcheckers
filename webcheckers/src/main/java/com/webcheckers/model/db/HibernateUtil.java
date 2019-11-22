/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webcheckers.model.db;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import java.io.File;
/**
 *
 * @author bm3302
 */
public class HibernateUtil {
    private SessionFactory sessionFactory;
    public HibernateUtil()
    {
        this.sessionFactory = buildSessionFactory();
    }
    
 
    private SessionFactory buildSessionFactory() 
    {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            //return new Configuration().configure(
             //       new File(System.getProperty("user.dir")+("/src/main/java/com/webcheckers/model/db/hibernate.cfg.xml")))
             //       .buildSessionFactory();
             
             return new AnnotationConfiguration().configure(
                    new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath().replaceAll("%20", " ") + "/com/webcheckers/model/db/hibernate.cfg.xml")).buildSessionFactory();
 
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
