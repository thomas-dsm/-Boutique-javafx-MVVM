package view;

import javafx.scene.control.ListCell;
import viewmodel.TailleVM;

public class CelluleTaille extends ListCell<TailleVM> {

    @Override
    protected void updateItem(TailleVM tailleVM, boolean b) {
        super.updateItem(tailleVM, b);

        if (!b){
            textProperty().bind(tailleVM.nomTailleProperty());
        } else {
            textProperty().unbind();
            setText("");
        }
    }
}
