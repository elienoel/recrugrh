import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.User;

public class CandidatCard {

    @FXML
    private Button BtnNoter;

    @FXML
    private Button BtnVoir;

    @FXML
    private Label LBnom;

    @FXML
    private Label LBtel;

    @FXML
    void voirCandidat(ActionEvent event) {

    }

    public void setData(User candidat){
        LBnom.setText(candidat.getNomcandidat()+" "+candidat.getPrenomcandidat());
        LBtel.setText(candidat.getContacts());
    }

}
