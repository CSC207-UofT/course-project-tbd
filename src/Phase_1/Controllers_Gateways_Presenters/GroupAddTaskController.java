package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.Task;
import Phase_1.Entity.TaskWithDueDate;
import Phase_1.UseCaseClass.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class GroupAddTaskController {
    private String userId;
    private String groupId;
    private String categoryName;
    private UserManager um;
    private TaskManager tm;
    private GroupManager gm;
    NotificationManager nm;

    public GroupAddTaskController(String userId, String groupId, String categoryName, UserManager um, TaskManager tm,
                                  GroupManager gm) {
        this.userId = userId;
        this.groupId = groupId;
        this.categoryName = categoryName;
        this.um = um;
        this.tm =tm;
        this.gm = gm;
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CategoryManager cm = new CategoryManager();
        try {
            String input;
            boolean flag = true;
            GroupAddTaskPresenter gatp = new GroupAddTaskPresenter(userId, um, gm, groupId, categoryName);
            while (flag) {
                gatp.instructions();
                input = reader.readLine();
                switch (input) {
                    case "1": {
                        StringBuilder s = new StringBuilder();
                        for (Task t : cm.getCategoryByGroup(categoryName, gm.getGroupById(groupId)).getTasks()) {
                            s.append(t.toString() + "\n");
                        }
                        System.out.println(s);
                        break;
                    }
                    case "2": {
                        if (gm.checkIfLeader(gm.getGroupById(groupId).getgroupName(), um.getUserById(userId))) {
                            gatp.giveTaskName();
                            String taskTitle = reader.readLine();
                            gatp.giveTaskDetail();
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
                                tm.addTaskToCategory(cm.getCategoryByGroup(categoryName, gm.getGroupById(groupId)), task);
                            } else {
                                Task task = new Task(taskTitle, taskDetail,
                                        cm.getCategoryByGroup(categoryName, gm.getGroupById(groupId)));
                                tm.addTaskToCategory(cm.getCategoryByGroup(categoryName, gm.getGroupById(groupId)), task);
                            }
                        } else if (userId.equals(categoryName)) {
                                gatp.toComplete();
                                String completed = reader.readLine();
                                Task task = tm.getTaskByName(cm.getCategoryByName(um.getUserById(userId), categoryName),
                                        completed);
                                if (tm.checkTask(cm.getCategoryByName(um.getUserById(userId), categoryName), task)) {
                                    tm.completeTask(task);
                                    System.out.println("The task you entered has been finished");
                                } else {
                                    gatp.notValid();
                                }
                        }
                        break;
                    }
                    case "0": {
                        flag = false;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("error1");
            System.out.println("Please type a valid number");
        }
    }
}
