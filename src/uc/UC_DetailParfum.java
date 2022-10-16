package uc;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.NumberStringConverter;
import view.CelluleFragrance;
import viewmodel.FragranceVM;
import viewmodel.ParfumVM;

import java.io.IOException;

public class UC_DetailParfum extends BorderPane {

    @FXML
    TextField tf_nomarticle;
    @FXML
    TextField tf_prixarticle;
    @FXML
    TextField tf_nomfragrance;
    @FXML
    ListView listFragrance;
    @FXML
    Button btn_ajouterflagrance;
    @FXML
    Button btn_supprimerflagrance;
    @FXML
    Button btn_desectionnerflagrance;

    ParfumVM parfum;

    public UC_DetailParfum(ParfumVM parfumVM) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/uc/DetailParfum.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();

        parfum = parfumVM;

        tf_nomarticle.textProperty().bindBidirectional(parfumVM.nomProperty());
        tf_prixarticle.textProperty().bindBidirectional(parfumVM.prixProperty(), new NumberStringConverter());
        tf_nomfragrance.textProperty().addListener((__,oldF,newF)->{
            if (!newF.equals("")){
                btn_ajouterflagrance.setDisable(false);
            } else {
                btn_ajouterflagrance.setDisable(true);
            }
        });

        listFragrance.itemsProperty().bind(parfumVM.lesFragrancesProperty());
        listFragrance.setCellFactory(__-> new CelluleFragrance());

        listFragrance.getSelectionModel().selectedItemProperty().addListener((__,___, newF)->{
            if (newF != null){
                disableButtons(false);
            }
        });
    }

    public void ajouterFragrance(){
        parfum.addFragrance(tf_nomfragrance.getText());
        tf_nomfragrance.clear();
        btn_ajouterflagrance.setDisable(true);
    }

    public void supprimerFragrance(){
        parfum.removeFragrance((FragranceVM) listFragrance.getSelectionModel().getSelectedItem());
        disableButtons(true);
    }

    public void deselectionnerFragrance(){
        disableButtons(true);
    }

    public void disableButtons(boolean etat){
        btn_desectionnerflagrance.setDisable(etat);
        btn_supprimerflagrance.setDisable(etat);
    }
}
