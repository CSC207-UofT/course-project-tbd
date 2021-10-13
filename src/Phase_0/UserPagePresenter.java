package Phase_0;
import java.util.function.DoubleToIntFunction;

public class UserPagePresenter {
    User user;

    public UserPagePresenter(User user){
        this.user = user;
    }

//    public void welcomeMsg(){
//        System.out.println("Welcome! " + ((NormalUser) user).username);
//    }

    public void userProfilePage(){
        System.out.println("Your User Profile:");
        showMyAccount();
        System.out.println("\nCategories:");
        displayCategory();
    }

    public void showMyAccount() {
        if(this.user instanceof NormalUser){
            System.out.println(((NormalUser) this.user).displayUserDetail());
        }
    }

    public void displayCategory(){
        System.out.println(((NormalUser) this.user).displayMyCategories());
    }
}
