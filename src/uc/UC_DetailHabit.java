package uc;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.NumberStringConverter;
import viewmodel.HabitVM;

import java.io.IOException;

public class UC_DetailHabit extends BorderPane {

    @FXML
    TextField tf_nomarticle;
    @FXML
    TextField tf_prixarticle;

    public UC_DetailHabit(HabitVM habitVM) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/uc/DetailHabit.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();

        tf_nomarticle.textProperty().bindBidirectional(habitVM.nomProperty());
        tf_prixarticle.textProperty().bindBidirectional(habitVM.prixProperty(), new NumberStringConverter());
    }
}
