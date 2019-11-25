package com.webcheckers.model.db;

import com.webcheckers.model.HumanPlayer;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class DBManager implements IDataManager{
    HibernateUtil hibutil;
    public DBManager()
    {
        hibutil = new HibernateUtil();
        
    }
    @Override
    public Integer save(Object obj) {
        Session session= hibutil.getSessionFactory().openSession();    
        session.beginTransaction();
        Integer id = (Integer)session.save(obj);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    @Override
    public void delete(Object obj) {
        Session session= hibutil.getSessionFactory().openSession();    
        session.beginTransaction();
        session.delete(obj);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Object obj) {
        Session session= hibutil.getSessionFactory().openSession();    
        session.beginTransaction();
        session.update(obj);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Object findById(Class classType, Serializable id){
        Session session= hibutil.getSessionFactory().openSession();    
        session.beginTransaction();
        Object temp = session.get(classType, id);
        session.getTransaction().commit();
        session.close();
        return temp;
    }

    @Override
    public List<Object> find(Class classType, Map<String, Object> fieldValueMap) {
        Session session= hibutil.getSessionFactory().openSession();    
        session.beginTransaction();
        Criteria cr = session.createCriteria(classType);
        for (Map.Entry<String, Object> entry : fieldValueMap.entrySet())
            cr.add(Restrictions.eq(entry.getKey(), entry.getValue()));
        List results = cr.list();
        session.getTransaction().commit();
        session.close();
        return results;
    }
    
}
