package Phase_1.UseCaseClass;

import Phase_1.Entity.Category;
import Phase_1.Entity.User;
import Phase_1.Entity.Task;

public class TaskManager {

    public void completeTask(Task task){
        task.setStatus(true);
    }

    public boolean checkIfFinished(Task task){
        return task.getStatus();
    }

    public boolean checkTaskByName(Task task, String taskName){
        return task.getTaskName().equals(taskName);
    }

    public void addTaskToCategory(Category category, Task task){
        category.addTask(task);
    }

    public String displayTask(Category category){
        StringBuilder s = new StringBuilder();
        for(Task t: category.getTasks()){
            s.append(t.toString()).append("\n");
        }
        return s.toString();
    }

    public boolean checkTask(Category category, Task t) {
        return category.tasks.contains(t);
    }

    public Task getTaskByName(Category category, String taskName) {
        for (Task t: category.tasks){
            if (this.checkTaskByName(t, taskName)){
                return t;
            }

        }
        return null;
    }
}


