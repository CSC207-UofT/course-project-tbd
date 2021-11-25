package Phase_1.Controllers_Gateways_Presenters;

/**
 * Presenter class for class GroupContent
 */
public class GroupContentPresenter {

    /**
     * Instructions to naviage GroupContent page
     */
    public void instructions() {
        String s = "Type 1 to go to the homepage\nType 2 to go to the Group Task Page\nType 3 to access the";
        s = s +  " Group Chat\nType 4 to go back\nType 0 to exit";
        System.out.println(s);
    }
}
