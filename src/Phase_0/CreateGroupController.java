package Phase_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateGroupController {
    NormalUser normalUser;
    UserManager userManager;
    public CreateGroupController(NormalUser normalUser, UserManager userManager){
        this.normalUser = normalUser;
        this.userManager = userManager;
    }

    public void run(){
        GroupPagePresenter gpp = new GroupPagePresenter();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        }
}
