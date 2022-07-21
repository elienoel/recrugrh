import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;





import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.User;

public class CandidatController {

    private ArrayList<User> newCandidat=new ArrayList<User>();
    private ArrayList<User> topCandidat=new ArrayList<User>();


    @FXML
    private BorderPane BPmain;

    @FXML
    private HBox candidatList1;

    @FXML
    private VBox candidatList2;


    public void initialize() throws SQLException, IOException {
        FXMLLoader fxmlloaderN= new FXMLLoader();
        fxmlloaderN.setLocation(getClass().getResource("ui/navBar.fxml"));
        Pane navBar=fxmlloaderN.load();
        BPmain.setLeft(navBar);


        String query = "SELECT * FROM `candidat` WHERE `NOTE`is NULL; ";
        Statement stmt = App.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
        ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String id= rs.getString("NUMCANDIDAT");
            String nom = rs.getString("NOMCANDIDAT");
            String prenom = rs.getString("PRENOMCANDIDAT");
            String datenaiss = rs.getString("DATENAISS");
            String contact = rs.getString("CONTACTS");
            User user= new User(id,nom,prenom,datenaiss,contact,null);
            newCandidat.add(user);
            System.out.println("element");
        }

        for (User user : newCandidat) {
            FXMLLoader fxmlloader= new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("ui/candidat_card.fxml"));
            Pane cardBox=fxmlloader.load();
            CandidatCard candidatCard = fxmlloader.getController();
            candidatCard.setData(user);
            candidatList1.getChildren().add(cardBox);
        }
        System.out.println("done");



        query = "SELECT * FROM `candidat` WHERE `NOTE` is not NULL ORDER BY NOTE DESC; ";
        Statement stmt2 = App.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
        ResultSet.CONCUR_READ_ONLY);
        rs = stmt2.executeQuery(query);
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
            candidatList2.getChildren().add(cardBox);
        }
        System.out.println("done");

    }
}
