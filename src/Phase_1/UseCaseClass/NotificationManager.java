package Phase_1.UseCaseClass;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import Phase_1.Alarm.*;
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
    public ArrayList<String> mailbox = new ArrayList<>();

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
    }

    /**
     * turn off the alarm of the task
     */
    public void turnOffAlarmOfTask(TaskWithDueDate task){
        addTaskWithDueDate(task);
    }

    /**
     * Getter method for the mailbox array list
     *
     * @return mailbox, which is an array list of strings
     */
    public ArrayList<String> getMailbox(){
        return mailbox;
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
            mailbox.add(note);

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
     * Override the run method of runnable.
     * This block will always be running in the background, and once a TaskWithDueDate object has been added
     * to the queue. It will start the alarm if task status is incomplete,
     * and cancel the alarm if task status is complete
     */
    @Override
    public void run() {
        System.currentTimeMillis();
        while(true){        // Make sure it is always running in the background
            try {
                // thread will run every 500 ms to reduce traffic
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

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
    }
}
