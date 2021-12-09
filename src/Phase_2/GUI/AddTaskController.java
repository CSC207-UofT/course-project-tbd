package Phase_2.GUI;

import Phase_2.Entity.Category;
import Phase_2.Entity.Task;
import Phase_2.Entity.TaskWithDueDate;
import Phase_2.UseCaseClass.NotificationManager;
import Phase_2.UseCaseClass.TaskManager;
import Phase_2.UseCaseClass.UserManager;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.*;

/**
 * This is the controller for the Add Task Page fxml. There the user can add tasks to their data, and they can create
 * 2 types of tasks: a normal task with a title and its information, and a task with due date which will include
 * an additional input field that prompt the user to input when they would like to be notified and an alarm will be
 * set up to remind them on the date.
 *
 * @author  Owen Huang
 * @author  Sanjana Girish
 */
public class AddTaskController{
    /**
     * A task object that user wants to add
     */
    Task t;

    /**
     * Use case for all operations we are performing on Tasks (e.g. add task, delete task)
     */
    TaskManager tm;

    /**
     * Responsible for managing, changing and accessing user information
     */
    UserManager um;

    /**
     * Category is responsible for storing all the tasks
     */
    Category c;

    /**
     * Used to start alarm for task with a due date, and send notification to user mailbox
     */
    NotificationManager nm;

    /**
     * This remembers the previous scene before ViewNFinishTask Page FXML, which should be the task page
     */
    Scene previousScene;

    /**
     * The text area where user inputs name of task
     */
    @FXML
    TextField title;

    /**
     * The text field where user inputs the task detail
     */
    @FXML
    TextField information;

    /**
     * the text field for inputting date info
     */
    @FXML
    TextField date;

    /**
     * button to add task
     */
    @FXML
    Button addTask;

    /**
     * A label to indicate whether task is being created or not
     */
    @FXML
    Label Success;

    /**
     * text field to indicate whether user want it to be a task with due date
     */
    @FXML
    TextField yes0rNo ;

    /**
     * click to go back to the previous page
     */
    @FXML
    Hyperlink goBack;

    /**
     * This is a setter method for the task manager.
     * @param tm: Task Manager
     */
    public void setTm(TaskManager tm) {this.tm = tm;}

    /**
     * This is a setter method for the user manager.
     * @param um: User Manager
     */
    public void setUm(UserManager um) {this.um = um;}

    /**
     * This is a setter method for Task.
     * @param t: Task
     */
    public void setT(Task t) {this.t = t;}

    /**
     * This is a setter method for Category.
     * @param c: Category
     */
    public void setC(Category c){this.c = c;}

    /**
     * This is a setter method for Notification manager.
     * @param nm: Notification manager.
     */
    public void setNm(NotificationManager nm){this.nm = nm;}

    /**
     * This is a setter method for Scene
     * @param scene: Scene
     */
    public void setPreviousScene(Scene scene){this.previousScene = scene;}

    /**
     * This method used to add task in the category when the button is pressed.
     * We can create with due date or without due date.
     */
    public void addTask() throws IOException {
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
                    tm.addTaskToCategory(c, task);  // add task to user's task collection
                    nm.addTaskWithDueDate(task);    // add to notification manager for creating alarm for task
                    Success.setText("Task Successfully Created");
                }
            } catch (UnsupportedOperationException e) {     // exception thrown when user schedules a date in the past
                Success.setText("WARNING! \n\n\nThe date is in the past, task is added without alarm.");
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

    /**
     * Goes back to the previous page when the back button is pressed on our gui.
     */
    public void backPushed() throws IOException {
        Stage stage = (Stage) addTask.getScene().getWindow();
        stage.setScene(previousScene);
    }
}