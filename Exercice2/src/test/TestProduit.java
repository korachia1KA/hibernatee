/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import ma.projet.service.ProduitService;
import ma.projet.classes.Produit;
import java.util.Date;
import ma.projet.service.CategorieService;
//import sun.security.krb5.internal.APReq;

/**
 *
 * @author PC
 */
public class TestProduit {

    public static void main(String[] args) {
        ProduitService ps = new ProduitService();
        CategorieService cs = new CategorieService();
        ps.create(new Produit("A", "r", new Date(), 100, "d1", cs.findById(1)));
        ps.create(new Produit("A", "r", new Date(), 100, "d2", cs.findById(1)));
        ps.create(new Produit("A", "r", new Date(), 100, "d3", cs.findById(1)));
        ps.create(new Produit("B", "r", new Date(), 200, "d4", cs.findById(2)));
        ps.create(new Produit("B", "r", new Date(), 200, "d5", cs.findById(2)));
        ps.create(new Produit("B", "r", new Date(), 200, "d6", cs.findById(3)));
     
        ps.create(new Produit("A", "r", new Date("2024/10/12"), 100, "d7", cs.findById(1)));

    }
}
