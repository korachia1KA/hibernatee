/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kor
 */
@Entity
@Table(name = "produits")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "marque")
    private String marque;
    
    @Column(name = "reference")
    private String reference;
    
    @Column(name = "dateAchat")
    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    
    @Column(name = "prix")
    private double prix;
    
    @Column(name = "designation")
    private String designation;

    public Produit() {

    }

    public Produit(String marque, String reference, Date dateAchat, double prix, String designation) {
        this.marque = marque;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.designation = designation;
    }

    public Produit(int id, String marque, String reference, Date dateAchat, double prix, String designation) {
        this.id = id;
        this.marque = marque;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "id=" + id + ", marque=" + marque + ", reference=" + reference + ", dateAchat=" + dateAchat + ", prix=" + prix + ", designation=" + designation;
    }

}
