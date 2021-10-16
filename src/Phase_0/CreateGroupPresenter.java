package Phase_0;

public class CreateGroupPresenter {
    public void Intro(){
        System.out.println("What would you like your group name to be?");
    }

    public void InvalidGroupName(String groupName){
        System.out.println("Sorry! The group name " + groupName + " is taken. Please try another group name!");
    }
}
