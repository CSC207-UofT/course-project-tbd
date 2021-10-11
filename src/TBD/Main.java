package TBD;

import TBD.Category;


public class Main {
    public static void main(String[] args) {
        // A really dumb way to test tasks
        IndividualTask testtask = new IndividualTask();
        Category testCat = new Category("cat");
        testtask.addNewCategory(testCat);
        System.out.println(testtask.categories);

        // A really dumb way to test GetUserDetail
        NormalUser testUser = new NormalUser("Peter", "10086");
        System.out.println(testUser.displayUserDetail());
    }
}
