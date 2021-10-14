package Phase_0;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UserManager um = new UserManager();
        GroupManager gm = new GroupManager();
        MainPageController mp = new MainPageController(um, gm);
        mp.run();

    }
}