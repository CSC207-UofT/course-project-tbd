package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.Group;
import Phase_1.Entity.NormalUser;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class ViewGroupController {
    /**
     * This is a controller for viewing all the groups an user is inside and seeing contents inside a group
     */

    private UserManager um;
    private GroupManager gm;
    private String userId;
    // private final ViewGroupPresenter vgp= new ViewGroupPresenter;

    public ViewGroupController(UserManager um, GroupManager gm, String userId) {
        this.gm = gm;
        this.um = um;
        this.userId = userId;
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Group> groups;
        StringBuilder s = new StringBuilder();
        groups = um.getUserById(userId).getMyGroups();
        for (int i = 0; i < groups.size(); ++i) {
            // Creates a string showing all the groups the user has and options to click on them.
            s.append(i).append(" ").append(groups.get(i).getgroupName()).append("\n");
        }
        s.append("Enter x to go back");
        boolean flag = true;
        try {
            while (flag) {
                System.out.println(s); // Gets input from user
                String option = reader.readLine();
                if (Objects.equals(option, "x")) {
                    // If the user enters x, we terminate and go back to previous page.
                    flag = false;
                }
                else if(Integer.parseInt(option) >= groups.size()){
                    // If the user enters a number greater than the no of groups user is in, we ask user to
                    // enter again.
                    System.out.println("Sorry! The group does not exist. Enter again!");
                }
                else{
                    // We call the controller for the corresponding group.
                    int x = Integer.parseInt(option);
                    GroupContentController gcc = new GroupContentController(um, gm, groups.get(x),
                            userId);
                    gcc.run();

                }
                break;
            }
        } catch (IOException e) {
            System.out.println("Please type a valid number");
            }

    }

}