package Phase_0;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;
import Alarm.*;
import Phase_0.TaskWithDueDate;

import javax.swing.*;

public class NotificationManager implements Runnable {

    public PriorityQueue<TaskWithDueDate> taskWithDueDates;
    public NotificationPageController npc;
    private AlarmMenu alarmMenu;
    public void setAlarmMenu(AlarmMenu alarmMenu){
        this.alarmMenu = alarmMenu;
    }

    public NotificationManager(NotificationPageController npc){
        taskWithDueDates  = new PriorityQueue<>();
        this.npc = npc;
    }

    public boolean addTaskWithDueDate(TaskWithDueDate t){
        this.taskWithDueDates.add(t);
        return true;
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
            npc.addNotification(note);

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
                    this.alarmMenu.startAlarm(alarm, new NotificationBox(t));
                } catch (Exception e) {
                    e.printStackTrace();
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
