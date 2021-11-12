package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.TaskManager;
import Phase_1.UseCaseClass.UserGroupManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewGroupController {
    /**
     * This is a controller for viewing all the groups an user is inside and seeing contents inside a group
     */

    private final UserManager um;
    private final GroupManager gm;
    private final TaskManager tm;
    private final String userId;
    private final UserGroupManager ugm;
    // private final ViewGroupPresenter vgp= new ViewGroupPresenter;

    public ViewGroupController(UserManager um, GroupManager gm, TaskManager tm, String userId) {
        this.gm = gm;
        this.um = um;
        this.tm = tm;
        this.userId = userId;
        this.ugm = new UserGroupManager();
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> groups;
        StringBuilder s = new StringBuilder();
        groups = ugm.getMyGroups(um.getUserById(userId));
        HashMap<Integer, String> groupIdRecord = new HashMap<>();
        int num = 0;
        for (String groupId: ugm.getGroupIds(um.getUserById(userId))) {
            // Creates a string showing all the groups the user has and options to click on them.
            s.append("Group ID: ").append(groupId).append("    Sequence number:  ").append(num).append("\n");
            groupIdRecord.put(num, groupId);
            num++;
        }
        s.append("Enter the sequence number of the group you want to view \n" +
                "Enter x to go back");
        try {
            boolean flag = true;
            String option;
            while (flag) {
                System.out.println(s); // Gets input from user
                option = reader.readLine();
                if (option.equals("x")) {
                    // If the user enters x, we terminate and go back to previous page.
                    flag = false;
                }
                else if(Integer.parseInt(option) < groups.size()){
                    // If the user enters a number greater than the no of groups user is in, we ask user to
                    // enter again.
                    String groupId = groupIdRecord.get(Integer.parseInt(option));
                    GroupContentController gcc = new GroupContentController(um, gm, tm, groupId, userId);
                    gcc.run();
                }
                else {
                    // We call the controller for the corresponding group.
                    System.out.println("Sorry! The group does not exist. Enter again!");

                }
            }
        } catch (IOException e) {
            System.out.println("Please type a valid number");
            }

    }

}