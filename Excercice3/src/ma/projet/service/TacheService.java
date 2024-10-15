/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author kor
 */
public class TacheService implements IDao<Tache>{

    @Override
    public boolean create(Tache o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            // session.close();
        }
        return false;
    }

    @Override
    public Tache findById(int id) {
        Session session = null;
        Tache p = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            p = (Tache) session.get(Tache.class, id);
            session.getTransaction().commit();
            return p;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return p;
    }

    @Override
    public List<Tache> findAll() {
        Session session = null;
        List<Tache> taches = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            taches = session.createQuery("from Produit").list();
            session.getTransaction().commit();;
            return taches;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return taches;
    }
    
}

