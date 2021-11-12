package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.TaskManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupContentController {

    /**
     * This class is the controller that gives access to all the content for a particular group.
     * UserManager um: The  usecase class for managing users.
     * GroupManager gm: The usecase class for managing groups.
     * TaskManager tm: The usecase class for managing tasks
     * String userId: The userId of the current user logged in.
     * String groupId: Represents the the id of the current group.
     * GroupContentPresenter gcp: The presenter class for displaying information.
     */
    private final UserManager um;
    private final GroupManager gm;
    private final TaskManager tm;
    private final String userId;
    private final String groupId;
    GroupContentPresenter gcp = new GroupContentPresenter();

    /**
     * This is a constructor method for the class that initializes
     * UserManager um: The  usecase class for managing users.
     * GroupManager gm: The usecase class for managing groups.
     * TaskManager tm: The usecase class for managing tasks
     * String userId: The userId of the current user logged in.
     * String groupId: Represents the the id of the current group.
     */
    public GroupContentController(UserManager um, GroupManager gm, TaskManager tm, String groupId, String userId) {
        this.um = um;
        this.gm = gm;
        this.tm = tm;
        this.userId = userId;
        this.groupId = groupId;
    }

    /**
     * Runs the method. Asks user which group related feature they want to access. This can be either the announcement
     * page, the group task page or the group chat. Pressing 4 or 0 allows you to return to the previous page or exit
     * the application respectively.
     */
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        gcp.instructions();
        try {
            String input = reader.readLine();
            while(!input.equals("4")) {
                switch (input) {
                    case "1":  {
                        AnnouncementPageController apc = new AnnouncementPageController(groupId, userId, um, gm);
                        apc.run();
                        gcp.instructions();
                        input = reader.readLine();
                        break;
                    }
                    case "2": {
                        ViewFoldersController vfc = new ViewFoldersController(um, tm, gm, userId, groupId);
                        vfc.run();
                        gcp.instructions();
                        input = reader.readLine();
                        break;
                    }
                    case "3": {
                        GroupChatController gcc = new GroupChatController(groupId, userId, um, gm);
                        gcc.run();
                        gcp.instructions();
                        input = reader.readLine();
                        break;
                    }
                    case "0": System.exit(0);
                }
            }
            } catch(IOException e){
                System.out.println("Please type a valid number");
            }
        }

    }

