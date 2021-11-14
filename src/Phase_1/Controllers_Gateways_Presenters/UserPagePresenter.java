package Phase_1.Controllers_Gateways_Presenters;


public class UserPagePresenter {
    private final String userDetail;

    public UserPagePresenter(String userDetail){
        this.userDetail = userDetail;
    }


    public void userProfilePage(){
        System.out.println("---------------------");
        System.out.println("Your User Name:");
        System.out.println(userDetail);
        System.out.println("---------------------");
    }

    public void availableOptions(){
        String s = "Your Options:\n1. My Group\n2. My Categories\n3. My Notification\n4. Sign Out\nYour answer here: ";
        System.out.print(s);
    }

}
