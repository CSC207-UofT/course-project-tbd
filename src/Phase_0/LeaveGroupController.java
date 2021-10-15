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
            if (gm.checkGroupName(input)){
                if (gm.checkIfLeader){
                    gm.deleteGroup(input);
                }
                else {
                    gm.removeMember(input, user);
                    um.leaveGroup(user, input);
                    lgp.leaveSuccess(input);
                }


            }
            else {
                lgp.noGroupFound();
            }

        }
         catch (IOException e) {
            System.out.println("Something went wrong");
        }

    }
}
