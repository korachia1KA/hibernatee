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
public class Homme extends Personne{

    public Homme() {
    }

    public Homme(String nom, String prenom, String telephone, String adresse, Date datenes) {
        super(nom, prenom, telephone, adresse, datenes);
    }
    
    
}
