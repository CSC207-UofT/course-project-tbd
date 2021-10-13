package Phase_0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserPageController {
    User user;
    public final UserPagePresenter upp;
    public UserManager um;

    public UserPageController(UserManager um, User user){
        this.user = user;
        this.upp = new UserPagePresenter(user);
        this.um = um;
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        upp.userProfilePage();
        System.out.print("1, Sign out\n" +
                         "2. Exit\n" +
                         "Your answer here: ");
        String input = reader.readLine();
        if(input.equals("2")){
            System.exit(0);
        }

    }

}
