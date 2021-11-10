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
                "Type 1 if you forgot your password \n" +
                "Type anything else to go back to main page");
    }
    public void SQ(String sq){
        System.out.println("Answer the following question \n" + sq);
    }
    public void SQ_AS(){
        System.out.println("Security Question answered successfully! \n" +
                "Enter new password");
    }
    public void SQ_AUS(){
        System.out.println("Security Question answered incorrectly \n" +
                "Type 0 to try again \n" +
                "Type anything else to go back to the main page");
    }

    public void fail_1(){
        System.out.println("Sorry, your username is invalid :(");
    }

    public void changed(){
        System.out.println("Password successfully changed");
    }
}
