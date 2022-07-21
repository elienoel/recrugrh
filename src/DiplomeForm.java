
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
public class DiplomeForm {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button BtnajouterDip;

    @FXML
    private TextField TFannee;

    @FXML
    private TextField TFecole;

    @FXML
    private TextField TFintitule;

    @FXML
    private TextField TFmention;

    @FXML
    private TextField TFpays;

    @FXML
    private TextField TFsigl;

    @FXML
    void AjouterDip(ActionEvent event) throws IOException, ClassNotFoundException {
        String intitule= TFintitule.getText();
        String mention= TFmention.getText();
        String ecole= TFecole.getText();
        String annee= TFannee.getText();
        String sigl= TFsigl.getText();
        
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            // Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ateliergl","root","");
            String query = "INSERT INTO `exp_prof`(`ID_EXP`,`DOMAINE`, `PERIODE`) VALUES (UUID(),?,?)";
            
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = App.con.prepareStatement(query);
            preparedStmt.setString (1, annee);
            preparedStmt.setString (2, mention);
            // execute the preparedstatement
            preparedStmt.execute();
            App.con.close();

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
