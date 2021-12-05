package Phase_1.Controllers_Gateways_Presenters;

import Phase_2.UseCaseClass.UserManager;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class NewUserController {
    UserManager um;
    NewUserController(UserManager um){this.um = um;}
    public final NewUserPresenter nup = new NewUserPresenter();
    public void run(){BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        nup.Intro();
        try{
            String userId = reader.readLine();
            while (!um.checkIfValid(userId)) {
                nup.invalidUserName(userId);
                userId = reader.readLine();
            }
            nup.askPassword(userId);
            String password = reader.readLine();
            nup.askSQ();
            String sq = reader.readLine();
            nup.askSQAnswer();
            String sq_ans = reader.readLine();
            um.createNormalUser(userId, password, sq, sq_ans);
            nup.completed();
        } catch (IOException e){
            System.out.println("Please type a valid number");
        }
    }
}
