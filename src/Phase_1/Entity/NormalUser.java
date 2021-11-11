package Phase_1.Entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class NormalUser extends User implements Serializable {

    public String username;
    public String password;
    public String sq;
    public String sq_ans;

    public ArrayList<String> myGroups = new ArrayList<>();

    public ArrayList<Category> myCategories = new ArrayList<>();
    public ArrayList<Task> myTasks = new ArrayList<>();

    public NormalUser(String username, String password, String sq, String sq_ans) {
        this.username = username;
        this.password = password;
        this.sq = sq;
        this.sq_ans = sq_ans;
        Category all = new Category("All Tasks");
        this.addNewCategory(all);

    }

    public NormalUser(String username, String password) {
        this.username = username;
        this.password = password;
        Category all = new Category("All Tasks");
        this.addNewCategory(all);
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
    public void addGroup(String groupId){
        this.myGroups.add(groupId);

    }
    @Override
    public void removeGroup(String group){
        this.myGroups.remove(group);
    }

    public void addTasktoCategory(Task task, Category c){
        c.tasks.add(task);
    }
    public void addNewCategory(Category newCategory){
        this.myCategories.add(newCategory);
    }
    public ArrayList<Task> getMyTasks(){
        return myTasks;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){return password;}
    public String getSQ(){return sq;}
    public String getSQ_Ans(){return sq_ans;}
    public void setPassword(String pass){this.password = pass;}
    @Override
    public ArrayList<String> getMyGroups() {
        return myGroups;
    }

    public ArrayList<Category> getMyCategories(){
        return myCategories;
    }
}