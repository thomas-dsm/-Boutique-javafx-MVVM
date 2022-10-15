package model;

import java.util.ArrayList;
import java.util.List;

public class Parfum extends Article{

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
}
