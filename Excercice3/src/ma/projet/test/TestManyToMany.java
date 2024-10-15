/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import java.util.List;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.EmployeTachePK;
import ma.projet.classes.Tache;
import ma.projet.service.EmployeService;
import ma.projet.service.EmployeTacheService;
import ma.projet.service.TacheService;

/**
 *
 * @author kor
 */
public class TestManyToMany {

    public static void main(String[] args) {
        EmployeService ss = new EmployeService();
        TacheService es = new TacheService();
        EmployeTacheService cs = new EmployeTacheService();
        ss.create(new Employe("bobo","iunram","0785941263"));
        ss.create(new Employe("amal","mone","0658948493"));

        es.create(new Tache("morad", new Date(2024,06,24),new Date(2024,9,24),789));
        es.create(new Tache("anwar", new Date(2024,06,24),new Date(2024,07,4),9512));

        EmployeTache et = new EmployeTache(ss.findById(1), es.findById(2), new Date());
        et.setPk(new EmployeTachePK(1, 2, new Date()));
        cs.create(et);
        
      

    }

}
