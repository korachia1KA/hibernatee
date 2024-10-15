/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import ma.projet.classes.Commande;
import java.util.Date;
import ma.projet.service.CommandeService;

/**
 *
 * @author PC
 */
public class TestCommande {
    public static void main(String[] args) {
       CommandeService cs = new CommandeService();
       cs.create(new Commande(new Date()));
        cs.create(new Commande(new Date()));
         cs.create(new Commande(new Date("2024/07/01")));
          cs.create(new Commande(new Date("2024/08/08")));
    }
    
    
    
    
}
