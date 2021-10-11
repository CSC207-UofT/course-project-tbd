import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class MainPageController {
    private final MainPagePresenter mpp = new MainPagePresenter();
    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        mpp.mainPageInstruction();
        mpp.decisionAsk();
        try{
        String input = reader.readLine();
        while (!input.equals("2")){
            if (input.equals("0")){
                UserLoginController ulc = new UserLoginController();
                ulc.run();
            }
            else if (input.equals("1")){
                NewUserController nuc = new NewUserController();
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

