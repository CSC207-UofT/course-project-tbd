package Phase_0;

public class GroupPagePresenter {
    public void welcomeLine(){
        System.out.println("Hello, there \n" +
                "Type 0 create a group \n" +
                "Type 1 join a group \n" +
                "Type 2 leave a group \n" +
                "Type 3 to leave this page");
    }
    public void noGroup(){
        System.out.println("It seems that you didn't join any group yep :(");
    }
}
