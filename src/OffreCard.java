import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.Offre;

public class OffreCard {

    @FXML
    private Label LBdescription;

    @FXML
    private Label LBtitre;

    @FXML
    private Button btnPostuler;

    @FXML
    void postuler(ActionEvent event) {

    }

    public void setData(Offre offre){
        LBtitre.setText(offre.getTitre());
        LBdescription.setText(offre.getDescription());
    }

}
