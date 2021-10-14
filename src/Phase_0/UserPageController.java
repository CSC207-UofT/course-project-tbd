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

    public UserPageController(UserManager um, NormalUser user) {
        this.user = user;
        this.upp = new UserPagePresenter(user);
        this.um = um;
        this.tpp = new TaskPageController(user);
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        while (!Objects.equals(input, "2")) {
            upp.userProfilePage();
            upp.availableOptions();
            input = reader.readLine();

            if (input.equals("3")) {      // Exits Program
                System.exit(0);
            }
            if (input.equals("1")) {      // My Tasks
                tpp.run();
            }
        }

    }

}
