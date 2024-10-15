/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import ma.projet.classes.Categorie;
import ma.projet.service.CategorieService;

/**
 *
 * @author PC
 */
public class TestCategorie {
    public static void main(String[] args) {
        CategorieService cs = new CategorieService();
        cs.create(new Categorie("A1", "Lacoste"));
         cs.create(new Categorie("B1", "Jordan"));
          cs.create(new Categorie("C1", "Nike"));
    }
    
}
