package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.Task;
import Phase_1.Entity.TaskWithDueDate;
import Phase_1.UseCaseClass.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.util.List;

/**
 * This GroupAddTaskController class is made for controlling the task page
 * in a group according to the user input. If the user is the leader of the group,
 * they would have an additional option to add a task for the member whose folder
 * they chose to enter
 */

public class GroupAddTaskController {
    /**
     * The userId is given beforehand from the previous controller
     */
    private final String userId;
    /**
     * The groupId is given beforehand from the previous controller
     */
    private final String groupId;
    /**
     * The categoryName is given beforehand from the previous controller
     */
    private final String categoryName;
    /**
     * User case for all operations we perform on Users
     */
    private final UserManager um;
    /**
     * Use case for all operations we perform on Tasks
     */
    private final TaskManager tm;
    /**
     * Use case for all operations we perform on Group
     */
    private final GroupManager gm;
    /**
     * Used to start alarm for task with a due date, and send notification to user mailbox
     */
    NotificationManager nm;


    /**
     * Constructs the personalized Task Page for the specified category
     * @param userId an Id of the User given from the previous controller
     * @param groupId an Id of the Group given from the previous controller
     * @param categoryName the category's name given from the previous controller
     * @param um an instance of UserManager
     * @param tm an instance of TaskManager
     * @param gm an instance of GroupManager
     */
    public GroupAddTaskController(String userId, String groupId, String categoryName, UserManager um, TaskManager tm,
                                  GroupManager gm, NotificationManager nm) {
        this.userId = userId;
        this.groupId = groupId;
        this.categoryName = categoryName;
        this.um = um;
        this.tm =tm;
        this.gm = gm;
        this.nm = nm;
    }

    /**
     * Starts the task page for a particular member of the group, display all assigned task for this
     * use by typing 1. Assign a new task (if user is the leader) or finish an assigned task by typing 2.
     * Goes back to the previous page by typing 0.
     */
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
                    case "1" :
                        StringBuilder s = new StringBuilder();
                        for (Task t : cm.getCategoryByGroup(categoryName, gm.getGroupById(groupId)).getTasks()) {
                            s.append(t.toString()).append("\n");
                        }
                        System.out.println(s);
                        break;
                    case "2" :
                        if (gm.checkIfLeader(gm.getGroupById(groupId).getgroupName(), um.getUserById(userId))) {
                            gatp.giveTaskName();
                            String title = reader.readLine(); //user enters the title of a task
                            gatp.giveTaskDetail();
                            String detail = reader.readLine(); // user enters the detail of a task

                            System.out.println("Do you want to set an alarm to notify the group? (y/n)");
                            String yesOrNo = reader.readLine();

                            if (yesOrNo.equals("y")) {
                                System.out.println("When do you want to notified (24-hour clock)? " +
                                        "YYYY/MM/DD/hh/mm (2021/11/07/08/00)");
                                try {
                                    //dates must be entered in the correct format
                                    String date = reader.readLine();
                                    List<String> formattedDate = List.of(date.strip().split("/"));
                                    // split the date into a list of string
                                    int year = Integer.parseInt(formattedDate.get(0));
                                    int month = Integer.parseInt(formattedDate.get(1));
                                    int day = Integer.parseInt(formattedDate.get(2));
                                    int hour = Integer.parseInt(formattedDate.get(3));
                                    int minute = Integer.parseInt(formattedDate.get(4));
                                    // transform all the inputs into integers

                                    // create the task as a TaskWithDueDate object
                                    TaskWithDueDate task = new TaskWithDueDate(title, detail, year
                                            , month, day, hour, minute);
                                    nm.addTaskWithDueDate(task);
                                    tm.addTask(cm.getCategoryByGroup(categoryName, gm.getGroupById(groupId)), task);
                                    gatp.taskAdded();
                                } catch (UnsupportedOperationException e) {
                                    // this exception is thrown when the user schedules a date in the past
                                    System.out.println(e.getMessage());
                                } catch (IndexOutOfBoundsException e2){
                                    // this exception is thrown when the user's date input does not follow the format
                                    System.out.println(
                                            "Please enter according to the format: Year/Month/Date/Hour/Minute");
                                } catch (DateTimeException e3){
                                    // this exception is thrown when the date user entered is an invalid date
                                    System.out.println("You have entered an invalid date");
                                }
                            } else { // this means that the user choose to add a task without the notifications
                                Task task = new Task(title, detail,
                                        cm.getCategoryByGroup(categoryName, gm.getGroupById(groupId)));
                                tm.addTask(cm.getCategoryByGroup(categoryName, gm.getGroupById(groupId)), task);
                                gatp.taskAdded();
                            }
                        } else if (userId.equals(categoryName)) {
                            // this handles the case where the owner of this folder wants to finish a task
                                gatp.toComplete();
                                String completed = reader.readLine();
                                Task task = tm.getTaskByName(cm.getCategoryByName(um.getUserById(userId), categoryName),
                                        completed);
                                if (tm.checkTask(cm.getCategoryByName(um.getUserById(userId), categoryName), task)) {
                                    tm.completeTask(task);
                                    System.out.println("The task you entered has been finished");
                                } else {
                                    // this handles the case where the user input a task that does not exist
                                    gatp.notValid();
                                }
                        }
                        break;
                    case "0" :
                        flag = false;
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Please type a valid number");
        }
    }
}
