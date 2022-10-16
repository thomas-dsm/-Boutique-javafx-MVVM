package viewmodel;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Fragrance;

public class FragranceVM {

    private Fragrance model;

    private StringProperty nomFragrance = new SimpleStringProperty();

    public String getNomFragrance() {
        return nomFragrance.get();
    }

    public StringProperty nomFragranceProperty() {
        return nomFragrance;
    }

    public Fragrance getModel() {
        return model;
    }

    public void setModel(Fragrance model) {
        this.model = model;
    }

    public FragranceVM(Fragrance model) {
        this.nomFragrance.set(model.getNomFragrance());
        this.nomFragrance.addListener((__,___,newV)->model.setNomFragrance(newV));
        this.model = model;
    }
}
