import java.text.DecimalFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.Format;


public class clockTest {

    public static void main(String []args) {

        try
        {
            String date1 = "07/15/2016";
            String time1 = "11:00 AM";
            String date2 = "07/17/2016";
            String time2 = "12:15 AM";

            String format = "MM/dd/yyy hh:mm";
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyy hh:mm");

            //System.out.println(sdf);

            Date dateObj1 = sdf.parse(date1 + " " + time1);
            Date dateObj2 = sdf.parse(date2 + " " + time2);

            System.out.println(dateObj1);
            System.out.println(dateObj2 + "\n");

            DecimalFormat crucifyFormatter = new DecimalFormat("###,###");

            long diff = dateObj2.getTime() - dateObj1.getTime();

            int diffHours = (int) (diff / (60 * 60 * 1000));
            System.out.println("Difference: " + crucifyFormatter.format(diffHours));

            //For Current
            //Date currentDate = new Date();
            //currentDate = sdf.parse(String.valueOf(new Date()));
            //System.out.println( crucifyFormatter.format(currentDate) );

            //System.out.println(java.time.Clock.systemUTC().instant());

            //System.out.println();

            //System.out.println(java.time.LocalDate.now());


        } catch (Exception e) { e.printStackTrace(); }
    }

}
