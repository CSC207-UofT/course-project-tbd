package Phase_1.Controllers_Gateways_Presenters;

public class MainPagePresenter {

    /**
     * Instructions for navigating the main page
     */
    public void mainPageInstruction(){
        System.out.println("Welcome to TBD's App");
        String s = "Type 0 to login an existed account \n";
        s += "Type 1 to create an account \n";
        s += "Type 2 to exit";
        System.out.println(s);
    }

    /**
     * Prompting the user for input
     */
    public void decisionAsk(){
        System.out.println("I choose: ");
    }
}
