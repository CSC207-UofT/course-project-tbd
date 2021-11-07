package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.Category;
import Phase_1.Entity.Folder;
import Phase_1.Entity.Group;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.TaskManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupContentController {

    private UserManager um;
    private GroupManager gm;
    private TaskManager tm;
    private String userId;
    private String groupId;
    private GroupContentPresenter gcp = new GroupContentPresenter();
    private GroupCategoryPresenter gcatp = new GroupCategoryPresenter();
    private GroupCategoryController gcc = new GroupCategoryController(um, gm, tm, userId, groupId, gcatp);

    public GroupContentController(UserManager um, GroupManager gm, TaskManager tm, String groupId, String userId) {
        this.gm = gm;
        this.um = um;
        this.tm = tm;
        this.groupId = groupId;
        this.userId = userId;
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        gcp.instructions();
        try {
            String input = reader.readLine();
            while(!input.equals("4")) {
                switch (input) {
                    case "1":
                        AnnouncementPageController apc = new AnnouncementPageController(groupId, userId, um, gm);
                        apc.run();
                        gcp.instructions();
                        input = reader.readLine();
                        break;
                    case "2": {
                        gcc.run();
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
                    break;
                }
            }
            } catch(IOException e){
                System.out.println("Please type a valid number");
            }
        }

    }

