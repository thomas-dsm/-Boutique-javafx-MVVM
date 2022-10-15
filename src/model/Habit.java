package model;

import java.util.ArrayList;
import java.util.List;

public class Habit extends Article{

    List<Couleur> listCouleur = new ArrayList<>();
    List<Taille> listTaille = new ArrayList<>();

    public Habit(String nom, float prix) {
        super(nom, prix);
    }

    public List<Couleur> getListCouleur() {
        return listCouleur;
    }

    public void setListCouleur(List<Couleur> listCouleur) {
        this.listCouleur = listCouleur;
    }

    public List<Taille> getListTaille() {
        return listTaille;
    }

    public void setListTaille(List<Taille> listTaille) {
        this.listTaille = listTaille;
    }
}
