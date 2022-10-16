package model;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Fragrance implements Serializable {

    private transient PropertyChangeSupport support;

    private String nomFragrance;
    public static final String PROP_NOM_FRAGRANCE = "prop.model.nomfrag";

    public String getNomFragrance() {
        return nomFragrance;
    }

    public void setNomFragrance(String nomFragrance) {
        String oldNomF = this.nomFragrance;
        this.nomFragrance = nomFragrance;
        getSupport().firePropertyChange(PROP_NOM_FRAGRANCE, oldNomF, this.nomFragrance);
    }

    public Fragrance(String nomFragrance) {
        this.nomFragrance = nomFragrance;
    }

    private PropertyChangeSupport getSupport() {
        if (support == null){
            support = new PropertyChangeSupport(this);
        }
        return support;
    }
}
