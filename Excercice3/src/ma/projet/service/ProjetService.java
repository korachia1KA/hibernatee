/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author kor
 */
public class ProjetService implements IDao<Projet> {

    @Override
    public boolean create(Projet o) {
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
    public Projet findById(int id) {
        Session session = null;
        Projet p = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            p = (Projet) session.get(Projet.class, id);
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
    public List<Projet> findAll() {
        Session session = null;
        List<Projet> projets = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            projets = session.createQuery("from Produit").list();
            session.getTransaction().commit();;
            return projets;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return projets;
    }

    public List<Tache> getTachesByProjet(Projet projet) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("from Tache where projet_id = :projet_id")
                    .setParameter("projet_id", projet.getId())
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
