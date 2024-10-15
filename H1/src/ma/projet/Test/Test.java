/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Date;
import java.util.Scanner;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;

/**
 *
 * @author kor
 */
public class Test {

    public static void main(String[] args) {

        ProduitService ps = new ProduitService();

        ps.create(new Produit("stylo", "bique", new Date(), 1.5, "rouge"));
        ps.create(new Produit("blonco", "blanche", new Date(), 8.5, "blanche"));
        ps.create(new Produit("chaier", "tiger", new Date(), 4.5, "50page"));
        ps.create(new Produit("crayon", "rouge", new Date(), 3.5, "rouge"));
        ps.create(new Produit("dounleFeuille", "blace", new Date(), 15.5, "20page"));

        ps.findAll();

        ps.findById(2);

        ps.delete(ps.findById(3));

        Produit p = ps.findById(1);
        p.setDesignation("bleu");
        p.setMarque("ronault");
        ps.update(p);
        for (Produit pr : ps.findAll()) {
            if (pr.getPrix() > 100) {
                System.out.println(pr.toString());
            }
        }
        Scanner s = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Lire les dates
        System.out.print("Entrez la date de début (yyyy-MM-dd): ");
        String dateDString = s.next();
        System.out.print("Entrez la date de fin (yyyy-MM-dd): ");
        String dateFString = s.next();
        // Convertir en LocalDate
        LocalDate dateD = LocalDate.parse(dateDString, formatter);
        LocalDate dateF = LocalDate.parse(dateFString, formatter);
        // Récupérer les produits
        List<Produit> produits = ps.findAll();
        for (Produit pr : produits) {
            // Récupérer la date d'achat et la convertir
            Date dateAchatSql = (Date) pr.getDateAchat(); // Assurez-vous que cela retourne java.sql.Date
            LocalDate dateAchat = new java.sql.Date(dateAchatSql.getTime()).toLocalDate();

            // Vérifier si la date est dans la plage
            if ((dateAchat.isAfter(dateD) || dateAchat.isEqual(dateD))
                    && (dateAchat.isBefore(dateF) || dateAchat.isEqual(dateF))) {
                System.out.println(pr.toString());
            }
        }
    }
}
