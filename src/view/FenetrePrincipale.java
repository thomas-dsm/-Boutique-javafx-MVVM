package view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import launch.Launcher;
import uc.UC_DetailHabit;
import uc.UC_DetailParfum;
import viewmodel.ArticleVM;
import viewmodel.HabitVM;
import viewmodel.MagazinVM;
import viewmodel.ParfumVM;

import java.io.IOException;

public class FenetrePrincipale {


    @FXML
    ListView<ArticleVM> listArticle;
    @FXML
    BorderPane bp;
    MagazinVM magazinVM;

    @FXML
    public void initialize(){
        magazinVM = Launcher.getMagazinVM();

        UC_DetailParfum uc_detailParfum = null;
        UC_DetailHabit uc_detailHabit = null;

        listArticle.itemsProperty().bind(magazinVM.lesArticlesProperty());
        listArticle.setCellFactory(__->new CelluleArticle());

        listArticle.getSelectionModel().selectedItemProperty().addListener((__,oldArticle,newArticle)->{
            try {
                bp.setCenter(null);
                if (newArticle != null){
                    if (newArticle.getClass() == ParfumVM.class){
                        if (uc_detailParfum == null){
                            bp.setCenter(new UC_DetailParfum((ParfumVM) newArticle));
                        } else {
                            bp.setCenter(uc_detailHabit);
                        }
                    }
                    if (newArticle.getClass() == HabitVM.class){
                        if (uc_detailHabit == null){
                            bp.setCenter(new UC_DetailHabit((HabitVM) newArticle));
                        } else {
                            bp.setCenter(uc_detailHabit);
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    public void ajouterHabit() {
        magazinVM.addArticle("Habit");
    }

    public void ajouterParfum() {magazinVM.addArticle("Parfum");}

    public void supprimerArticle() {
        ArticleVM a = listArticle.getSelectionModel().selectedItemProperty().get();
        magazinVM.removeArticle(a);
    }
}
