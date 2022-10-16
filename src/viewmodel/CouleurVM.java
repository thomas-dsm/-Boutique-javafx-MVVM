package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Couleur;

public class CouleurVM {

    private Couleur couleur;

    private StringProperty nomCouleur = new SimpleStringProperty();

    public String getNomCouleur() {
        return nomCouleur.get();
    }

    public StringProperty nomCouleurProperty() {
        return nomCouleur;
    }

    public void setNomCouleur(String nomCouleur) {
        this.nomCouleur.set(nomCouleur);
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public CouleurVM(Couleur couleur) {
        this.nomCouleur.set(couleur.getNomCouleur());
        this.nomCouleur.addListener((__,___,newV)-> this.couleur.setNomCouleur(newV));
        this.couleur = couleur;
    }
}
