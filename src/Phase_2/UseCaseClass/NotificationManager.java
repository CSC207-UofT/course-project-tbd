package Phase_2.UseCaseClass;

import java.time.format.DateTimeFormatter;
import java.util.*;

import Phase_2.Entity.Alarm;
import Phase_2.Entity.TaskWithDueDate;
import javafx.application.Platform;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This NotificationManager is the use case that is responsible for running the thread that
 * creates and starts the alarm. It includes a nested runnable class that is called when the alarm goes off.
 * It also adds a notification to the mailbox when the alarm goes off when the alarm goes off.
 *
 * @author  Owen Huang
 */
public class NotificationManager implements Runnable {

    /**
     * taskWithDueDates is a priority queue f TaskWithDueDates where each task is compared by its due date.
     * The sooner the due date the higher the priority.
     */
    public PriorityQueue<TaskWithDueDate> taskWithDueDates;

    /**
     * an instance of the AlarmMenu interface that creates alarm, starts the alarm, and cancels the alarm
     */
    private AlarmMenu alarmMenu;

    /**
     * mailboxTaskName is an array list of strings that keeps track off all the notifications' task names.
     */
    public ArrayList<String> mailboxTaskName = new ArrayList<>();

    /**
     * mailDetail is a hash map that maps a task name to its detail info
     */
    public HashMap<String, String> mailDetail = new HashMap<>();

    /**
     * Constructs the NotificationManager and initialize the priority queue taskWithDueDates
     */
    public NotificationManager(){
        taskWithDueDates  = new PriorityQueue<>();
    }

    /**
     * Set the AlarmMenu to a class that implements this interface, and has detail implementations of the
     * methods
     */
    public void setAlarmMenu(AlarmMenu alarmMenu){
        this.alarmMenu = alarmMenu;
    }

    /**
     * Add a TaskWithDueDate instance to the priority queue
     *
     * @param t is an instance of TaskWithDueDate
     */
    public void addTaskWithDueDate(TaskWithDueDate t){
        this.taskWithDueDates.add(t);
        runTask();
    }

    /**
     * Getter method for the mailbox array list
     *
     * @return mailbox, which is an array list of strings
     */
    public ArrayList<String> getMailboxTaskName(){
        return mailboxTaskName;
    }

    public HashMap<String, String> getMailDetail(){
        return mailDetail;
    }

    /**
     * A nested class that defines the action performed when the alarm clock goes off.
     * A pop-up window will be shown to the screen notifying to the user what task is due on what time
     */
    public class NotificationBox implements Runnable{

        /**
         * The task that is due and will be shown to the user
         */
        private final TaskWithDueDate task;

        /**
         * Constructor for NotificationBox that initializes the task
         *
         * @param task is the TaskWithDueDate that is due right now
         */
        NotificationBox(TaskWithDueDate task){
            this.task = task;
        }

        /**
         * Overrides the run method. This method will be run when the alarm goes off,
         * which constructs a pop-up window and display task information
         */
        @Override
        public void run(){
            // Adds notification to mailbox with the following format:
            // dd-MM-yyy HH:mm
            // DUE DATE ALERT!
            // Task: <Task Title>
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            String note = task.getDueDate().format(format) + "\nDUE DATE ALERT! \nTask: <" + task.getTaskName() + ">";
            //==================
            mailboxTaskName.add(0,task.getTaskName());
            mailDetail.put(task.getTaskName(), note);
            //==================

            new Thread(() -> Platform.runLater(() -> {

                Label secondLabel = new Label(note);
                secondLabel.setLayoutX(90);
                secondLabel.setLayoutY(50);
                Button button = new Button();
                button.setText("OK");
                button.setLayoutX(125);
                button.setLayoutY(150);

                button.setOnAction(event -> {
                    Stage stage = (Stage) button.getScene().getWindow();
                    stage.close();
                });

                Group root = new Group();
                root.getChildren().add(secondLabel);
                root.getChildren().add(button);

                Scene secondScene = new Scene(root, 275, 200);

                Stage newWindow = new Stage();
                newWindow.setResizable(false);
                newWindow.setTitle("ALERT!!!");
                newWindow.setScene(secondScene);

                newWindow.setX(250);
                newWindow.setY(150);


                newWindow.initModality(Modality.APPLICATION_MODAL);
                newWindow.showAndWait();

            })).start();

        }
    }

    /**
     * polls the task with the highest priority from queue (aka the task with the earliest due date)
     * and set up and start an alarm for this task
     */
    private void runTask(){
        if(!taskWithDueDates.isEmpty()){    // if there is a task in the queue
            TaskWithDueDate t =  this.taskWithDueDates.poll();      // dequeue
            Alarm alarm = this.alarmMenu.createAlarm(t.getDueDate());       // create the alarm using due date
            try {
                if (!t.getStatus()){        // if task is incomplete, start the alarm
                    // may catch unsupported operation exception if try to schedule alarm into the past
                    this.alarmMenu.startAlarm(alarm, new NotificationBox(t));
                } else {                    // task is mark complete, cancel the alarm
                    this.alarmMenu.cancelAlarm(alarm);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Signals the notification system is running when NotificationManager is started
     */
    @Override
    public void run() {
        System.out.println("...System Running...");
    }
}
