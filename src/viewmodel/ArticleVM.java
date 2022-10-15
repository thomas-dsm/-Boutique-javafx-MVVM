package viewmodel;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Article;
import model.Habit;
import model.Parfum;


public abstract class ArticleVM {
    private Article model;
    private StringProperty nom = new SimpleStringProperty();
    private FloatProperty prix = new SimpleFloatProperty();

    public ArticleVM(Article model) {
        this.nom.set(model.getNom());
        this.nom.addListener((__,___,newV)->model.setNom(newV));
        this.prix.set(model.getPrix());
        this.prix.addListener((__,___,newV)-> model.setPrix((Float) newV));
        this.model = model;
    }

    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public float getPrix() {
        return prix.get();
    }

    public FloatProperty prixProperty() {
        return prix;
    }

    public Article getModel() {
        return model;
    }
}
