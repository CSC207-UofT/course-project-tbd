package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.Folder;
import Phase_1.Entity.Group;
import Phase_1.Entity.NormalUser;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupContentController {

    private UserManager um;
    private GroupManager gm;
    private Group group;
    private String userId;
    private GroupContentPresenter gcp = new GroupContentPresenter();

    public GroupContentController(UserManager um, GroupManager gm, Group group, String userId) {
        this.gm = gm;
        this.um = um;
        this.group = group;
        this.userId = userId;
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        gcp.instructions();
        try {
            String input = reader.readLine();
            while(!input.equals("4")) {
                switch (input) {
                    case "1":
                            // TODO Access to Home Page
                            System.out.println("HomePage class");
                            break;
                    case "2": {
                        if (gm.checkIfLeader(group.getgroupName(), um.getUserById(userId))) {
                            StringBuilder s = new StringBuilder();
                            for (Folder f : group.getFolders()) {
                                s.append(f.getFolderName()).append("\n");
                            }
                            s.delete(s.length() - 1, s.length());
                            System.out.println(s);
                        } else {
                            for (Folder f : group.getFolders()) {
                                if (f.getFolderName().equals(um.getUserById(userId).getUsername())) {
                                    f.toString();
                                }
                            }
                        }
                        gcp.instructions();
                        input = reader.readLine();
                        break;
                    }
                    case "3": {
                        GroupChatController gcc = new GroupChatController(group, userId, um);
                        gcc.run();
                        gcp.instructions();
                        input = reader.readLine();
                        break;
                    }
                    case "0": System.exit(0);
                    break;
                }
            }
            } catch(IOException e){
                System.out.println("Please type a valid number");
            }
        }

    }

