package Phase_0;


import java.io.Serializable;
import java.net.PortUnreachableException;
import java.util.ArrayList;

public class NormalUser extends User implements Serializable {

    public String username;
    public String password;

    public ArrayList<Group> myGroups = new ArrayList<>();
//
//    public ArrayList<Category> myCategories = new ArrayList<>();
    public ArrayList<Task> myTasks = new ArrayList<>();

    public NormalUser(String username, String password) {
        this.username = username;
        this.password = password;
        Category all = new Category("All Tasks");
//        this.addNewCategory(all);
    }

    /**
     * A method that returns username and password. PS someone please change the format to make it look better
     */
    public String displayUserDetail() {
        return ("Username: " + this.username + "\n"
                + "Password: " + this.password);
    }

//    public String displayMyCategories() {
//        StringBuilder s = new StringBuilder();
//        int size = this.myCategories.size();
//        for (Category c : this.myCategories) {
//            s.append(c.getCategoryName());
//            size -= 1;
//            if (size != 0) {
//                s.append("\n");
//            }
//        }
//        return s.toString();
//    }
//
//    /**
//     * A method that takes the parameter (newCategory) and adds it to the ArrayList
//     */
//    public void addNewCategory(Category newCategory) {
//        this.myCategories.add(newCategory);
//    }
//
//    /**
//     * A method that takes the parameter (target) and removes it from the ArrayList
//     */
//    public void deleteCategory(Category target) {
//        this.myCategories.remove(target);
//    }
//
//    public ArrayList<Category> getMyCategories(){
//        return this.myCategories;
//    }
    @Override
    public void addGroup(Group group){
        this.myGroups.add(group);

    }
    @Override
    public void removeGroup(Group group){
        this.myGroups.remove(group);
    }

    public void addTask(Task task){
        this.myTasks.add(task);
    }
    public ArrayList<Task> getMyTasks(){
        return myTasks;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){return password;}
}