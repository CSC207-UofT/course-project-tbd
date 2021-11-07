package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.Group;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupChatController {
    private String groupId;
    private GroupManager gm;
    private String userId;
    private final GroupChatPresenter gcp = new GroupChatPresenter();
    private UserManager um;

    public GroupChatController(String groupId, String userId, UserManager um, GroupManager gm) {
        this.groupId = groupId;
        this.userId = userId;
        this.um = um;
        this.gm = gm;
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            boolean flag = true;
            String input;
            while (flag) {
                gcp.instructions();
                input = reader.readLine();
                if (input.equals("1")) {
                    System.out.println(gm.getGroupById(groupId).getGroupChat().toString());
                } else if (input.equals("2")) {
                    gcp.askMessage();
                    String message = reader.readLine();
                    gm.getGroupById(groupId).getGroupChat().insertMessage(um.getUserById(userId), message);
                } else {
                    flag = false;
                }
            }
        } catch (IOException e){
            System.out.println("Please type a valid number");
        }
    }
}
