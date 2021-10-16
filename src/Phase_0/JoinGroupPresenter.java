package Phase_0;

public class JoinGroupPresenter {
    public void askGroupName(){
        System.out.println("Please enter the group name");
    }

    public void groupNameNotInMap(){
        System.out.println("Sorry, the name is not available in our database " +
                "\n Enter 1 search for the group again \n" +
                "Enter any other number to go back");
    }

    public void alreadyInGroup(String groupName){
        System.out.println("Sorry you are already in the group - " + groupName + "\n " +
                "Enter 1 to enter a new group name \n " +
                "Enter any other number to go back");
    }
    public void joinSuccess(String groupName){
        System.out.println("Congrats, you joined group " + groupName);
    }
}
