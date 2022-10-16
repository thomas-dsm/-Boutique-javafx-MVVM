package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ParfumVM extends ArticleVM{

    private ObservableList<FragranceVM> lesFragrancesObs = FXCollections.observableArrayList();
    private ListProperty<FragranceVM> lesFragrances = new SimpleListProperty<>(lesFragrancesObs);
        public ObservableList<FragranceVM> getGetlesFragrances() {return FXCollections.unmodifiableObservableList(lesFragrances.get());}
        public ListProperty<FragranceVM> lesFragrancesProperty() {return lesFragrances;}

    public ParfumVM(Parfum parfum) {
        super(parfum);

        for (Fragrance fragrance : parfum.getListFragrances()){
            lesFragrances.add(new FragranceVM(fragrance));
        }
        getModel().ajouterListener(this);
    }

    public void addFragrance(String text) {
        ((Parfum) getModel()).ajouterFragrance(new Fragrance(text));
    }

    public void removeFragrance(FragranceVM fragranceVM){
        lesFragrances.remove(fragranceVM);
        ((Parfum)getModel()).supprimerFragrance(fragranceVM.getModel());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Parfum.PROP_LISTF_ADD)){
            Fragrance fragrance = (Fragrance) evt.getNewValue();
            lesFragrances.add(new FragranceVM(fragrance));
        }
    }
}
