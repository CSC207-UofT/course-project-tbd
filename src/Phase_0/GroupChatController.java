package Phase_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupChatController {
    private GroupChat chat;
    private Group group;
    private GroupManager gm;
    private User user;
    private final GroupChatPresenter gcp = new GroupChatPresenter();

    public GroupChatController(GroupChat chat, Group group, GroupManager gm, User user) {
        this.chat = chat;
        this.group = group;
        this.gm = gm;
        this.user = user;
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        gcp.instructions();
        try {
            String input = reader.readLine();

            while (!input.equals("0")) {
                if (input.equals("1")) {
                    chat.toString();
                } else if (input.equals("2"))
                    gcp.askMessage();
                    String message = reader.readLine();
                    chat.insertMessage(user, message);
            }
        } catch (IOException e){
            System.out.println("Please type a valid number");
        }
    }
}
