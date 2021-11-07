package Phase_1.Controllers_Gateways_Presenters;

public class GroupCategoryPresenter {
    public void ifLeader() {
        System.out.println("Type 1 to display all the tasks in this group \n" +
                "Type 2 to add a task for all members of the group " +
                "Type 0 to get back to the previous page");
    }
    public void giveTaskName() {
        System.out.println("--------------------");
        System.out.println("Enter Task Title:\n");
    }
    public void giveTaskDetail() {
        System.out.println("--------------------");
        System.out.println("Enter Task Detail:");
    }
    public void addTask() {
        System.out.println("Your task has been successful added for all group members");
    }
    public void ifUser() {
        System.out.println("Type 1 to display all the tasks for you in this group \n" +
                "Type 0 to get back to the previous page");
    }
}
