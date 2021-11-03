package Phase_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class GroupContentController {

    private UserManager um;
    private GroupManager gm;
    private Group group;
    private NormalUser user;
    private GroupContentPresenter gcp = new GroupContentPresenter();

    public GroupContentController(UserManager um, GroupManager gm, Group group, NormalUser user) {
        this.gm = gm;
        this.um = um;
        this.group = group;
        this.user = user;
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
                        if (gm.checkIfLeader(group.getgroupName(), user)) {
                            StringBuilder s = new StringBuilder();
                            for (Folder f : group.getFolders()) {
                                s.append(f.getFolderName()).append("\n");
                            }
                            s.delete(s.length() - 1, s.length());
                            System.out.println(s);
                        } else {
                            for (Folder f : group.getFolders()) {
                                if (f.getFolderName().equals(user.getUsername())) {
                                    f.toString();
                                }
                            }
                        }
                        gcp.instructions();
                        input = reader.readLine();
                        break;
                    }
                    case "3": {
                        GroupChatController gcc = new GroupChatController(group, user);
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

