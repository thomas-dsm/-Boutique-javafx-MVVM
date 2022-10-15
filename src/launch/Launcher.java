package launch;

import data.Sauveur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import viewmodel.MagazinVM;

public class Launcher extends Application {

    private static MagazinVM magazinVM;

    @Override
    public void start(Stage stage) throws Exception {
        magazinVM = new MagazinVM();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/FenetrePrincipale.fxml"));
        Scene scene =  new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        new Sauveur().save(magazinVM.getModel());
        super.stop();
    }

    public static MagazinVM getMagazinVM() {
        return magazinVM;
    }
}
