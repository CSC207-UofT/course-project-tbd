package TBD;

import java.util.ArrayList;

public class NormalUser extends User{

    public String username;
    public String password;
    // What is the TBD.Group?

    // Two Arraylists of Categories ??? Another one in individualTask
    public ArrayList<Category> myCategories = new ArrayList<Category>();


    public NormalUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * A method that returns username and password. PS someone please change the format to make it look better
     */
    public String displayUserDetail() {
        return (this.username + " " + this.password);
    }
}
