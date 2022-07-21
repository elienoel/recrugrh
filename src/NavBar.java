import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NavBar {

    @FXML
    private Button BtnAcceuil;

    @FXML
    private Button BtnCandidats;

    @FXML
    private Button BtnDeconnexion;

    @FXML
    private Button BtnEcoles;

    @FXML
    private Button BtnOffres;

    @FXML
    void goToAcceuil(ActionEvent event) throws IOException {
        App.root = FXMLLoader.load(getClass().getResource("ui/home.fxml"));
        App.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        App.scene = new Scene(App.root);
        App.stage.setScene(App.scene);
        App.stage.show();
    }

    @FXML
    void goToCandidats(ActionEvent event) throws IOException {
        App.root = FXMLLoader.load(getClass().getResource("ui/candidat.fxml"));
        App.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        App.scene = new Scene(App.root);
        App.stage.setScene(App.scene);
        App.stage.show();
    }

    @FXML
    void goToEcoles(ActionEvent event) throws IOException {
        App.root = FXMLLoader.load(getClass().getResource("ui/ecoles.fxml"));
        App.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        App.scene = new Scene(App.root);
        App.stage.setScene(App.scene);
        App.stage.show();
    }

    @FXML
    void goToOffres(ActionEvent event) throws  IOException{
        App.root = FXMLLoader.load(getClass().getResource("ui/offres.fxml"));
        App.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        App.scene = new Scene(App.root);
        App.stage.setScene(App.scene);
        App.stage.show();
    }

    @FXML
    void logout(ActionEvent event) {

    }

}
