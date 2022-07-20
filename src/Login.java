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
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class Login {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button BtnConnexion;

    @FXML
    private Button BtnInscription;

    @FXML
    private DatePicker DFdatenaiss;

    @FXML
    private PasswordField TFconfirmpwd;

    @FXML
    private TextField TFnom;

    @FXML
    private TextField TFprenom;

    @FXML
    private PasswordField TFpwd;

    @FXML
    private PasswordField TFpwd_insc;

    @FXML
    private TextField TFtel;

    @FXML
    private TextField TFtel_insc;

    @FXML
    void connexion(ActionEvent event) throws IOException, ClassNotFoundException {

        String tel= TFtel.getText();
        String pwd1= TFpwd.getText();
        

        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmessage","root","");
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

    @FXML
    void inscription(ActionEvent event) throws IOException, ClassNotFoundException {
        String nom= TFnom.getText();
        String prenom= TFprenom.getText();
        String tel= TFtel_insc.getText();
        String dtnaiss= DFdatenaiss.getValue().toString();

        String pwd1= TFpwd_insc.getText();
        String pwd2= TFconfirmpwd.getText();
        

        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ateliergl","root","");
            // String query = "INSERT INTO `discussion`( `nom`, `email`, `sujet`, `message`) " + " values (?,?, ?, ?)";
            String query = "INSERT INTO `candidat`(`NUMCANDIDAT`, `NOMCANDIDAT`, `PRENOMCANDIDAT`, `DATENAISS`, `CONTACTS`) VALUES (UUID(),?,?,?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, nom);
            preparedStmt.setString (2, prenom);
            preparedStmt.setString (3, dtnaiss);
            preparedStmt.setString (4, tel);
            // preparedStmt.setString (5, pwd1);
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
