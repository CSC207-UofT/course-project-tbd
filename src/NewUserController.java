import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class NewUserController {
    public final NewUserPresenter nup = new NewUserPresenter();
    public void run(){BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        nup.Intro();
        UserManager um = new UserManager();
        try{
            String userId = reader.readLine();
            while (!um.checkIfValid(userId)) {
                nup.invalidUserName(userId);
                userId = reader.readLine();
            }
            nup.askPassword(userId);
            String password = reader.readLine();
            um.createNormalUser(userId, password);
        } catch (IOException e){
            System.out.println("Please type a valid number");
        }
    }
}