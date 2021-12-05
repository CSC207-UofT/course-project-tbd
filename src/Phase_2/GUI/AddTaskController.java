package Phase_2.GUI;

import Phase_2.Entity.Category;
import Phase_2.Entity.Task;
import Phase_2.Entity.TaskWithDueDate;
import Phase_2.UseCaseClass.NotificationManager;
import Phase_2.UseCaseClass.TaskManager;
import Phase_2.UseCaseClass.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.time.DateTimeException;
import java.util.*;

public class AddTaskController implements Initializable {
    Task t;
    TaskManager tm;
    UserManager um;
    Category c;
    NotificationManager nm;

    Scene previousScene;

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
    @FXML
    TextField yes0rNo ;

    @FXML
    Hyperlink goback;

    public void setTm(TaskManager tm) {this.tm = tm;}
    public void setUm(UserManager um) {
        this.um = um;
    }
    public void setT(Task t) {
        this.t = t;
    }
    public void setC(Category c){this.c = c;}
    public void setNm(NotificationManager nm){
        this.nm = nm;
    }
    public void setPreviousScene(Scene scene){
        this.previousScene = scene;
    }

    public void addTask() throws IOException {
        GUImain guiMain = new GUImain();
        String name = title.getText();
        Success.setText("");
        String info = information.getText();
        String ans = yes0rNo.getText();
        String due = date.getText();
        Success.setText("");
        List<String> formattedDate = List.of(due.strip().split("/"));
        if (ans.equals("Yes")) {
            try {
                int year = Integer.parseInt(formattedDate.get(0));
                int month = Integer.parseInt(formattedDate.get(1));
                int day = Integer.parseInt(formattedDate.get(2));
                int hour = Integer.parseInt(formattedDate.get(3));
                int minute = Integer.parseInt(formattedDate.get(4));
                if(tm.getTaskByName(c, name) != null){
                    Success.setText("The task already exists, chose another task name");
                }
                else{
                    TaskWithDueDate task = tm.createTask(name, info, year, month, day, hour, minute);
                    nm.addTaskWithDueDate(task);    // add to notification manager for creating alarm for task
                    tm.addTaskToCategory(c, task);  // add task to user's task collection
                    Success.setText("Task Successfully Created");
                }
            } catch (UnsupportedOperationException e) {     // exception thrown when user schedules a date in the past
                System.out.println(e.getMessage());
            } catch (IndexOutOfBoundsException e2) {     // when the user's date input does not follow the format
                Success.setText("Please enter according to the format: \n" +
                        "Year/Month/Date/Hour/Minute");
            } catch (DateTimeException e3) {     // when the date user entered is an invalid date
                Success.setText("You have entered an invalid date");
            } catch (Exception e) {
                Success.setText("Invalid input");
            }
        }
        if(ans.equals("No")) {

            if(tm.getTaskByName(c, name) != null){
                Success.setText("The task already exists, chose another task name");
            }
            else{
                Task task = tm.createTask(name, info); // create a simple task without due date
                tm.addTaskToCategory(c, task);  // add task to category's task collection
                Success.setText("Task Successfully Created");
            }

        }
    }

    public void backPushed() throws IOException {
        Stage stage = (Stage) addTask.getScene().getWindow();
        stage.setScene(previousScene);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}