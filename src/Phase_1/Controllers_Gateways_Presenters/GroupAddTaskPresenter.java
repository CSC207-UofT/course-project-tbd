package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;

public class GroupAddTaskPresenter {
    private final String groupId;
    private final UserManager um;
    private final GroupManager gm;
    private final String userId;
    private final String categoryName;

    public GroupAddTaskPresenter(String userId, UserManager um, GroupManager gm, String groupId, String categoryName) {
        this.userId = userId;
        this.um = um;
        this.gm = gm;
        this.groupId = groupId;
        this.categoryName = categoryName;
    }

    public void instructions() {
        if (gm.checkIfLeader(gm.getGroupById(groupId).getgroupName(), um.getUserById(userId))) {
            String s = "Type 1 to display all the assigned tasks for this member\n";
            s = s + "Type 2 to add a task for this member\n";
            s = s + "Type 0 to get back to the previous page";
            System.out.println(s);
        } else if (userId.equals(categoryName)) {
            String s = "Type 1 to display all the assigned tasks for you in this group\n";
            s = s + "Type 2 to finish a task\n";
            s = s + "Type 0 to get back to the previous page";
            System.out.println(s);
        } else {
            System.out.println("Type 1 to display all the assigned tasks for this member\n" +
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
    public void taskAdded(){
        System.out.println("The task you entered has been successfully added");
    }
    public void toComplete() {
        System.out.println("Please enter the name of a task you have completed ");
    }
    public void notValid() {
        System.out.println("The Task you entered is not valid");
    }
}