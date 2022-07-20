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
    void Ajouter(ActionEvent event) throws ClassNotFoundException, IOException {
        String period= TFperiode.getText();
        String titre= TFtitre.getText();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ateliergl","root","");
            String query = "INSERT INTO `exp_prof`(`ID_EXP`,`DOMAINE`, `PERIODE`) VALUES (UUID(),?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, titre);
            preparedStmt.setString (2, period);
            // execute the preparedstatement
            preparedStmt.execute();
            con.close();

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
