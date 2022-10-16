package model;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Couleur implements Serializable {

    private PropertyChangeSupport support;
    private String nomCouleur;

    public final static String PROP_NOM_COULEUR = "prop.model.nom.couleur";

    public Couleur(String nomCouleur) {
        this.nomCouleur = nomCouleur;
    }

    public String getNomCouleur() {
        return nomCouleur;
    }

    public void setNomCouleur(String nomCouleur) {
        String oldCouleur = this.nomCouleur;
        this.nomCouleur = nomCouleur;
        getSupport().firePropertyChange(PROP_NOM_COULEUR, oldCouleur, this.nomCouleur);
    }

    public PropertyChangeSupport getSupport() {
        if (support == null){
            support = new PropertyChangeSupport(this);
        }
        return support;
    }
}
