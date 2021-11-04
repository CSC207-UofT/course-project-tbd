package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.NormalUser;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Objects;

public class UserPageController {
    private NormalUser user;
    private final UserPagePresenter upp;
    private UserManager um;
    private TaskPageController tpc;
    private GroupPageController gpc;
    private CategoryPageController cpc;
    private NotificationPageController npc;

    public UserPageController(UserManager um, NormalUser user, GroupManager gm) {
        this.user = user;
        this.upp = new UserPagePresenter(user);
        this.um = um;
        this.tpc = new TaskPageController(user, um, npc);
        this.gpc = new GroupPageController(user, um, gm);
        this.cpc = new CategoryPageController(user, um);
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        while (!Objects.equals(input, "3")) {
            upp.userProfilePage();
            upp.availableOptions();
            input = reader.readLine();

            if (input.equals("1")) {      // My Group
                gpc.run();
            }
            if (input.equals("2")) {      // My Category
                cpc.run();
            }
        }

    }

}
