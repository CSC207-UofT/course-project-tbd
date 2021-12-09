package Phase_1_ignore_this.Controllers_Gateways_Presenters;

public class NewUserPresenter {

    /**
     * Giving a warm welcome to the user when logging in
     */
    public void Intro(){
        String s = "Welcome new adventurer! \n";
        s += "Hope you can enjoy our app :)\n \n";
        s += "Please type your preferred UserName";
        System.out.println(s);
    }

    /**
     * Notification to let user know if their username is invalid
     */
    public void invalidUserName(String u){
        System.out.println("Sorry, UserName " + u + " has been taken");
    }

    /**
     * Message asking the user to give a password
     */
    public void askPassword(String u){
        System.out.println("Congrats! UserName " + u + " is valid \n" +
                "Please type in your password: ");
    }

    /**
     * Message asking the user to give a security question
     */
    public void askSQ(){
        System.out.println("Please enter a security question that only you would know the answer for?");
    }

    /**
     * Message asking the user to give a security answer
     */
    public void askSQAnswer(){
        System.out.println("Please give your answer to the security question?");
    }

    /**
     * Message to let user know that account has been created
     */
    public void completed(){
        System.out.println("Hurray! your account is created! \n" +
                "Have a nice trip!");
    }
}
