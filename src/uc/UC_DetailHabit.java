package uc;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.NumberStringConverter;
import view.CelluleCouleur;
import view.CelluleTaille;
import viewmodel.CouleurVM;
import viewmodel.HabitVM;
import viewmodel.TailleVM;

import java.io.IOException;

public class UC_DetailHabit extends BorderPane {

    @FXML
    TextField tf_nomarticle;
    @FXML
    TextField tf_prixarticle;
    @FXML
    ListView listeCouleur;
    @FXML
    ListView listeTaille;

    @FXML
    ColorPicker colorPicker;
    @FXML
    Button btn_ajouter_taille;
    @FXML
    MenuButton menu_taille;
    @FXML
    MenuItem menuItemS;
    @FXML
    MenuItem menuItemM;
    @FXML
    MenuItem menuItemL;
    @FXML
    MenuItem menuItemXL;
    HabitVM habit;


    public UC_DetailHabit(HabitVM habitVM) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/uc/DetailHabit.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();

        habit = habitVM;

        tf_nomarticle.textProperty().bindBidirectional(habitVM.nomProperty());
        tf_prixarticle.textProperty().bindBidirectional(habitVM.prixProperty(), new NumberStringConverter());

        menuItemS = new MenuItem("S");
        menuItemM = new MenuItem("M");
        menuItemL = new MenuItem("L");
        menuItemXL = new MenuItem("XL");

        menu_taille.setText("Taille");
        menu_taille.getItems().add(menuItemS);
        menu_taille.getItems().add(menuItemM);
        menu_taille.getItems().add(menuItemL);
        menu_taille.getItems().add(menuItemXL);

        listeTaille.itemsProperty().bind(habitVM.lesTaillesProperty());
        listeCouleur.itemsProperty().bind(habitVM.lesCouleursProperty());

        listeCouleur.setCellFactory(__->new CelluleCouleur());
        listeTaille.setCellFactory(__->new CelluleTaille());

        menuTaillesSet();
    }

    public void ajouterTaille(){
        if (!menu_taille.getText().equals("Taille")){
            habit.addTaille(menu_taille.getText());
            menu_taille.setText("Taille");
        }
    }
    public void ajouterCouleur(){
        habit.addCouleur(String.valueOf(colorPicker.getValue()));
    }

    public void menuTaillesSet(){
        menuItemS.setOnAction(e->{menu_taille.setText(menuItemS.getText());});
        menuItemM.setOnAction(e->{menu_taille.setText(menuItemM.getText());});
        menuItemL.setOnAction(e->{menu_taille.setText(menuItemL.getText());});
        menuItemXL.setOnAction(e->{menu_taille.setText(menuItemXL.getText());});
    }
}
