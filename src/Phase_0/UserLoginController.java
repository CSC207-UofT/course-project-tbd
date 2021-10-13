package Phase_0;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class UserLoginController {
    UserManager um;
    UserLoginController(UserManager um){ this.um = um;};
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
                    UserPageController upc = new UserPageController(um, um.getUserById(userId));
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