package Phase_1.Controllers_Gateways_Presenters;

public class LeaveGroupPresenter {
    public void askForName(){
        System.out.println("Please type in the name of the group you want to leave");
    }
    public void noGroupFound(){
        System.out.println("Sorry, the group name you type in is not found");
    }
    public void leaveSuccess(String name){
        System.out.println("You left group " + name + " successfully");
    }
    public void goBack() {
        System.out.println("you will be redirected to Group Page");
    }
    public void lines(){
        System.out.println("---------------------");
    }
}
