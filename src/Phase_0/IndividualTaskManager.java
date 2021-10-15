package Phase_0;

public class IndividualTaskManager extends TaskManager{

    public void createTask(String description){
         new Task(description);
    }

    public void completeTask(Task task){
        task.status = true;
    }

    public boolean checkIfFinished(Task task){
        return task.status;
    }
}
