package Phase_0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TaskPageController {
    private NormalUser user;
    private TaskPagePresenter tpp;

    public TaskPageController(NormalUser user){
        this.user = user;
        this.tpp = new TaskPagePresenter(user);
    }
    public void run() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        tpp.displayCategory();
        tpp.availableOptions();
        String input = reader.readLine();
        if (input.equals("2")){
            tpp.giveNewTaskName();
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            String input1 = reader1.readLine();
        }
    }
}
