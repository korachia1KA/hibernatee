/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kor
 */
@Embeddable
public class EmployeTachePK implements Serializable{

    private int employe;
    private int tache;
       @Temporal(TemporalType.DATE)

    private Date dateDebutReelle;

    public EmployeTachePK() {

    }

    public EmployeTachePK(int employe, int tache) {
        this.employe = employe;
        this.tache = tache;
    }

    public EmployeTachePK(int employe, int tache, Date dateDebutReelle) {
        this.employe = employe;
        this.tache = tache;
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public int getEmploye() {
        return employe;
    }

    public void setEmploye(int employe) {
        this.employe = employe;
    }

    public int getTache() {
        return tache;
    }

    public void setTache(int tache) {
        this.tache = tache;
    }

    @Override
    public String toString() {
        return "EmployeTachePK{" + "employe=" + employe + ", tache=" + tache + ", dateDebutReelle=" + dateDebutReelle + '}';
    }
    

}
