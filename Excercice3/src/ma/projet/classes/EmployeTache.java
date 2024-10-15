/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kor
 */
@Entity
public class EmployeTache {
    @EmbeddedId
    private EmployeTachePK pk;
    @ManyToOne
    @JoinColumn(name = "employe", insertable = false, updatable = false)
    private Employe employe;
    @ManyToOne
    @JoinColumn(name = "tache", insertable = false, updatable = false)
    private Tache tache;
    @Temporal(TemporalType.DATE)
    private Date dateFinReelle;

    public EmployeTache() {

    }

    public EmployeTache(EmployeTachePK pk, Employe employe, Tache tache, Date dateFinReelle) {
        this.pk = pk;
        this.employe = employe;
        this.tache = tache;
        this.dateFinReelle = dateFinReelle;
    }

    public EmployeTache(Employe employe, Tache tache, Date dateFinReelle) {
        this.employe = employe;
        this.tache = tache;
        this.dateFinReelle = dateFinReelle;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public EmployeTachePK getPk() {
        return pk;
    }

    public void setPk(EmployeTachePK pk) {
        this.pk = pk;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

    @Override
    public String toString() {
        return "EmployeTache{" + "pk=" + pk + ", employe=" + employe + ", tache=" + tache + ", dateFinReelle=" + dateFinReelle + '}';
    }
    

}
