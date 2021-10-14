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
        showMyAccount();
        System.out.println("---------------------");
    }

    public void showMyAccount() {
        System.out.println(this.user.displayUserDetail());
    }

    public void availableOptions(){
        System.out.print("Your Options:\n"+
                "1, My Tasks\n" +
                "2. Sign Out\n" +
                "3. Exit\n" +
                "Your answer here: ");
    }

}
