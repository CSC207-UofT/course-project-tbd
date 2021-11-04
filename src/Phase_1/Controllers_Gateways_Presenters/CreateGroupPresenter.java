package Phase_1.Controllers_Gateways_Presenters;

public class CreateGroupPresenter {
    public void Intro(){
        System.out.println("What would you like your group name to be?");
    }

    public void InvalidGroupName(String groupName){
        System.out.println("Sorry! The group name " + groupName + " is taken. Please try another group name!");
    }
    public void CreateSuccess(String groupName){
        System.out.println("Congrats, group " + groupName + " is now created!");
    }
    public void lines(){
        System.out.println("---------------------");
    }
}
