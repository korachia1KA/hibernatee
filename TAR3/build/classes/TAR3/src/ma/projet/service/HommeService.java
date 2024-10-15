/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Date;
import java.util.List;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kor
 */
public class HommeService implements IDao <Homme>{

    @Override
    public boolean create(Homme o) {
         Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public Homme findById(int id) {
        Session session = null;
        Homme h  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            h = (Homme) session.get(Homme.class, id);
            session.getTransaction().commit();
            return h;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return h;
    }

    @Override
    public List<Homme> findAll() {
        Session session = null;
        List<Homme>  hommes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            hommes = session.createQuery("from Homme").list();
            session.getTransaction().commit();
            return hommes;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return hommes;
    }
    
  
}
