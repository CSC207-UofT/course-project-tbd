package Phase_0;

public class TaskManager {

    /**
     * Creates a new task with the input description
     */
    public void createTask(String description){
        new Task(description);
    }

    /**
     * Sets the task status as complete
     */
    public void completeTask(Task task){
        task.setStatus(true);
    }

    /**
     * Returns true if task is completed, false otherwise
     */
    public boolean checkIfFinished(Task task){
        return task.status;
    }

    /**
     * Returns true if taskName is the name of the task
     */
    public boolean checkTaskByName(Task task, String taskName){
        return task.getTaskName().equals(taskName);
    }
}
