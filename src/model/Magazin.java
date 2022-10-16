package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Magazin implements Serializable {

    private PropertyChangeSupport support;
    public static final String PROP_LIST_ADD = "prop.model.list.add";
    public static final String PROP_LIST_SUPPR = "prop.model.list.supp";

    List<Article> listArticles = new ArrayList<>();

    public Magazin(List<Article> listArticles) {
        this.listArticles = listArticles;
    }

    public void ajouterListener(PropertyChangeListener listener){
        getSupport().addPropertyChangeListener(listener);
    }

    public List<Article> getListArticles() {
        return Collections.unmodifiableList(listArticles);
    }

    public void ajouterArticle(Article article) {
        listArticles.add(article);
        getSupport().firePropertyChange(PROP_LIST_ADD, null, article);
    }

    public void supprimerArticle(Article article) {listArticles.remove(article);}

    private PropertyChangeSupport getSupport() {
        if (support == null){
            support = new PropertyChangeSupport(this);
        }
        return support;
    }
}
