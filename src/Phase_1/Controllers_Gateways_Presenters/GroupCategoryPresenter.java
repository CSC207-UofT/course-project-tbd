package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.TaskManager;
import Phase_1.UseCaseClass.UserManager;

public class GroupCategoryPresenter {
    private String groupId;
    private UserManager um;
    private TaskManager tm;
    private GroupManager gm;
    private String userId;

    public GroupCategoryPresenter(String userId, UserManager um, GroupManager gm, String groupId){
        this.userId = userId;
        this.um = um;
        this.gm = gm;
        this.groupId = groupId;
    }

    public void instructions() {
        if (gm.checkIfLeader(gm.getGroupById(groupId).getgroupName(), um.getUserById(userId))) {
            System.out.println("Type 1 to display all the tasks in this group \n" +
                    "Type 2 to add a task for all members of the group " +
                    "Type 0 to get back to the previous page");
        } else {
            System.out.println("Type 1 to display all the tasks for you in this group \n" +
                    "Type 0 to get back to the previous page");
        }
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
