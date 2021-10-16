package Phase_0;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
public class GroupPageController {
    UserManager um;
    NormalUser user;
    GroupManager gm;
    public GroupPageController(NormalUser user, UserManager um, GroupManager gm){
        this.um = um;
        this.user = user;
        this.gm = gm;
    }
    public void run(){
        GroupPagePresenter gpp = new GroupPagePresenter();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            gpp.welcomeLine();
            String input = reader.readLine();
            while (!input.equals( "3")){
                if (input.equals("0")){

                    break;
                }
                else if (input.equals("1")){
                    JoinGroupController jgc = new JoinGroupController(um, gm, user);
                    jgc.run();
                }
                else if (input.equals("2")){
                    LeaveGroupController lgc = new LeaveGroupController(user, um, gm);
                    lgc.run();
                }
                else {
                    gpp.welcomeLine();
                    input = reader.readLine();
                }

            }
        }
        catch (IOException e){System.out.println("Please type a valid number");
    }
}}
