package Phase_2Test;

//public class NormalUserTest {
//    NormalUser nm;
//    Category a;
//    Category b;
//    Category c;
//    Group gm1;
//    Group gm2;
//    ArrayList<String> myGroups;
//    ArrayList<Task> my_Tasks;
//    User leader;
//    User leader2;
//
//
//    @Before
//    public void setUp() {
//        nm = new NormalUser("Apple", "1234", "what is your age", "33");
//        Task first = new Task("Sleep");
//        Task second = new Task("Wake up");
//        my_Tasks = new ArrayList<>();
//        my_Tasks.add(first);
//        my_Tasks.add(second);
//        nm.ad = my_Tasks;
//
//    }
//    @Test
//    public void Testuserinfo() {
//        assertEquals("Username: " + "Apple" + "\n"
//                + "Password: " + "1234", nm.displayUserDetail());
//        assertEquals(1, nm.getMyCategories().size());
//        assertEquals("what is your age", nm.getSQ());
//        assertEquals("33", nm.getSQ_Ans());
//    }
//    @Test
//    public void TestaddCategories(){
//        a = new Category("Food");
//        b = new Category("sport");
//        c = new Category("study");
//        nm.addNewCategory(a);
//        nm.addNewCategory(b);
//        nm.addNewCategory(c);
//        assertEquals(4, nm.getMyCategories().size());
//    }
//    @Test
//    public void TestmyTask(){
//        assertEquals(2, nm.getMyTasks().size());
//    }
//
//    @Test
//    public void TestaddtasktoCategory(){
//        Task other = new Task("Eat well");
//        nm.addTasktoCategory(other, nm.getMyCategories().get(0));
//        assertEquals(1, nm.getMyCategories().get(0).getTasks().size());
//
//    }
//
//    @Test
//    public void Testmygroups(){
//        leader = new NormalUser("leader", "123");
//        gm1 = new Group(leader, "Fun Group");
//        leader2 = new NormalUser("leader", "123");
//        gm2 = new Group(leader, "Kick Group");
//        myGroups = new ArrayList<>();
//        myGroups.add(gm1.getgroupName());
//        myGroups.add(gm2.getgroupName());
//        nm.myGroups = myGroups;
//        assertEquals(2, nm.getMyGroups().size());
//
//    }
//
//}