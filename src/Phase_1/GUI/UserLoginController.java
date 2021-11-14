package Phase_1.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;

public class UserLoginController {

    public UserLoginController(){}

    @FXML
    private Button login_button;
    @FXML
    private Label WrongLogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();

    }

    private void checkLogin() throws IOException {
        GUImain m = new GUImain();
        if(username.getText().toString().equals("javacoding") && password.getText().toString().equals("123")) {
            WrongLogin.setText("Success!");

            m.changeScene("afterLogin.fxml");
        }

        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            WrongLogin.setText("Please enter your data.");
        }


        else {
            WrongLogin.setText("Wrong username or password!");
        }
    }
}
