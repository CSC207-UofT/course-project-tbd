package Phase_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class GroupContentController {

    private UserManager um;
    private GroupManager gm;
    private Group group;
    private User user;
    private GroupContentPresenter gcp = new GroupContentPresenter();

    public GroupContentController(UserManager um, GroupManager gm, Group group) {
        this.gm = gm;
        this.um = um;
        this.group = group
    }

    public void run() {
        groups = user.getMyGroups();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        gcp.instructions();
        try {
            String input = reader.readLine();

            while (!input.equals("0")) {
                switch (input) {
                    case "1":
                        // TODO Access to Home Page
                        System.out.println("HomePage class");
                        break;
                    case "2":
                        // TODO Access to Task Page
                        break;
                    case "3":
                        GroupChatController gcc = new GroupChatController(group.getGroupChat(), gm, user);
                        gcc.run();
                        break;
                    case "4":
                        ViewGroupController vgc = new ViewGroupController(this.um, this.gm);
                        vgc.run();
                        break;
                }
            }

            } catch(IOException e){
                System.out.println("Please type a valid number");
            }
        }
    }

