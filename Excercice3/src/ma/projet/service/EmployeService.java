/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.Employe;
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
public class EmployeService implements IDao<Employe> {

    @Override
    public boolean create(Employe o) {
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
    public Employe findById(int id) {
        Session session = null;
        Employe p = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            p = (Employe) session.get(Employe.class, id);
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
    public List<Employe> findAll() {
        Session session = null;
        List<Employe> employes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            employes = session.createQuery("from Produit").list();
            session.getTransaction().commit();;
            return employes;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return employes;
    }

    public List<Tache> getTachesByEmploye(Employe employe) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("from EmployeTache where employe = :employe")
                    .setParameter("employe", employe.getId())
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Projet> getProjetsByEmploye(Employe employe) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("from Projet where chef_de_projet_id  = :employe")
                    .setParameter("employe", employe.getId())
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
