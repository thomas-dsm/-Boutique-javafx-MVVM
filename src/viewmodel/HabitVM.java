package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.beans.PropertyChangeEvent;

public class HabitVM extends ArticleVM{

    private ObservableList<CouleurVM> lesCouleursObs = FXCollections.observableArrayList();
    private ListProperty<CouleurVM> lesCouleurs = new SimpleListProperty<>(lesCouleursObs);
        public ObservableList<CouleurVM> getLesCouleurs() {return FXCollections.unmodifiableObservableList(lesCouleurs.get());}
        public ListProperty<CouleurVM> lesCouleursProperty() {return lesCouleurs;}

    private ObservableList<TailleVM> lesTaillesObs = FXCollections.observableArrayList();

    private ListProperty<TailleVM> lesTailles = new SimpleListProperty<>(lesTaillesObs);
        public ObservableList<TailleVM> getLesTailles() {return FXCollections.unmodifiableObservableList(lesTailles.get());}
        public ListProperty<TailleVM> lesTaillesProperty() {return lesTailles;}

    public HabitVM(Habit habit) {

            super(habit);
            for (Taille taille : habit.getListTaille()){
                lesTailles.add(new TailleVM(taille));
            }
            for (Couleur couleur : habit.getListCouleur()){
                lesCouleurs.add(new CouleurVM(couleur));
            }
            getModel().ajouterListener(this);
    }

    public void addTaille(String text){
            lesTailles.add(new TailleVM(new Taille(text)));
            ((Habit) getModel()).ajouterTaille(new Taille(text));
    }

    public void addCouleur(String text){
            lesCouleurs.add(new CouleurVM(new Couleur(text)));
            ((Habit) getModel()).ajouterCouleur(new Couleur(text));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Habit.PROP_LISTC_ADD)){
            Couleur couleur = (Couleur) evt.getNewValue();
            lesCouleurs.add(new CouleurVM(couleur));
        }
        if (evt.getPropertyName().equals(Habit.PROP_LISTT_ADD)){
            Taille taille = (Taille) evt.getNewValue();
            lesTailles.add(new TailleVM(taille));
        }
    }
}
