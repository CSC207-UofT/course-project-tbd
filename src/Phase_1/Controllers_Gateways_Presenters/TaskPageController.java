package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Alarm.AlarmStarter;
import Phase_1.Entity.NormalUser;
import Phase_1.Entity.Task;
import Phase_1.Entity.TaskWithDueDate;
import Phase_1.UseCaseClass.NotificationManager;
import Phase_1.UseCaseClass.TaskManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;

public class TaskPageController {
    private String userId;
    private TaskPagePresenter tpp;
    private TaskManager itm;
    NotificationManager nm;
    UserManager um;
    private CategoryPageController cpc;

    public TaskPageController(String userId, UserManager um, NotificationManager nm){
        this.userId = userId;
        this.tpp = new TaskPagePresenter();
        this.um = um;
        this.itm = new TaskManager();
        this.nm = nm;
    }

    public void run() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        tpp.displayTasks();
        String input = "";
        while (!input.equals("1")){
            tpp.availableOptions();
            input = reader.readLine();
            // To mark the task complete.
            if ("2".equals(input)) {
                addTask(reader);
            } else if ("3".equals(input)) {
                finishTask(reader);
            } else if ("4".equals(input)) {
                tpp.displayTasks();
                System.out.println(itm.displayTask(um.getUserById(userId)));
            }
        }
    }

    private void finishTask(BufferedReader reader) throws IOException {
        tpp.enterTaskToComplete();
        String taskToComplete = reader.readLine();
        Task task = itm.getTaskByName(um.getUserById(userId), taskToComplete);
        if(itm.checkTask(um.getUserById(userId), task)){
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
            itm.addTask(um.getUserById(userId), task);
        }else{
            //add task without a due date
            Task task = new Task(taskTitle, taskDetail); // task name must be unique
            itm.addTask(um.getUserById(userId), task);
        }
        tpp.taskAdd();
    }
}