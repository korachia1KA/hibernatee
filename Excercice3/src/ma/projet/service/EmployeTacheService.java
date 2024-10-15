/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author kor
 */
public class EmployeTacheService implements IDao<EmployeTache> {

    @Override
    public boolean create(EmployeTache o) {
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
    public EmployeTache findById(int id) {
        Session session = null;
        EmployeTache p = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            p = (EmployeTache) session.get(EmployeTache.class, id);
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
    public List<EmployeTache> findAll() {
        Session session = null;
        List<EmployeTache> et = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            et = session.createQuery("from Produit").list();
            session.getTransaction().commit();;
            return et;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return et;
    }

    public List<Tache> getTachesBetweenDates(String startDate, String endDate) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("from Tache where dateDebut >= :startDate and dateFin <= :endDate")
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
