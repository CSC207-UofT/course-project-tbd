package Phase_0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Objects;

public class UserPageController {
    private NormalUser user;
    private final UserPagePresenter upp;
    private UserManager um;
    private TaskPageController tpp;
    private GroupPageController gpc;

    public UserPageController(UserManager um, NormalUser user, GroupManager gm) {
        this.user = user;
        this.upp = new UserPagePresenter(user);
        this.um = um;
        this.tpp = new TaskPageController(user);
        this.gpc = new GroupPageController(user, um, gm);
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
            if (input.equals("2")) {      // My Tasks
                tpp.run();
            }
        }

    }

}
