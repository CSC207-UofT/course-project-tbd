package Phase_1.GUI;

import Phase_1.Entity.Task;
import Phase_1.UseCaseClass.TaskManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class AddTaskController implements Initializable {
    Task t;
    TaskManager tm;

    @FXML
    TextField title;
    @FXML
    TextField information;
    @FXML
    TextField date;
    @FXML
    Button addTask;
    @FXML
    Label Success;

    public void setTm(TaskManager tm) {this.tm = tm;}

    public void setT(Task t) {
        this.t = t;
    }

    public void addTask() throws IOException {
        GUImain guiMain = new GUImain();
        String name = title.getText();
        String info = information.getText();
        int due = Integer.parseInt(date.getText());

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
