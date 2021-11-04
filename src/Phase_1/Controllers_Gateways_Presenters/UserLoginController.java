package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.NormalUser;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class UserLoginController {
    UserManager um;
    GroupManager gm;
    UserLoginController(UserManager um, GroupManager gm){
        this.um = um;
        this.gm = gm;};
    public final UserLoginPresenter nlp = new UserLoginPresenter();
    public void run(){BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        nlp.welcomePage();
        try{
            nlp.typeUserId();
            String userId = reader.readLine();
            nlp.typePassword();
            String password = reader.readLine();
            boolean stop = false;
            while (!stop) {
                if (um.login(userId, password)){
                    nlp.success(userId);
                    UserPageController upc = new UserPageController(um, userId ,gm);
                    System.out.println("he");
                    upc.run();
                    break;
                }
                else
                {nlp.fail();
                    nlp.again();
                    String s = reader.readLine();
                    if (!s.equals("0")){
                        stop = true;
                    }
                    else {
                        nlp.typeUserId();
                        userId = reader.readLine();
                        nlp.typePassword();
                        password = reader.readLine();
                    }
                }

            }} catch (IOException e){
            System.out.println("Please type a valid number");
        }

    }}