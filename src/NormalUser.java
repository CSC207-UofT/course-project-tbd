import java.util.ArrayList;

public class NormalUser extends User{

    public String username;
    public String password;

    //    public ArrayList<GroupTask> myGroups = new ArrayList<GroupTask>();

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

    /**
     * A method that takes the parameter (newCategory) and adds it to the ArrayList
     */
    public void addNewCategory(Category newCategory) {
        this.myCategories.add(newCategory);
    };

    /**
     * A method that takes the parameter (target) and removes it from the ArrayList
     */
    public void deleteCategory(Category target) {
        this.myCategories.remove(target);
    };
}
