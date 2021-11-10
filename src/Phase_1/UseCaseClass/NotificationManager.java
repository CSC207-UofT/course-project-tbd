package Phase_1.UseCaseClass;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import Phase_1.Alarm.*;
import Phase_1.Controllers_Gateways_Presenters.NotificationPageController;
import Phase_1.Entity.TaskWithDueDate;

import javax.swing.*;

public class NotificationManager implements Runnable {

    public PriorityQueue<TaskWithDueDate> taskWithDueDates;
    private AlarmMenu alarmMenu;
    public void setAlarmMenu(AlarmMenu alarmMenu){
        this.alarmMenu = alarmMenu;
    }
    public ArrayList<String> mailbox = new ArrayList<>();

    public NotificationManager(){
        taskWithDueDates  = new PriorityQueue<>();
    }

    public boolean addTaskWithDueDate(TaskWithDueDate t){
        this.taskWithDueDates.add(t);
        return true;
    }

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
