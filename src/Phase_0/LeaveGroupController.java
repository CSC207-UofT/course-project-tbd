package Phase_0;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class LeaveGroupController {
    User user;
    UserManager um;
    GroupManager gm;
    public LeaveGroupController(User user, UserManager um, GroupManager gm){
        this.user = user;
        this.um = um;
        this. gm =gm;
    }
    public void run(){
        LeaveGroupPresenter lgp = new LeaveGroupPresenter();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        lgp.askForName();
        try{
            String input = reader.readLine();
            if(!gm.checkGroupExists(input)){
                lgp.noGroupFound();
                lgp.goBack();
                lgp.lines();
            }
            else if (gm.checkIfIn(input, this.user)){
                if (gm.checkIfLeader(input, this.user)){
                    gm.deleteGroup(input, this.user);
                    lgp.leaveSuccess(input);
                    lgp.lines();
                }
                else {
                    gm.removeMember(input, this.user);
//                    um.leaveGroup(this.user, input);
                    lgp.leaveSuccess(input);
                    lgp.lines();
                }


            }
            else {
                lgp.noGroupFound();
                lgp.lines();
            }

        }
         catch (IOException e) {
            System.out.println("Something went wrong");
        }

    }
}
