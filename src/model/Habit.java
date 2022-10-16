package model;

import java.util.ArrayList;
import java.util.List;

public class Habit extends Article{

    List<Couleur> listCouleur = new ArrayList<>();
    public static final String PROP_LISTC_ADD = "prop.model.listc.add";
    public static final String PROP_LISTC_SUPPR = "prop.model.listc.supp";
    List<Taille> listTaille = new ArrayList<>();
    public static final String PROP_LISTT_ADD = "prop.model.listt.add";
    public static final String PROP_LISTT_SUPPR = "prop.model.listt.supp";

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

    public void ajouterTaille(Taille taille){
        listTaille.add(taille);
    }

    public void ajouterCouleur(Couleur couleur){
        listCouleur.add(couleur);
    }

    public void supprimerTaille(Taille taille){
        listTaille.remove(taille);
    }

    public void supprimerCouleur(Couleur couleur){
        listCouleur.remove(couleur);
    }
}
