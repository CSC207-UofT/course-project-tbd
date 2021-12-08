package Phase_1_ignore_this.Controllers_Gateways_Presenters;

import Phase_2.UseCaseClass.GroupManager;
import Phase_2.UseCaseClass.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This GroupChatController class is made for controlling the chat feature in a group
 * according to the user input. Enter 1 to display all the messages in the chat. Enter 2
 * to send a message to other members of the group
 */
public class GroupChatController {
    /**
     * The groupId is given beforehand from the previous controller
     */
    private final String groupId;
    /**
     * Use case for all operations we perform on Groups
     */
    private final GroupManager gm;
    /**
     * The userId is given beforehand from the previous controller
     */
    private final String userId;
    /**
     * The presenter that works with this controller to provide instructions
     * and output for the user of the program
     */
    private final GroupChatPresenter gcp = new GroupChatPresenter();
    /**
     * Use case for all operations on Users
     */
    private final UserManager um;


    /**
     * Constructs the Group chat page for a specified group
     * @param groupId an id of the Group given from the previous controller
     * @param userId an id of the user given from the previous controller
     * @param um an instance of UserManager
     * @param gm an instance of GroupManager
     */
    public GroupChatController(String groupId, String userId, UserManager um, GroupManager gm) {
        this.groupId = groupId;
        this.userId = userId;
        this.um = um;
        this.gm = gm;
    }

    /**
     * Starts the group chat feature of the particular group. Display all the messages in the chat
     * by typing 1. Send a new message to other members of the group by typing 2. Type 0 to go back to
     * the previous page.
     */
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
