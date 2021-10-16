package Phase_0;

public class TaskPagePresenter {
    private NormalUser user;

    public TaskPagePresenter(NormalUser user){
        this.user = user;
    }


    public void availableOptions(){
        System.out.println("--------------------");
        System.out.print("Your options:\n" +
                "1, Back\n" +
                "2. Add Tasks:\n" +       // Can Create a Task which can either take in a String for Title, or with an optional Category parameter
                "3. finish Task\n" +
                "Your answer here: ");
    }
    public void giveNewTaskName(){
        System.out.println("--------------------");
        System.out.print("Enter Task Title:\n");
    }

    public void giveTaskDetail(){
        System.out.println("--------------------");
        System.out.println("Enter Task Detail:");
    }

    public void taskAdd(){
        System.out.println("Your task has been created and added");
    }

    public void enterTaskToComplete(){
        System.out.println("Enter name of task to complete");
    }

    public void taskNotPresent(){
        System.out.println("Sorry, the task is not there in our database");
    }
}