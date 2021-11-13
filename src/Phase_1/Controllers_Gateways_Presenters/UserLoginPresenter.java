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
        String s = "Type 0 if you want to try again \n";
        s = s + "Type 1 if you forgot your password \n";
        s = s + "Type anything else to go back to main page";
        System.out.println(s);
    }
    public void SQ(String sq){
        System.out.println("Answer the following question \n" + sq);
    }
    public void SQ_AS(){
        System.out.println("Security Question answered successfully! \n" +
                "Enter new password");
    }
    public void SQ_AUS(){
        String s = "Security Question answered incorrectly\n";
               s = s + "Type 0 to try again \n";
               s = s + "Type anything else to go back to the main page";
        System.out.println(s);
    }

    public void changed(){
        System.out.println("Password successfully changed");
    }
}
