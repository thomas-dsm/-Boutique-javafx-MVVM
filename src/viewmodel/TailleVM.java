package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Taille;

public class TailleVM {

    private Taille model;

    private StringProperty nomTaille = new SimpleStringProperty();

    public Taille getModel() {
        return model;
    }


    public String getNomTaille() {
        return nomTaille.get();
    }

    public StringProperty nomTailleProperty() {
        return nomTaille;
    }

    public void setNomTaille(String nomTaille) {
        this.nomTaille.set(nomTaille);
    }

    public TailleVM(Taille model) {
        this.nomTaille.set(model.getNomTaille());
        this.nomTaille.addListener((__,___,newV)-> model.setNomTaille(newV));
        this.model = model;
    }
}
