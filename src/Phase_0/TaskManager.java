package Phase_0;

public class TaskManager { //fixing sth

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
}


