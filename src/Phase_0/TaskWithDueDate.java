package Phase_0;

import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class TaskWithDueDate extends Task implements Comparable<TaskWithDueDate>{

    public TaskWithDueDate(String title, String information, int year, int month, int day, int hour, int minute) {
        super(title, information, year, month, day, hour, minute);
    }

    @Override
    public int compareTo(TaskWithDueDate o) {
        if (this.dueDate.isBefore(o.getDueDate())){
            return (int) Duration.between(this.dueDate, o.getDueDate()).toMillis();
        }else if(this.dueDate.isAfter(o.dueDate)){
            return (int) Duration.between(this.dueDate, o.getDueDate()).toMillis();
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatDateTime = this.dueDate.format(format);
        return super.toString() + "\nDue Date: " +formatDateTime;
    }
}
