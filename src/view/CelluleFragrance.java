package view;

import javafx.scene.control.ListCell;
import viewmodel.FragranceVM;

public class CelluleFragrance extends ListCell<FragranceVM> {

    @Override
    protected void updateItem(FragranceVM fragranceVM, boolean b) {
        super.updateItem(fragranceVM, b);

        if (!b){
            textProperty().bind(fragranceVM.nomFragranceProperty());
        } else {
            textProperty().unbind();
            setText("");
        }
    }
}
