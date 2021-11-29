package Phase_1.GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class WarningWindowController{

    @FXML
    Button yesButton;

    @FXML
    Button noButton;

    boolean yesButtonClicked;

    public void buttonClicked(MouseEvent mouseEvent){
        yesButtonClicked = mouseEvent.getSource().equals(yesButton);
        Stage stage = (Stage) yesButton.getScene().getWindow();
        stage.close();
    }

    public boolean getYesButtonClicked(){
        return yesButtonClicked;
    }


}
