

import java.sql.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {


    @FXML
    private Label showmsg;

    @FXML
    private TextArea TFmessage;

    @FXML
    private TextField TFnom;

    @FXML
    private TextField TFemail;

    @FXML
    private TextField TFprenom;

    @FXML
    private TextField TFsujet;

    public void initialize() {
        // String javaVersion = System.getProperty("java.version");
        // String javafxVersion = System.getProperty("javafx.version");
        // label.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");
    }



    @FXML
    void annuler(ActionEvent event) {
        TFemail.setText("");
        TFmessage.setText("");
        TFnom.setText("");
        TFprenom.setText("");
        TFsujet.setText("");
    }

    @FXML
    void envoyerMsg(ActionEvent event) throws ClassNotFoundException {
        String nom= TFnom.getText();
        String prenom= TFprenom.getText();
        String email= TFemail.getText();
        String sujet = TFsujet.getText();
        String message = TFmessage.getText();
        showmsg.setText(message);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmessage","root","");
            // String query = "INSERT INTO `discussion`( `nom`, `email`, `sujet`, `message`) " + " values (?,?, ?, ?)";
            String query = "INSERT INTO `candidat`(`NUMCANDIDAT`, `DATEPOST`, `NOMCANDIDAT`, `PRENOMCANDIDAT`, `DATENAISS`, `CONTACTS`, `REFERENCE`) VALUES ('?','?','?','?','?','?','?')";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, nom+" "+prenom);
            preparedStmt.setString (2, email);
            preparedStmt.setString (3, sujet);
            preparedStmt.setString (4, message);
            // execute the preparedstatement
            preparedStmt.execute();
            con.close();

        } catch (SQLException a) {
            a.printStackTrace();
        }
    }
}