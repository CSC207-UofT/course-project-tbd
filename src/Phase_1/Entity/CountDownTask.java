package Phase_1.Entity;


public class CountDownTask extends Task implements TomatoClock{
    private int WorkTime;
    private int BreakTime;


    public CountDownTask(String title, String information) {
        super(title, information);
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
