package Phase_0;

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

    public void addTask(NormalUser user, Task task){
        user.addTask(task);
    }


    public String displayTask(NormalUser user){
        StringBuilder s = new StringBuilder();
        for(Task t: user.getMyTasks()){
            s.append(t.toString()).append("\n");
        }
        return s.toString();
    }
    public boolean checkTask(NormalUser user, Task t) {
        return user.getMyTasks().contains(t);
    }

    public Task getTaskByName(NormalUser user, String taskName) {
        for (Task t: user.getMyTasks()){
            if (this.checkTaskByName(t, taskName)){
                return t;
            }

        }
        return null;
    }
}


