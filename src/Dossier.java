import java.io.IOException;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Dossier {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Button BtnAjouterDip;

    @FXML
    private Button BtnModifier;

    @FXML
    private Button BtnajouterExp;

    @FXML
    private Button Btnlogout;

    @FXML
    private Label LBdtnaiss;

    @FXML
    private Label LBnom;

    @FXML
    private Label LBtel;

    @FXML
    void AjouterDipForm(ActionEvent event) throws IOException {
        System.out.println("ok");
        root = FXMLLoader.load(getClass().getResource("ui/diplomeForm.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ajouterForm(ActionEvent event) throws IOException {
        System.out.println("ok");
        root = FXMLLoader.load(getClass().getResource("ui/experienceForm.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void modifierInfo(ActionEvent event) {

    }

}
