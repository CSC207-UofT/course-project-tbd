package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.Category;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.TaskManager;
import Phase_1.UseCaseClass.UserManager;

public class ViewFoldersPresenter {
    private String groupId;
    private UserManager um;
    private TaskManager tm;
    private GroupManager gm;
    private String userId;

    public ViewFoldersPresenter(UserManager um, TaskManager tm, GroupManager gm, String userId, String groupId){
        this.groupId = groupId;
        this.userId = userId;
        this.um = um;
        this.gm = gm;
        this.tm = tm;
    }

    public void askInput(){
        StringBuilder s = new StringBuilder();
        int i = 0;
        for (Category c : gm.getGroupById(groupId).getCategories()) {
            s.append(i + " ").append(c.toString()).append("\n");
            i = i + 1;
        }
        s.append("Enter any other key to exit");
        System.out.println(s);
    }
}
