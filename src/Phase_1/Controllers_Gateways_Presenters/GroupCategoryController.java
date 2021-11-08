package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.Category;
import Phase_1.Entity.Task;
import Phase_1.Entity.TaskWithDueDate;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.NotificationManager;
import Phase_1.UseCaseClass.TaskManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class GroupCategoryController {
    private String groupId;
    private UserManager um;
    private TaskManager tm;
    private GroupManager gm;
    private String userId;
    private GroupCategoryPresenter gcatp;
    NotificationManager nm;

    public GroupCategoryController(UserManager um, GroupManager gm, TaskManager tm, String groupId, String userId,
                                   GroupCategoryPresenter gcatp) {
        this.gm = gm;
        this.um = um;
        this.tm = tm;
        this.groupId = groupId;
        this.userId = userId;
        this.gcatp = gcatp;
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(gm.getGroupById(groupId));
        System.out.println(groupId);
        try {
            String input;
            boolean flag = true;
            while(flag) {
                gcatp.instructions();
                input = reader.readLine();
                switch (input) {
                    case "1": {
                        if (gm.checkIfLeader(gm.getGroupById(groupId).getgroupName(), um.getUserById(userId))) {
                            StringBuilder s = new StringBuilder();
                            for (Category c : gm.getGroupById(groupId).getCategories()) {
                                s.append(c.toString()).append("\n");
                            }
                            s.delete(s.length() - 1, s.length());
                            System.out.println(s);
                        } else {
                            for (Category c : gm.getGroupById(groupId).getCategories()) {
                                if (c.getCategoryName().equals(um.getUserById(userId).getUsername())) {
                                    c.toString();
                                }
                            }
                        }
                        break;
                    }
                    case "2": {
                        if (gm.checkIfLeader(gm.getGroupById(groupId).getgroupName(), um.getUserById(userId))) {
                            gcatp.giveTaskName();
                            String taskTitle = reader.readLine();
                            gcatp.giveTaskDetail();
                            String taskDetail = reader.readLine();

                            System.out.println("Do you want to set an alarm to notify the group? (y/n)");
                            String yesOrNo = reader.readLine();

                            if (yesOrNo.equals("y")) {
                                System.out.println("When do you want to notified (24-hour clock)? " +
                                        "YYYY/MM/DD/hh/mm (2021/11/07/08/00)");
                                String date = reader.readLine();
                                List<String> formattedDate = List.of(date.strip().split("/"));
                                int year = Integer.parseInt(formattedDate.get(0));
                                int month = Integer.parseInt(formattedDate.get(1));
                                int day = Integer.parseInt(formattedDate.get(2));
                                int hour = Integer.parseInt(formattedDate.get(3));
                                int minute = Integer.parseInt(formattedDate.get(4));

                                TaskWithDueDate task = new TaskWithDueDate(taskTitle, taskDetail, year
                                        , month, day, hour, minute);
                                nm.addTaskWithDueDate(task);
//                                tm.addTask(um.getUserById(userId), task);
                            } else {
//                                Task task = new Task(taskTitle, taskDetail);
//                                tm.addTask(um.getUserById(userId), task);
                            }
                        }
                        break;
                    }
                    case "0":
                        flag = false;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Please type a valid number");
        }
    }

}
