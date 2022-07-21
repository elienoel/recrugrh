
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class Dossier {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField TFdomaine;

    @FXML
    private TextField TFniveau;

    @FXML
    private Button btnEnregComp;

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
    private VBox VBCompetence;

    @FXML
    private VBox VBDiplome;

    @FXML
    private VBox VBExperience;

    public void initialize() throws SQLException {
        LBnom.setText(App.user.getNomcandidat()+" "+App.user.getNomcandidat());
        LBtel.setText(App.user.getContacts());
        LBdtnaiss.setText(App.user.getDatenaiss());

        String query = "SELECT * FROM `competence` WHERE NUMCANDIDAT='"+App.user.getNumcandidat()+"'; ";
        Statement stmt = App.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
        ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String d= rs.getString("DOMAINE");
            String ni= rs.getString("NIVEAU");
            Label competenceL= new Label();
            competenceL.setText("> "+d+" : "+ni);
            VBCompetence.getChildren().add(competenceL);
            System.out.println("element");
        }
    }

    

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

    @FXML
    void enregistrerCompetence(ActionEvent event) {
        String domaine= TFdomaine.getText();
        String niveau= TFniveau.getText();
        try {
            String query = "INSERT INTO `competence`(`NUMCANDIDAT`, `DOMAINE`, `NIVEAU`) VALUES (?,?,?)";
 
             // create the mysql insert preparedstatement
             PreparedStatement preparedStmt = App.con.prepareStatement(query);
             preparedStmt.setString (1, App.userId);
             preparedStmt.setString (2, domaine);
             preparedStmt.setString (3, niveau);
             // execute the preparedstatement
             preparedStmt.execute();
             App.con.close();
             Alert a1 = new Alert(AlertType.CONFIRMATION,"competence enregistré",ButtonType.OK);
                a1.show();
            TFdomaine.setText("");
            TFniveau.setText("");
 
         } catch (SQLException a) {
             a.printStackTrace();
         }
    }

}
