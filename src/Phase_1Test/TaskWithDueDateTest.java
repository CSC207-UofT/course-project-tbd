package Phase_1Test;

import Phase_1.Entity.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class TaskWithDueDateTest {
    TaskWithDueDate td;
    TaskWithDueDate td1;
    LocalDateTime dueDate;
    int year;
    int month;
    int day;
    int hour;
    int minute;
    String s;

    @Before
    public void setup(){
        year = 2021;
        month = 11;
        day = 27;
        hour = 11;
        minute = 30;
        td = new TaskWithDueDate("Test", "Do it", year, month, day, hour, minute);
    }
    @Test
    public void TestgetDuedate(){
        dueDate = LocalDateTime.of(year, month, day, hour, minute);
        assertEquals(dueDate, td.getDueDate());
    }

    @Test
    public void TestcompareTo(){
        year = 2021;
        month = 11;
        day = 28;
        hour = 11;
        minute = 30;
        td1 = new TaskWithDueDate("Test", "Do it", year, month, day, hour, minute);
        assertFalse(td.compareTo(td1) < td1.compareTo(td));
    }

    @Test
    public void TesttoString(){
        s = "Title: "+ "Test" + "\n";
        s += "TODO: " + "Do it" + "\n";
        s += "Status: " + "In Progress" + "\n";
        s += "Due Date: "+ "27-11-2021 11:30";
        assertEquals(s, td.toString());
    }
}
