package Phase_1_ignore_this.Controllers_Gateways_Presenters;


public class UserPagePresenter {
    private final String userDetail;

    public UserPagePresenter(String userDetail){
        this.userDetail = userDetail;
    }


    /**
     * Message of userprofile
     */
    public void userProfilePage(){
        System.out.println("---------------------");
        System.out.println("Your User Name:");
        System.out.println(userDetail);
        System.out.println("---------------------");
    }


    /**
     * Message to let user know of their options
     */
    public void availableOptions(){
        String s = "Your Options:\n1. My Group\n2. My Categories\n3. My Notification\n4. Sign Out\nYour answer here: ";
        System.out.print(s);
    }

}
