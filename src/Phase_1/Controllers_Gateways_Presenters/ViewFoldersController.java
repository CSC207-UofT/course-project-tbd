package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.Category;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.TaskManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ViewFoldersController {
    private String groupId;
    private UserManager um;
    private TaskManager tm;
    private GroupManager gm;
    private String userId;
    private ViewFoldersPresenter vfp;

    public ViewFoldersController(UserManager um, TaskManager tm, GroupManager gm, String userId, String groupId){
        this.groupId = groupId;
        this.userId = userId;
        this.um = um;
        this.gm = gm;
        this.tm = tm;
        this.vfp = new ViewFoldersPresenter(um, tm, gm, userId, groupId);
    }

    /**
     * This method prints out all the folders inside the current group. And asks for an input to go view contents in
     * each folder
     */
    public void run(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            boolean flag = true;
            String input;
            vfp.askInput();
            input = reader.readLine();
            while(flag){
                if(Integer.parseInt(input) < gm.getGroupById(groupId).getCategories().size()){
                    String categoryName = gm.getGroupById(groupId).getCategories().get(Integer.parseInt(input)).toString();
                    GroupAddTaskController gatc = new GroupAddTaskController(userId, groupId, categoryName, um, tm, gm);
                    gatc.run();
                } else{
                    flag = false;
                }

            }
        }
        catch (Exception e) {
            System.out.println("error");
            System.out.println("Please type a valid number");
        }
    }

}
