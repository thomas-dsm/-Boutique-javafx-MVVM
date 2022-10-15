package uc;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.NumberStringConverter;
import viewmodel.ParfumVM;

import java.io.IOException;

public class UC_DetailParfum extends BorderPane {

    @FXML
    TextField tf_nomarticle;
    @FXML
    TextField tf_prixarticle;

    public UC_DetailParfum(ParfumVM parfumVM) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/uc/DetailParfum.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();

        tf_nomarticle.textProperty().bindBidirectional(parfumVM.nomProperty());
        tf_prixarticle.textProperty().bindBidirectional(parfumVM.prixProperty(), new NumberStringConverter());
    }
}
