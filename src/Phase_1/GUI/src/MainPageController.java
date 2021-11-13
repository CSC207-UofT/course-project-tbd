package Phase_1.GUI.src;

import Phase_1.GUI.src.GUImain;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.IOException;


public class MainPageController {
    UserManager um;
    GroupManager gm;
    String h;

    public MainPageController(){
    }

    public void setGm(GroupManager gm) {
        this.gm = gm;
    }
    public void setUm(UserManager um) {
        this.um = um;
    }

    public void display() throws IOException {
        GUImain m = new GUImain();
        m.changeScene("MainPage.fxml");
    }
}
