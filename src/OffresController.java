import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.Offre;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OffresController {

    private ArrayList<Offre> offres=new ArrayList<Offre>();

    @FXML
    private BorderPane BDmain;

    @FXML
    private Button BtnEnreg;

    @FXML
    private TextArea TFdescription;

    @FXML
    private TextField TFtitre;

    @FXML
    private VBox VBoffreList;


    public void initialize() throws SQLException, IOException {
        FXMLLoader fxmlloaderN= new FXMLLoader();
        fxmlloaderN.setLocation(getClass().getResource("ui/navBar.fxml"));
        Pane navBar=fxmlloaderN.load();
        BDmain.setLeft(navBar);


        String query = "SELECT * FROM `offre`; ";
        Statement stmt = App.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
        ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String id= rs.getString("IDOFFRE");
            String titre= rs.getString("TITRE");
            String description = rs.getString("DESCRIPTION");

            Offre offre= new Offre(id,titre,description);
            offres.add(offre);
            System.out.println("element");
        }

        for (Offre offre : offres) {
            FXMLLoader fxmlloader= new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("ui/offre_card.fxml"));
            Pane cardBox=fxmlloader.load();
            OffreCard offreCard = fxmlloader.getController();
            offreCard.setData(offre);
            VBoffreList.getChildren().add(cardBox);
        }
        System.out.println("done");

    }

    @FXML
    void EnregistrerOffre(ActionEvent event) {
        String titre= TFtitre.getText();
        String description= TFdescription.getText();
        try {
            String query = "INSERT INTO `offre`( `TITRE`, `DESCRIPTION`) VALUES (?,?)";
 
             // create the mysql insert preparedstatement
             PreparedStatement preparedStmt = App.con.prepareStatement(query);
             preparedStmt.setString (1, titre);
             preparedStmt.setString (2, description);

             // execute the preparedstatement
             preparedStmt.execute();
             App.con.close();
            //  Alert a1 = new Alert(AlertType.CONFIRMATION,"competence enregistré",ButtonType.OK);
            //     a1.show();
            TFtitre.setText("");
            TFdescription.setText("");
 
         } catch (SQLException a) {
             a.printStackTrace();
         }
    }

}
