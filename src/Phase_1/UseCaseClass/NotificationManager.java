package Phase_1.UseCaseClass;

import java.time.format.DateTimeFormatter;
import java.util.*;

import Phase_1.Entity.Alarm;
import Phase_1.Entity.TaskWithDueDate;
import javax.swing.*;

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
     * mailbox is an array list of strings that keeps track off all the notifications.
     */
    public ArrayList<String> mailboxTaskName = new ArrayList<>();
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
        public void run() {
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

            final JFrame alert = new JFrame();      // Frame
            JButton button = new JButton();         // button

            button.setText(note);           // button text
            alert.add(button);
            alert.pack();
            alert.setSize(500,500);     // size: 500 x 500
            alert.setVisible(true);

            button.addActionListener(evt -> alert.dispose());   // close window when button is pressed
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
