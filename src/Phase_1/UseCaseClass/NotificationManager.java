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
     * @return true if task is added successfully, false otherwise
     */
    public boolean addTaskWithDueDate(TaskWithDueDate t){
        this.taskWithDueDates.add(t);
        return true;
    }

    /**
     * an instance of the AlarmMenu interface that creates alarm, starts the alarm, and cancels the alarm
     */
    public boolean turnOffAlarmOfTask(TaskWithDueDate task){
        return addTaskWithDueDate(task);
    }

    public ArrayList<String> getMailbox(){
        return mailbox;
    }

    public class NotificationBox implements Runnable{

        private TaskWithDueDate task;

        NotificationBox(TaskWithDueDate task){
            this.task = task;
        }

        @Override
        public void run() {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            String note = task.getDueDate().format(format) + "\nDUE DATE ALERT! \nTask: <" + task.getTaskName() + ">";
            mailbox.add(note);

            final JFrame alert = new JFrame();
            JButton button = new JButton();

            button.setText("OK! I GET IT! SHUT UP!");
            alert.add(button);
            alert.pack();
            alert.setSize(500,500);
            alert.setVisible(true);

            button.addActionListener(evt -> alert.dispose());
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!taskWithDueDates.isEmpty()){
                TaskWithDueDate t =  this.taskWithDueDates.poll();
                Alarm alarm = this.alarmMenu.createAlarm(t.getDueDate());
                try {
                    if (!t.getStatus()){        // if task is incomplete, start the alarm
                        this.alarmMenu.startAlarm(alarm, new NotificationBox(t));
                    } else {                    // task is mark complete, cancel the alarm
                        this.alarmMenu.cancelAlarm(alarm);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        /*for(int i = 0; i < 100; i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
