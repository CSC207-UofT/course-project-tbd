package Phase_1_ignore_this.Controllers_Gateways_Presenters;

import Phase_2.UseCaseClass.GroupManager;
import Phase_2.UseCaseClass.UserManager;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;


public class MainPageController {
    UserManager um;
    GroupManager gm;
    MainPageController(UserManager um, GroupManager gm){
        this.um = um;
        this.gm = gm;}
    private final MainPagePresenter mpp = new MainPagePresenter();
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        mpp.mainPageInstruction();
        mpp.decisionAsk();
        try{
        String input = reader.readLine();
        while (!input.equals("2")){
            if (input.equals("0")){
                UserLoginController ulc = new UserLoginController(um, gm);
                ulc.run();
            }
            else if (input.equals("1")){
                NewUserController nuc = new NewUserController(um);
                nuc.run();
            }
            else {
                System.out.println("Invalid input!");
            }
            mpp.mainPageInstruction();
            mpp.decisionAsk();
            input = reader.readLine();
        }
        } catch (IOException e){
            System.out.println("Please type a valid number");
        }

        }
    }

