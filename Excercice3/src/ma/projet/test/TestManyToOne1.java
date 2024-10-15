/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import java.util.List;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;

/**
 *
 * @author kor
 */
public class TestManyToOne1 {

    public static void main(String[] args) {

        ProjetService projetService = new ProjetService();
        TacheService tacheService = new TacheService();
        projetService.create(new Projet("789", new Date(2024,7,4),new Date(2024,12,2)));
        projetService.create(new Projet("958", new Date(2024,7,4),new Date(2024,12,2)));
        tacheService.create(new Tache(",aja", new Date(2024,7,4),new Date(2024,12,2),458, projetService.findById(1)));
        tacheService.create(new Tache("mona", new Date(2024,7,4),new Date(2024,12,2), 455,projetService.findById(2)));
     
        List<Tache> ts=projetService.getTachesByProjet(projetService.findById(2));
        for(Tache t:ts){
            System.out.println(t.getNom());
        }
       
       
    }

}
