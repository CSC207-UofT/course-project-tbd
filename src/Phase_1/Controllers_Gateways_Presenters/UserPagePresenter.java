package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.NormalUser;

public class UserPagePresenter {
    private String userDetail;

    public UserPagePresenter(String userDetail){
        this.userDetail = userDetail;
    }

//    public void welcomeMsg(){
//        System.out.println("Welcome! " + ((NormalUser) user).username);
//    }

    public void userProfilePage(){
        System.out.println("---------------------");
        System.out.println("Your User Profile:");
        System.out.println(userDetail);
        System.out.println("---------------------");
    }

    public void availableOptions(){
        System.out.print("Your Options:\n"+
                "1. My Group\n" +
                "2, My Tasks\n" +
                "3. My Notification\n" +
                "4. Sign Out\n" +
                "Your answer here: ");
    }

}
