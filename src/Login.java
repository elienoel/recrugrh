
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.User;



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
    void connexion(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {

        String tel= TFtel.getText();
        String pwd1= TFpwd.getText();
        boolean canGoTO=true;
        if (tel.equals("0000000000") && pwd1.equals("admin1234")) {
            App.root = FXMLLoader.load(getClass().getResource("ui/home.fxml"));
            App.userId="ADMIN";
        }else{
            canGoTO =log_in(tel, pwd1);
  
            App.root = FXMLLoader.load(getClass().getResource("ui/dossier.fxml"));
        }
        
        if(canGoTO){
        App.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        App.scene = new Scene(App.root);
        App.stage.setScene(App.scene);
        App.stage.show();
        }
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
                String query = "INSERT INTO `candidat`(`NUMCANDIDAT`, `DATEPOST`, `NOMCANDIDAT`, `PRENOMCANDIDAT`, `DATENAISS`, `CONTACTS`, `PASSWORD`) VALUES (UUID(),CURDATE(),?,?,?,?,?)";
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = App.con.prepareStatement(query);
                preparedStmt.setString (1, nom);
                preparedStmt.setString (2, prenom);
                preparedStmt.setString (3, dtnaiss);
                preparedStmt.setString (4, tel);
                preparedStmt.setString (5, pwd1);
                // execute the preparedstatement
                preparedStmt.execute();
                
                App.user= new User("",nom,prenom,dtnaiss,tel,null);
    
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

    boolean log_in(String tel, String pwd) throws SQLException{
        String query = "SELECT * FROM `candidat` WHERE CONTACTS='"+tel+"' AND PASSWORD='"+pwd+"'; ";
            Statement stmt = App.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
             // checking if ResultSet is empty
            if (rs.next() == false) {
                Alert a1 = new Alert(AlertType.ERROR,"identifiant incorrect",ButtonType.APPLY);
                a1.show();
                return false;
            }else{
                rs.beforeFirst();
            } 
            while (rs.next()) {
                App.userId = rs.getString("NUMCANDIDAT");
                String nom = rs.getString("NOMCANDIDAT");
                String prenom = rs.getString("PRENOMCANDIDAT");
                String datenaiss = rs.getString("DATENAISS");
                String contact = rs.getString("CONTACTS");
                String note = rs.getString("NOTE");
                App.user= new User(App.userId,nom,prenom,datenaiss,contact,note);
                System.out.println();
            }
        return true;
    }

}
