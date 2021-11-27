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
    TextField month;
    @FXML
    TextField year;
    @FXML
    TextField minute;
    @FXML
    TextField hour;
    @FXML
    Button addTask;
    @FXML
    Label Success;
    @FXML
    Hyperlink goback;

    public void setTm(TaskManager tm) {this.tm = tm;}

    public void setT(Task t) {
        this.t = t;
    }

    public void addTask() throws IOException {
        GUImain guiMain = new GUImain();
        String name = title.getText();
        Success.setText("");
        String info = information.getText();
//        int d = Integer.parseInt(date.getText());
//        int mon = Integer.parseInt(month.getText());
//        int y = Integer.parseInt(year.getText());
//        int h = Integer.parseInt(hour.getText());
//        int min = Integer.parseInt(minute.getText());
        tm.createTask(name, info);
        Success.setText("Task Successfully Created");

    }

    public void backPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TaskPageController.fxml"));
        Parent root = loader.load();
        TaskPageController tpc = loader.getController();
        tpc.setTm(tm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
