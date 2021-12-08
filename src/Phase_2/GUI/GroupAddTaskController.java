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

/**
 * This GroupAddTaskController class is made for the current user to add a task for the chosen
 * folder (Assuming that the current user is the leader of the group)
 */

public class GroupAddTaskController {
    /**
     * The userId is given beforehand from the previous controller
     */
    String userId;
    /**
     * The groupId is given beforehand from the previous controller
     */
    String groupId;
    /**
     * The categoryName is given beforehand from the previous controller
     */
    String categoryName;
    /**
     * Use case for all operations we perform on Users
     */
    UserManager um;
    /**
     * Use case for all operations we perform on Tasks
     */
    TaskManager tm;
    /**
     * Use case for all operations on Groups
     */
    GroupManager gm;
    /**
     * Used to start alarm for task with a due date, and send notification to
     * user's notification center
     */
    NotificationManager nm;

    /**
     * Setter for userId
     * @param userId the name of the user who is accessing this controller
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Setter for groupId
     * @param groupId the name of the group this user is in
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * Setter for categoryName
     * @param categoryName the name of the folder which the user is accessing
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Setter for um
     * @param um use case for all operations on Users
     */
    public void setUm(UserManager um) {
        this.um = um;
    }

    /**
     * Setter for tm
     * @param tm use case for all operations on Tasks
     */
    public void setTm(TaskManager tm) {
        this.tm = tm;
    }

    /**
     * Setter for gm
     * @param gm use case for all operations on Groups
     */
    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    /**
     * Setter for nm
     * @param nm used to start alarms for task with a due date, and send notification
     *           to user's notification center
     */
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

    /**
     * This method allows user to go back to the previous controller (GroupTaskController)
     * @throws IOException any exception that could occur when running this method
     */
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
        gtc.checkLeader.setText("");    // reset the label
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

    /**
     * This method allows user to add a task for the owner of this folder (Assuming that the user
     * is the leader of this group). Otherwise, set the label to tell the current user that this
     * task cannot be performed
     * @throws IOException any exception could occur when running this method
     */
    public void addTask() throws IOException {
        CategoryManager cm = new CategoryManager();
        String name = title.getText();
        String info = detail.getText();
        String answer = notification.getText();
        String due = time.getText();
        List<String> date = List.of(due.strip().split("/"));
        if (answer.equals("Yes")) {     // handles the case where the user wants to add a task with due date
            try {
                // set up the due date
                int year = Integer.parseInt(date.get(0));
                int month = Integer.parseInt(date.get(1));
                int day = Integer.parseInt(date.get(2));
                int hour = Integer.parseInt(date.get(3));
                int minute = Integer.parseInt(date.get(4));
                if(tm.getTaskByName(cm.getCategoryByGroup(categoryName, gm.getGroupById(groupId)), name) != null){
                    added.setText("The task already exists, chose another task name");
                }
                else {
                    TaskWithDueDate task = tm.createTask(name, info, year, month, day, hour, minute);
                    nm.addTaskWithDueDate(task);
                    tm.addTaskToCategory(cm.getCategoryByGroup(categoryName, gm.getGroupById(groupId)), task);
                    added.setText("Task has been added successfully");
                }
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
        if (answer.equals("No")) {      // handles the case where user wants to add a task without due date
            if(tm.getTaskByName(cm.getCategoryByGroup(categoryName, gm.getGroupById(groupId)), name) != null){
                added.setText("The task already exists, chose another task name");
            }
            else {
                Task task = new Task(name, info);
                tm.addTaskToCategory(cm.getCategoryByGroup(categoryName, gm.getGroupById(groupId)), task);
                added.setText("Task has been added successfully");
            }
        }
    }
}
