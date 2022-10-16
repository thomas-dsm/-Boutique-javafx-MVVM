package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public abstract class Article implements Serializable {

    private transient PropertyChangeSupport support;
    private String nom;
    public static final String PROP_NOM = "prop.model.nom";
    private float prix;
    public static final String PROP_PRIX = "prop.model.prix";

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        String oldNom = this.nom;
        this.nom = nom;
        getSupport().firePropertyChange(PROP_NOM, oldNom, this.nom);
    }

    public float getPrix() {return prix;}

    public void setPrix(float prix) {
        float oldPrix = this.prix;
        this.prix = prix;
        getSupport().firePropertyChange(PROP_PRIX, oldPrix, this.prix);
    }

    public PropertyChangeSupport getSupport() {
        if (support == null){
            support = new PropertyChangeSupport(this);
        }
        return support;
    }

    public void ajouterListener(PropertyChangeListener listener){
        getSupport().addPropertyChangeListener(listener);
    }

    public Article(String nom, float prix) {
        this.nom = nom;
        this.prix = prix;
    }
}
