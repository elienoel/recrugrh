

import java.io.IOException;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class ExperienceForm {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button Btnajouter;

    @FXML
    private TextField TFperiode;

    @FXML
    private TextField TFtitre;

    @FXML
    private TextField TFrecom;

    @FXML
    void Ajouter(ActionEvent event) throws ClassNotFoundException, IOException {
        String period= TFperiode.getText();
        String titre= TFtitre.getText();
        String recommandation= TFrecom.getText();
        
        try {
           String query = "INSERT INTO `exp_prof`(`NUMCANDIDAT`, `DOMAINE`, `PERIODE`, `RECOMMANDATION`) VALUES (?,?,?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = App.con.prepareStatement(query);
            preparedStmt.setString (1, App.userId);
            preparedStmt.setString (2, titre);
            preparedStmt.setString (3, period);
            preparedStmt.setString (4, recommandation);
            // execute the preparedstatement
            preparedStmt.execute();
            App.con.close();
            System.out.println(App.userId);

        } catch (SQLException a) {
            a.printStackTrace();
        }
        System.out.println("ok");
        root = FXMLLoader.load(getClass().getResource("ui/dossier.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
