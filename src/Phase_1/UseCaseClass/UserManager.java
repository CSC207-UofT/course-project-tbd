package Phase_1.UseCaseClass;

import Phase_1.Entity.*;

import java.util.ArrayList;
import java.util.Objects;

public class UserManager {
    private final ArrayList<User> allUsers;

    public UserManager(ArrayList<User> user_list) {
        this.allUsers = user_list;
    }

    /**
     * Returns user detail in string format
     */
    public String displayUserDetail(User user) {
        return ("Username: " + user.getUsername() + "\n"
                + "Password: " + user.getPassword());
    }


    /**
     * Creates a normal user and add it to the arraylist of all the users.
     */
    public void createNormalUser(String username, String password, String sq, String sq_ans) {
        this.allUsers.add(new NormalUser(username, password, sq, sq_ans));
    }


    /**
     * Check if the attempted username is not in the pool of all usernames.
     */
    public boolean checkIfValid(String UserId) {
        for (User user : allUsers) {
            if (user.getUsername().equals(UserId)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Checks if the attempted username and password is in the user pool,
     * if yes then return true, otherwise return false.
     */
    public boolean login(String ausername, String apassword) {
        for (User user : allUsers) {
            if (Objects.equals(user.getUsername(), ausername) && Objects.equals(user.getPassword(), apassword)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the user when given its username or null if not found
     */
    public User getUserById(String ID) {
        for (User user : allUsers) {
            if (user.getUsername().equals(ID)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Add new category to user defined by user. Category defined by c.
     */
    public void addCategory(User user, Category c) {
        user.addNewCategory(c);
    }


    /**
     * Add task to user, given designated task and category.
     */
    public void addTask(User user, Task task, Category c) {
        user.addTasktoCategory(task, c);
    }


    /**
     * Displays all categories in string format.
     */
    public String displayCategories(User user) {
        StringBuilder s = new StringBuilder();
        for (Category c : user.getMyCategories()) {
            s.append(c.toString()).append("\n");
        }
        return s.toString();
    }
    /**
     * A method that returns a list of all the user.
     */
    public ArrayList<User> getuser(){
        return new ArrayList<>(allUsers);
    }


}
