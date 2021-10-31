package Phase_0;


import java.util.PriorityQueue;
import Alarm.*;
import Phase_0.TaskWithDueDate;

import javax.swing.*;

public class NotificationManager implements Runnable {

    public PriorityQueue<TaskWithDueDate> taskWithDueDates;
    private AlarmMenu alarmMenu;
    public void setAlarmMenu(AlarmMenu alarmMenu){
        this.alarmMenu = alarmMenu;
    }

    public NotificationManager(){
        taskWithDueDates  = new PriorityQueue<>();
    }

    public boolean addTaskWithDueDate(TaskWithDueDate t){
        this.taskWithDueDates.add(t);
        return true;
    }

    public class NotificationBox implements Runnable{

        @Override
        public void run() {
            final JFrame alert = new JFrame();
            JButton button = new JButton();

            button.setText("OK! I GET IT! SHUT UP!");
            alert.add(button);
            alert.pack();
            alert.setSize(500,500);
            alert.setVisible(true);

            button.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    alert.dispose();
                }
            });
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
                    this.alarmMenu.startAlarm(alarm, new NotificationBox());
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
