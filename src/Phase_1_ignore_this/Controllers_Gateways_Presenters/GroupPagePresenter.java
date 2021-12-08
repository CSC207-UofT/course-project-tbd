package Phase_1_ignore_this.Controllers_Gateways_Presenters;

/**
 * GroupPage presenter for class GroupPage
 */
public class GroupPagePresenter {

    /**
     * Instructions to let user know how to navigate through this page
     */
    public void welcomeLine(){
        System.out.println("Hello, there \n" +
                "Type 0 create a group \n" +
                "Type 1 join a group \n" +
                "Type 2 leave a group \n" +
                "Type 3 to view all the groups \n" +
                "Type any other button to go back");
    }

    /**
     * Line break
     */
    public void lines(){
        System.out.println("---------------------");
    }
}
