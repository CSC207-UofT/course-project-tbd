package Phase_0;

import Alarm.AlarmStarter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class TaskPageController {
    private NormalUser user;
    private TaskPagePresenter tpp;
    private TaskManager itm;
    NotificationManager nm;
    UserManager um;

    public TaskPageController(NormalUser user, UserManager um){
        this.user = user;
        this.tpp = new TaskPagePresenter();
        this.um = um;
        this.itm = new TaskManager();

        this.nm = new NotificationManager();
        nm.setAlarmMenu(new AlarmStarter());
        Thread notificationSystem = new Thread(nm);
        notificationSystem.start();
    }

    public void run() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        tpp.displayTasks();
        String input = "";
        while (!input.equals("1")){
            tpp.availableOptions();
            input = reader.readLine();
            if (input.equals("2")){
                addTask(reader);
            }
            else if(input.equals("3")){
                // To mark the task complete.
                finishTask(reader);
            }
            else if(input.equals("4")){
                tpp.displayTasks();
                System.out.println(um.displayTask(user));
            }
        }
    }

    private void finishTask(BufferedReader reader) throws IOException {
        tpp.enterTaskToComplete();
        String taskToComplete = reader.readLine();
        Task task = um.getTaskByName(user, taskToComplete);
        if(um.checkTask(user, task)){
            // If task is present in user, mark it done
            itm.completeTask(task);
            System.out.println("Task finished");
        }
        else{
            tpp.taskNotPresent();
        }
    }

    private void addTask(BufferedReader reader) throws IOException {
        tpp.giveNewTaskName();
        String taskTitle = reader.readLine();
        tpp.giveTaskDetail();
        String taskDetail = reader.readLine();

        System.out.println("Do you want to set an alarm to notify you of this task? (y/n)");
        String yesOrNo = reader.readLine();

        // add task with a due date
        if (yesOrNo.equals("y")){
            System.out.println("When do you want to be notified (24-hour clock)? " +
                    "YYYY/MM/DD/hh/mm (ex. 2021/11/02/05/21)");
            String date = reader.readLine();
            List<String> formattedDate = List.of(date.strip().split("/"));
            int year = Integer.parseInt(formattedDate.get(0));
            int month = Integer.parseInt(formattedDate.get(1));
            int day = Integer.parseInt(formattedDate.get(2));
            int hour = Integer.parseInt(formattedDate.get(3));
            int minute = Integer.parseInt(formattedDate.get(4));

            TaskWithDueDate task = new TaskWithDueDate(taskTitle, taskDetail, year, month, day,hour, minute);
            nm.addTaskWithDueDate(task);
            um.addTask(user, task);
        }else{
            //add task without a due date
            Task task = new Task(taskTitle, taskDetail); // task name must be unique
            um.addTask(user, task);
        }
        tpp.taskAdd();

//        tpp.giveCategoryName();
//        String categoryTitle = reader.readLine();

//        Category c = new Category(categoryTitle);

//        um.addCategory(c);
    }
}