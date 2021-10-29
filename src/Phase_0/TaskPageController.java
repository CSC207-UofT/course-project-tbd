package Phase_0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TaskPageController {
    private NormalUser user;
    private TaskPagePresenter tpp;
    private TaskManager itm;
    UserManager um;

    public TaskPageController(NormalUser user, UserManager um){
        this.user = user;
        this.tpp = new TaskPagePresenter();
        this.um = um;
        this.itm = new TaskManager();
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
        tpp.giveNewTaskDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        LocalDate taskDate = LocalDate.parse(reader.readLine(), formatter);
        Task task = new Task(taskTitle, taskDetail, taskDate); // task name must be unique
        um.addTask(user, task);
        tpp.taskAdd();
    }
}