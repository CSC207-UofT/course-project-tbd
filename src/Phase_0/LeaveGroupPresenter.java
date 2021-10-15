package Phase_0;

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

}