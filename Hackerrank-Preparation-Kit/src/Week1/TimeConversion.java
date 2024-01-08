package Week1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TimeConversion {
    public static void main(String[] args) {

        System.out.println(timeConversion("07:05:45PM"));
    }

    public static String timeConversion(String s) {
        // Write your code here

        String time = s.substring(0,s.length()-2);
        String time2 = s.substring(s.length()-2);

        String finalTime = time + " " + time2;

        return LocalTime.parse(
                finalTime, DateTimeFormatter.ofPattern(
                                "hh:mm:ss a", Locale.US
                        )).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
