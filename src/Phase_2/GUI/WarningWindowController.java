package Phase_2.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class WarningWindowController{

    /**
     * The yes button in FXML
     */
    @FXML
    Button yesButton;

    /**
     * The no button in FXML
     */
    @FXML
    Button noButton;

    /**
     * A boolean to check which button is clicked
     */
    boolean yesButtonClicked;

    /**
     * When button is clicked, the warning window is closed and changes yesButtonClicked status accordingly
     */
    public void buttonClicked(MouseEvent mouseEvent){
        yesButtonClicked = mouseEvent.getSource().equals(yesButton);
        Stage stage = (Stage) yesButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Returns the status of the yesButtonClicked variable
     */
    public boolean getYesButtonClicked(){
        return yesButtonClicked;
    }


}
