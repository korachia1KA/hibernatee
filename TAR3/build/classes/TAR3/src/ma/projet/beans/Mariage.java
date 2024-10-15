/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author kor
 */
@Entity
@Table (name = "Mariage")
public class Mariage {
    @EmbeddedId
    private HommeFemmePK pk;
    @ManyToOne
    @JoinColumn(name = "homme", insertable = false, updatable = false)
    private Homme homme;
    @ManyToOne
    @JoinColumn(name = "femme", insertable = false, updatable = false)
    private Femme femme;
    
    private Date dateFin;
    private int nbrenfant;

    public Mariage() {
    }

    public Mariage(Homme homme, Femme femme, Date dateFin, int nbrenfant) {
        this.homme = homme;
        this.femme = femme;
        this.dateFin = dateFin;
        this.nbrenfant = nbrenfant;
    }
    
    

    public Homme getHomme() {
        return homme;
    }

    public void setHomme(Homme homme) {
        this.homme = homme;
    }

    public Femme getFemme() {
        return femme;
    }

    public void setFemme(Femme femme) {
        this.femme = femme;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbrenfant() {
        return nbrenfant;
    }

    public void setNbrenfant(int nbrenfant) {
        this.nbrenfant = nbrenfant;
    }

    public HommeFemmePK getPk() {
        return pk;
    }

    public void setPk(HommeFemmePK pk) {
        this.pk = pk;
    }
    
    
    
    
}
