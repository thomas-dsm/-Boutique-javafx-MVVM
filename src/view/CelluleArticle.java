package view;

import javafx.scene.control.ListCell;
import viewmodel.ArticleVM;

public class CelluleArticle extends ListCell<ArticleVM> {

    @Override
    protected void updateItem(ArticleVM articleVM, boolean b) {
        super.updateItem(articleVM, b);

        if (!b){
            textProperty().bind(articleVM.nomProperty());
        } else {
            textProperty().unbind();
            setText("");
            setGraphic(null);
        }
    }
}
