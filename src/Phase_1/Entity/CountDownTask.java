package Phase_1.Entity;


import Phase_1.UseCaseClass.CategoryManager;

public class CountDownTask extends Task implements TomatoClock{
    private int WorkTime;
    private int BreakTime;


    public CountDownTask(String title) {
        super(title);
    }

    public int getWorkTime()
    {
        return WorkTime;
    }
    public int getBreakTime()
    {
        return BreakTime;
    }

}
