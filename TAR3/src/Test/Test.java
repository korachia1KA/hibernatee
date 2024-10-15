/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.Date;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.HommeFemmePK;
import ma.projet.beans.Mariage;
import ma.projet.service.*;

/**
 *
 * @author kor
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HommeService hs = new HommeService();
        FemmeService fs = new FemmeService();
        
        hs.create(new Homme("korac","nor","0694204894","El Jadida",new Date(2002,06,24)));
        fs.create(new Femme("Toto","Tata","0694208749","El Jadida",new Date(2008,06,28)));
        
        MariageService ms = new MariageService();
        
        Mariage mariage = new Mariage(hs.findById(1),fs.findById(2),new Date(),0);
        mariage.setPk(new HommeFemmePK(1,2,new Date()));
        ms.create(mariage);
    }
    
}
