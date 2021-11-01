package Phase_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupChatController {
    private Group group;
    private GroupManager gm;
    private NormalUser user;
    private final GroupChatPresenter gcp = new GroupChatPresenter();

    public GroupChatController(Group group, NormalUser user) {
        this.group = group;
        this.user = user;
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        gcp.instructions();
        try {
            String input = reader.readLine();

            while (!input.equals("0")) {
                if (input.equals("1")) {
                    System.out.println(group.getGroupChat().toString());
                } else if (input.equals("2")) {
                    gcp.askMessage();
                    String message = reader.readLine();
                    group.getGroupChat().insertMessage(user, message);
                }
            }
        } catch (IOException e){
            System.out.println("Please type a valid number");
        }
    }
}
