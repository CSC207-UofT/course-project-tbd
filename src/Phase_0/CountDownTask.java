package Phase_0;


import java.time.LocalDate;
import java.util.Timer;
import java.util.TimerTask;

public class CountDownTask extends Task{
    private int WorkTime;
    private int BreakTime;


    public CountDownTask(String title, String information, LocalDate date) {
        super(title, information, date);
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
