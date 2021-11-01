package Phase_0;

import java.util.function.DoubleToIntFunction;

public class UserPagePresenter {
    private NormalUser user;

    public UserPagePresenter(NormalUser user){
        this.user = user;
    }

//    public void welcomeMsg(){
//        System.out.println("Welcome! " + ((NormalUser) user).username);
//    }

    public void userProfilePage(){
        System.out.println("---------------------");
        System.out.println("Your User Profile:");
        System.out.println(this.user.displayUserDetail());
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
