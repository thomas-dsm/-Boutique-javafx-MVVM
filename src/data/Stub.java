package data;

import javafx.scene.paint.Color;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class Stub {
    public List<Article> creerMagazin(){
        List<Article> m = new ArrayList<>();

        Parfum p1 = new Parfum("parfum1", 25.5f);
        Parfum p2 = new Parfum("parfum2", 30);
        p1.setListFragrances(creerListFragrance());
        p2.setListFragrances(creerListFragrance());
        m.add(p1);
        m.add(p2);

        Habit h1 = new Habit("habit1", 12);
        Habit h2 = new Habit("habit2", 14.50f);
        h1.setListCouleur(creerListCouleur());
        h1.setListTaille(creerListTaille());
        h2.setListCouleur(creerListCouleur());
        h2.setListTaille(creerListTaille());

        m.add(h1);
        m.add(h2);

        return m;
    }

    public List<Fragrance> creerListFragrance(){

        List<Fragrance> lf = new ArrayList<>();

        Fragrance f1 = new Fragrance("boisés");
        Fragrance f2 = new Fragrance("fougères");
        Fragrance f3 = new Fragrance("fleuris");
        Fragrance f4 = new Fragrance("orientale");

        lf.add(f1);
        lf.add(f2);
        lf.add(f3);
        lf.add(f4);

        return lf;
    }

    public List<Taille> creerListTaille(){

        List<Taille> lt = new ArrayList<>();

        Taille t1 = new Taille("S");
        Taille t2 = new Taille("M");
        Taille t3 = new Taille("L");
        Taille t4 = new Taille("XL");

        lt.add(t1);
        lt.add(t2);
        lt.add(t3);
        lt.add(t4);

        return lt;
    }

    public List<Couleur> creerListCouleur(){

        List<Couleur> lc = new ArrayList<>();

        Couleur t1 = new Couleur(Color.RED.toString());
        Couleur t2 = new Couleur(Color.BLUE.toString());
        Couleur t3 = new Couleur(Color.YELLOW.toString());
        Couleur t4 = new Couleur(Color.GREEN.toString());

        lc.add(t1);
        lc.add(t2);
        lc.add(t3);
        lc.add(t4);

        return lc;
    }
}
