package Phase_1_ignore_this.Controllers_Gateways_Presenters;

import Phase_2.Entity.Category;
import Phase_2.UseCaseClass.GroupManager;

public class ViewFoldersPresenter {
    private final String groupId;
    private final GroupManager gm;

    public ViewFoldersPresenter(GroupManager gm, String groupId){
        this.groupId = groupId;
        this.gm = gm;
    }

    /**
     * Message prompting user for input
     */
    public void askInput(){
        StringBuilder s = new StringBuilder();
        int i = 0;
        for (Category c : gm.getGroupById(groupId).getCategories()) {
            s.append(i).append(" ").append(c.toString()).append("\n");
            i = i + 1;
        }
        s.append("Enter the number corresponding to the folder you want to access\n");
        s.append("Enter anything else to go back");
        System.out.println(s);
    }
}
