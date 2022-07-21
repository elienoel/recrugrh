import java.io.IOException;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


public class Login {
    
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
        
        if (tel.equals("0000000000") && pwd1.equals("admin1234")) {
            App.root = FXMLLoader.load(getClass().getResource("ui/home.fxml"));
        }else{
            System.out.println("ok");
            App.root = FXMLLoader.load(getClass().getResource("ui/dossier.fxml"));
        }
        
        
        App.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        App.scene = new Scene(App.root);
        App.stage.setScene(App.scene);
        App.stage.show();
    }

    @FXML
    void inscription(ActionEvent event) throws IOException, ClassNotFoundException {
        String nom= TFnom.getText();
        String prenom= TFprenom.getText();
        String tel= TFtel_insc.getText();
        String dtnaiss= DFdatenaiss.getValue().toString();

        String pwd1= TFpwd_insc.getText();
        String pwd2= TFconfirmpwd.getText();
        
        if (pwd1.equals(pwd2)) {
            try {
                String query = "INSERT INTO `candidat`(`NUMCANDIDAT`, `NOMCANDIDAT`, `PRENOMCANDIDAT`, `DATENAISS`, `CONTACTS`) VALUES (UUID(),?,?,?,?)";
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = App.con.prepareStatement(query);
                preparedStmt.setString (1, nom);
                preparedStmt.setString (2, prenom);
                preparedStmt.setString (3, dtnaiss);
                preparedStmt.setString (4, tel);
                // preparedStmt.setString (5, pwd1);
                // execute the preparedstatement
                preparedStmt.execute();
                App.con.close();
    
            } catch (SQLException a) {
                a.printStackTrace();
            }
            System.out.println("ok");
            App.root = FXMLLoader.load(getClass().getResource("ui/dossier.fxml"));
            App.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            App.scene = new Scene(App.root);
            App.stage.setScene(App.scene);
            App.stage.show();
            
        } else {
            Alert a1 = new Alert(AlertType.ERROR,"vous avez saisir des mots de passe differents",ButtonType.APPLY);
            // show the dialog
            a1.show();
        }
        
        
    }

}
