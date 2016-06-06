package lesson5;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by User on 20.03.2016.
 */
public class CalendarWork {
    public static void main(String[] args) {
        Calendar c = new GregorianCalendar();
        c.set(1985, Calendar.MARCH, 1);

        System.out.println(c.get(Calendar.DAY_OF_WEEK) + " " + c.getDisplayName(7, 2 , Locale.forLanguageTag("en")));
    }
}
