/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import java.util.List;
import ma.projet.classes.Employe;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.service.EmployeService;
import ma.projet.service.ProjetService;

/**
 *
 * @author kor
 */
public class TestManyToOne2 {

    public static void main(String[] args) {
        
        ProjetService ProjetService = new ProjetService();
        EmployeService EmployeService = new EmployeService();
        EmployeService.create(new Employe("55", "ab", "0602598774"));
        EmployeService.create(new Employe("55", "ab", "068947474"));
        ProjetService.create(new Projet("Ali", new Date(2024,06,24),new Date(2024,9,24), EmployeService.findById(1)));
        ProjetService.create(new Projet("bob", new Date(2024,06,24),new Date(2024,9,24), EmployeService.findById(2)));
        
        List<Projet> ps=EmployeService.getProjetsByEmploye(EmployeService.findById(1));
         for(Projet p:ps){
            System.out.println(p.getNom());        
        }
    }
}
