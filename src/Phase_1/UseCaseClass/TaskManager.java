package Phase_1.UseCaseClass;

import Phase_1.Entity.User;
import Phase_1.Entity.Task;

public class TaskManager {
    public void createTask(String description){
        new Task(description);
    }

    public void completeTask(Task task){
        task.setStatus(true);
    }

    public boolean checkIfFinished(Task task){
        return task.status;
    }

    public boolean checkTaskByName(Task task, String taskName){
        return task.getTaskName().equals(taskName);
    }

    public void checkTaskUnique(Task task){
    }

    public void addTask(User user, Task task){
        user.addTask(task);
    }


    public String displayTask(User user){
        StringBuilder s = new StringBuilder();
        for(Task t: user.getMyTasks()){
            s.append(t.toString()).append("\n");
        }
        return s.toString();
    }
    public boolean checkTask(User user, Task t) {
        return user.getMyTasks().contains(t);
    }

    public Task getTaskByName(User user, String taskName) {
        for (Task t: user.getMyTasks()){
            if (this.checkTaskByName(t, taskName)){
                return t;
            }

        }
        return null;
    }
}


