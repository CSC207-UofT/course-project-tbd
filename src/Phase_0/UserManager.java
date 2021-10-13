package Phase_0;

import java.util.ArrayList;
import java.util.Objects;

public class UserManager {
    public ArrayList<NormalUser> allUsers = new ArrayList<>();

    public void createUser() {
    }


    /**
     * Creates a normal user and add it to the arraylist of all the users.
     */
    public void createNormalUser(String username, String password) {
        this.allUsers.add(new NormalUser(username, password));
    }


    /**
     * Check if the attempted username is not in the pool of all usernames.
     */
    public boolean checkIfValid(String UserId) {
        for (NormalUser user : allUsers) {
            if (user.username.equals(UserId)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Checks if the attempted username and password is in the user pool, if yes then return true, otherwise return false.
     */
    public boolean login(String ausername, String apassword) {
        for (NormalUser user : allUsers) {
            if (Objects.equals(user.username, ausername) && Objects.equals(user.password, apassword)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the user when given its username or null if not found
     */
    public NormalUser getUserById(String ID) {
        for (NormalUser user : allUsers) {
            if (user.username.equals(ID)) {
                return user;
            }
        }
        return null;
    }
}
