package Phase_0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TaskPageController {
    private NormalUser user;
    private TaskPagePresenter tpp;
    private IndividualTaskManager itm;
    UserManager um;

    public TaskPageController(NormalUser user, UserManager um){
        this.user = user;
        this.tpp = new TaskPagePresenter(user);
        this.um = um;
    }
    public void run() throws IOException{
        tpp.availableOptions();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        um.displayTask(user);
        String input = reader.readLine();
        while (!input.equals("1")){
            if (input.equals("2")){
                tpp.giveNewTaskName();
                String taskTitle = reader.readLine();
                tpp.giveTaskDetail();
                String taskDetail = reader.readLine();
                Task task = new Task(taskTitle, taskDetail); // task name must be unique
                um.addTask(user, task);
                tpp.taskAdd();
                tpp.availableOptions();
            }else if(input.equals("3")){
                // To mark the task complete.
                tpp.enterTaskToComplete();
                String taskToComplete = reader.readLine();
                Task task = um.getTaskByName(user, taskToComplete);
                if(um.checkTask(user, task)){
                    // If task is present in user, mark it done
                    itm.completeTask(task);
                }
                else{
                    tpp.taskNotPresent();
                }

                break;



            }
        }}
}