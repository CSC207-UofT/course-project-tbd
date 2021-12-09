package Phase_2.GUI;

import Phase_2.Entity.NormalUser;
import Phase_2.GUImain;
import Phase_2.UseCaseClass.GroupManager;
import Phase_2.UseCaseClass.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;


public class ResetPasswordController{
    GroupManager gm;
    UserManager um;
    String userId;

    @FXML
    Label SecurityQues;
    @FXML
    TextField SecurityAnswer;
    @FXML
    Label SuccessReset;
    @FXML
    Label WrongSA;
    @FXML
    Button ResetButton;
    @FXML
    PasswordField NewPassword;

    /**
     * Setter methods
     */
    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    public void setUm(UserManager um) {
        this.um = um;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Resets the security answers and questions
     */
    public void ResetButtonPushed() {
        SuccessReset.setText("");
        WrongSA.setText("");

        if (SecurityAnswer.getText().isEmpty() && NewPassword.getText().isEmpty()){
            SuccessReset.setText("Answer or password empty. Try Again!");
        } else if (((NormalUser) um.getUserById(userId)).getSQ_Ans().equals(SecurityAnswer.getText())){
            ((NormalUser) um.getUserById(userId)).setPassword(NewPassword.getText());
            SuccessReset.setText("Password has been reset successfully!");
        } else {
            WrongSA.setText("Security Answer incorrect. Try again or return to login page.");
        }
    }

    /**
     * Go back to the previous page
     */
    public void backPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/UserLogin.fxml"));
        Parent root = loader.load();
        UserLoginController upc = loader.getController();
        upc.setUm(um);
        upc.setGm(gm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }


}
