/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import dao.IDao;
import java.util.ArrayList;
import java.util.List;
import ma.projet.entity.Produit;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author kor
 */
public class ProduitService implements IDao< Produit> {

    @Override
    public boolean create(Produit o) {
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
            session.close();
        }

        return false;
    }

    @Override
    public boolean delete(Produit o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction();
            session.delete(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(Produit o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public Produit findById(int id) {
        Produit produit = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction();
            produit = (Produit) session.get(Produit.class, id);
            session.getTransaction().commit();
            return produit;
        } catch (HibernateException e) {
        } finally {
            session.close();
        }
        return produit;
    }

    @Override
    public List<Produit> findAll() {
        List<Produit> produits = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction();
            produits = session.createQuery("from Produit").list();
            session.getTransaction().commit();
            return produits;
        } catch (HibernateException e) {
        } finally {
            session.close();
        }
        return produits;
    }

}
