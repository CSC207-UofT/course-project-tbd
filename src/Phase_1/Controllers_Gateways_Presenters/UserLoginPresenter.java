package Phase_1.Controllers_Gateways_Presenters;

public class UserLoginPresenter {
    public void welcomePage(){
        System.out.println("Hello traveller");
    }
    public void typeUserId(){
        System.out.println("UserId: "
        );
    }
    public void typePassword(){
        System.out.println("Password: ");
    }
    public void success(String u){
        System.out.println("Welcome " + u + " \nlong time no see" +
                "!");
    }
    public void fail(){
        System.out.println("Sorry, your input doesn't match :(");
    }
    public void again(){
        System.out.println("Type 0 if you want to try again \n" +
                "Type anything else to go back to main page");
    }
}
