package view;

import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;
import viewmodel.CouleurVM;

public class CelluleCouleur extends ListCell<CouleurVM> {
    @Override
    protected void updateItem(CouleurVM couleurVM, boolean b) {
        super.updateItem(couleurVM, b);
        if (!b){
            textProperty().bind(couleurVM.nomCouleurProperty());
            Color c = Color.web(couleurVM.nomCouleurProperty().get());
            setTextFill(c);
        } else {
            textProperty().unbind();
            setText("");
        }
    }
}
