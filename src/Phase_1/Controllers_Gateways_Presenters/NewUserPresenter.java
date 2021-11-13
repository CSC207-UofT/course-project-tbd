package Phase_1.Controllers_Gateways_Presenters;

public class NewUserPresenter {
    public void Intro(){
        String s = "Welcome new adventurer! \n";
        s += "Hope you can enjoy our app :)\n \n";
        s += "Please type your preferred UserName";
        System.out.println(s);
    }
    public void invalidUserName(String u){
        System.out.println("Sorry, UserName " + u + " has been taken");
    }
    public void askPassword(String u){
        System.out.println("Congrats! UserName " + u + " is valid \n" +
                "Please type in your password: ");
    }
    public void askSQ(){
        System.out.println("Please enter a security question that only you would know the answer for?");
    }

    public void askSQAnswer(){
        System.out.println("Please give your answer to the security question?");
    }
    public void completed(){
        System.out.println("Hurray! your account is created! \n" +
                "Have a nice trip!");
    }
}
