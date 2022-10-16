package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Parfum extends Article{

    public static final String PROP_LISTF_ADD = "prop.model.listf.add";
    public static final String PROP_LISTF_SUPPR = "prop.model.listf.supp";
    List<Fragrance> listFragrances = new ArrayList<>();

    public Parfum(String nom, float prix) {
        super(nom, prix);
    }

    public List<Fragrance> getListFragrances() {
        return listFragrances;
    }

    public void setListFragrances(List<Fragrance> listFragrances) {
        this.listFragrances = listFragrances;
    }

    public void ajouterFragrance(Fragrance fragrance) {
        listFragrances.add(fragrance);
        getSupport().firePropertyChange(PROP_LISTF_ADD, null, fragrance);
    }

    public void supprimerFragrance(Fragrance fragrance) {
        listFragrances.remove(fragrance);
        getSupport().firePropertyChange(PROP_LISTF_SUPPR,fragrance, null);
    }
}
