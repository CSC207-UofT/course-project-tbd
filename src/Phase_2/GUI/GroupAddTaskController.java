package Phase_2.GUI;

import Phase_2.Entity.Task;
import Phase_2.Entity.TaskWithDueDate;
import Phase_2.UseCaseClass.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.DateTimeException;
import java.util.List;

public class GroupAddTaskController {
    String userId;
    String groupId;
    String categoryName;
    UserManager um;
    TaskManager tm;
    GroupManager gm;
    NotificationManager nm;

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public void setUm(UserManager um) {
        this.um = um;
    }
    public void setTm(TaskManager tm) {
        this.tm = tm;
    }
    public void setGm(GroupManager gm) {
        this.gm = gm;
    }
    public void setNm(NotificationManager nm) {
        this.nm = nm;
    }

    @FXML
    Button cancel;

    @FXML
    Button done;

    @FXML
    TextField title;

    @FXML
    TextField detail;

    @FXML
    TextField time;

    @FXML
    TextField notification;

    @FXML
    Label added;

    public void backPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupTaskPresenter.fxml"));
        Parent root = loader.load();
        GroupTaskController gtc = loader.getController();
        gtc.setUserId(userId);
        gtc.setGroupId(groupId);
        gtc.setCategoryName(categoryName);
        gtc.setUm(um);
        gtc.setGm(gm);
        gtc.setTm(tm);
        gtc.setNm(nm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

    public void addTask() throws IOException {
        CategoryManager cm = new CategoryManager();
        String name = title.getText();
        String info = detail.getText();
        String answer = notification.getText();
        String due = time.getText();
        List<String> date = List.of(due.strip().split("/"));
        if (answer.equals("Yes")) {
            try {
                int year = Integer.parseInt(date.get(0));
                int month = Integer.parseInt(date.get(1));
                int day = Integer.parseInt(date.get(2));
                int hour = Integer.parseInt(date.get(3));
                int minute = Integer.parseInt(date.get(4));
                TaskWithDueDate task = tm.createTask(name, info, year, month, day, hour, minute);
                nm.addTaskWithDueDate(task);
                tm.addTaskToCategory(cm.getCategoryByGroup(categoryName, gm.getGroupById(groupId)), task);
                added.setText("Task has been added successfully");
            } catch (UnsupportedOperationException e) {     // exception thrown when user schedules a date in the past
                System.out.println(e.getMessage());
            } catch (IndexOutOfBoundsException e2) {     // when the user's date input does not follow the format
                added.setText("Please enter according to the format: \n" +
                        "Year/Month/Date/Hour/Minute");
            } catch (DateTimeException e3) {     // when the date user entered is an invalid date
                added.setText("You have entered an invalid date");
            } catch (Exception e) {
                added.setText("Invalid input");
            }
        }
        if (answer.equals("No")) {
            Task task = new Task(name, info);
            tm.addTaskToCategory(cm.getCategoryByGroup(categoryName, gm.getGroupById(groupId)), task);
            added.setText("Task has been added successfully");
        }
    }
}
