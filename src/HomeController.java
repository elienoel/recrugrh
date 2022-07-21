import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.User;

public class HomeController {

    private ArrayList<User> topCandidat=new ArrayList<User>();
    // private ArrayList<User> topCandidat;

    
    @FXML
    private BorderPane BPmain;


    @FXML
    private HBox candidatLayout;

    @FXML
    private VBox ecoleLayout;

    @FXML
    private GridPane offresLayout;


    public void initialize() throws SQLException, IOException {
        FXMLLoader fxmlloaderN= new FXMLLoader();
        fxmlloaderN.setLocation(getClass().getResource("ui/navBar.fxml"));
        Pane navBar=fxmlloaderN.load();
        BPmain.setLeft(navBar);


        String query = "SELECT * FROM `candidat`; ";
        Statement stmt = App.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
        ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String id= rs.getString("NUMCANDIDAT");
            String nom = rs.getString("NOMCANDIDAT");
            String prenom = rs.getString("PRENOMCANDIDAT");
            String datenaiss = rs.getString("DATENAISS");
            String contact = rs.getString("CONTACTS");
            String note = rs.getString("NOTE");
            User user= new User(id,nom,prenom,datenaiss,contact,note);
            topCandidat.add(user);
            System.out.println("element");
        }

        for (User user : topCandidat) {
            FXMLLoader fxmlloader= new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("ui/candidat_card.fxml"));
            Pane cardBox=fxmlloader.load();
            CandidatCard candidatCard = fxmlloader.getController();
            candidatCard.setData(user);
            candidatLayout.getChildren().add(cardBox);
        }
        System.out.println("done");

    }

}
