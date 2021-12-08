package Phase_1_ignore_this.Controllers_Gateways_Presenters;

public class UserLoginPresenter {

    /**
     * Message welcoming user
     */
    public void welcomePage(){
        System.out.println("Hello traveller");
    }

    /**
     * Message outputting the UserID in string format
     */
    public void typeUserId(){
        System.out.println("UserId: "
        );
    }

    /**
     * Message outputting the password in string format
     */
    public void typePassword(){
        System.out.println("Password: ");
    }

    /**
     * Message welcoming the user
     */
    public void success(String u){
        System.out.println("Welcome " + u + " \nlong time no see" +
                "!");
    }

    /**
     * Message to let user know that their input does not match any in the database
     */
    public void fail(){
        System.out.println("Sorry, your input doesn't match :(");
    }

    /**
     * Message to let user know that the password inputted is incorrect
     */
    public void again(){
        String s = "Type 0 if you want to try again \n";
        s = s + "Type 1 if you forgot your password \n";
        s = s + "Type anything else to go back to main page";
        System.out.println(s);
    }

    /**
     * Outputting the security question
     */
    public void SQ(String sq){
        System.out.println("Answer the following question \n" + sq);
    }

    /**
     * Message letting user know that they can now give a new security password
     */
    public void SQ_AS(){
        System.out.println("Security Question answered successfully! \n" +
                "Enter new password");
    }

    /**
     * Message to let user know that the security answer is incorrect
     */
    public void SQ_AUS(){
        String s = "Security Question answered incorrectly\n";
               s = s + "Type 0 to try again \n";
               s = s + "Type anything else to go back to the main page";
        System.out.println(s);
    }

    /**
     * Message notifying the user that the password has been changed
     */
    public void changed(){
        System.out.println("Password successfully changed");
    }
}
