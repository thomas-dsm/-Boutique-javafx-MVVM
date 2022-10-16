package model;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Taille implements Serializable {

    public transient PropertyChangeSupport support;
    private String nomTaille;
    public static final String PROP_NOM_TAILLE = "prop.model.nom.taille";

    public Taille(String nomTaille) {
        this.nomTaille = nomTaille;
    }

    public String getNomTaille() {
        return nomTaille;
    }

    public void setNomTaille(String nomTaille) {
        String oldTaille = this.nomTaille;
        this.nomTaille = nomTaille;
        getSupport().firePropertyChange(PROP_NOM_TAILLE, oldTaille, this.nomTaille);
    }

    public PropertyChangeSupport getSupport() {
        if (support == null){
            support = new PropertyChangeSupport(this);
        }
        return support;
    }
}
