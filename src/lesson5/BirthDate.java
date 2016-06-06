package lesson5;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by User on 20.03.2016.
 */
public class BirthDate {
    public static void main(String[] args) throws ParseException {
        Date now = new Date();
        System.out.println(now);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        dateFormat.format(now);
        System.out.println(now);

        Date birth = dateFormat.parse("01 03 1985");
        System.out.println(birth);
    }
}
