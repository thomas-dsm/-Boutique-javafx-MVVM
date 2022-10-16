package viewmodel;

import data.Chargeur;
import data.Stub;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Article;
import model.Habit;
import model.Magazin;
import model.Parfum;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InvalidClassException;

public class MagazinVM implements PropertyChangeListener {

    private Magazin model;

    private ObservableList<ArticleVM> lesArticlesObs = FXCollections.observableArrayList();
    private ListProperty<ArticleVM> lesArticles = new SimpleListProperty<ArticleVM>(lesArticlesObs);
        public ObservableList<ArticleVM> getLesArticles() {return FXCollections.unmodifiableObservableList((lesArticles.get()));}
        public ListProperty<ArticleVM> lesArticlesProperty() {return lesArticles;}
        public void setLesArticles(ObservableList<ArticleVM> lesArticles) {this.lesArticles.set(lesArticles);}

    public Magazin getModel() {
        return model;
    }

    public MagazinVM() {
            try{
                this.model = new Chargeur().load();
            } catch (Exception e){
                System.out.println("Erreur => Chargement du stub");
                this.model = new Magazin(new Stub().creerMagazin());
            }

            for(Article article : model.getListArticles()){
                if (article instanceof Parfum parfum){
                    lesArticles.add(new ParfumVM(parfum));
                } else if (article instanceof Habit habit){
                    lesArticles.add(new HabitVM(habit));
                }
            }

            model.ajouterListener(this);
    }

    public void addArticle(String laClass){
            Article article = null;
            if (laClass.equals("Parfum")){
                article = new Parfum("nouveauParfum", 0);
            }
            if (laClass.equals("Habit")){
                article = new Habit("nouveauHabit",0);
            }
            model.ajouterArticle(article);
    }

    public void removeArticle(ArticleVM articleVM){
            lesArticles.remove(articleVM);
            model.supprimerArticle(articleVM.getModel());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Magazin.PROP_LIST_ADD)){
            Article article = (Article) evt.getNewValue();
            if (article instanceof Parfum parfum){
                lesArticles.add(new ParfumVM(parfum));
            } else if (article instanceof Habit habit){
                lesArticles.add(new HabitVM(habit));
            }
        }
    }
}
