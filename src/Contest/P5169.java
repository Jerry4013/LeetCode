package Contest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class P5169 {
    public int daysBetweenDates(String date1, String date2)  {
        long diff = 0;
        try {
            Date myDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
            Date myDate2 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
            long diffInMillies = Math.abs(myDate1.getTime() - myDate2.getTime());
            diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (int) diff;
    }

    public static void main(String[] args) throws ParseException {
        int i = new P5169().daysBetweenDates("2020-01-15", "2019-12-31");
        System.out.println("i = " + i);
    }
}
