import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException {
        UserManager um = new UserManager();
        MainPageController mp = new MainPageController(um);
        mp.run();

    }
}
