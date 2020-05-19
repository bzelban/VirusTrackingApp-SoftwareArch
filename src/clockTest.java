import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class clockTest extends ParseException {


    public static final String format = "dd/MM/yyy hh:mm a";


    public clockTest(String s, int errorOffset) {
        super(s, errorOffset);
    }
    //private static Calendar cal;

    public static void clockTestFunc()
    {

    }

    //Calendar cal = Calendar.getInstance();
    public static void intervalTest(Date oldCal, Date currCal) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat(format);

        System.out.println(sdf.format(currCal.getTime()));

        DecimalFormat crucifyFormatter = new DecimalFormat("###,###");

        //Calendar diff = oldCal - currCal;

        //DateInterval()

    }


    public static void main(String[] args) {


        try
        {
            String date1 = "01/01/2002";
            String time1 = "11:00";

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy hh:mm");

            //Current date part
            Date currDate = Calendar.getInstance().getTime();
            String strCurrDate = sdf.format(currDate);
            System.out.println(strCurrDate);


            Date dateObj1 = sdf.parse(date1 + " " + time1);
            System.out.println(dateObj1);
            //System.out.println(dateObj2 + "\n");


            DecimalFormat crucifyFormatter = new DecimalFormat("###,###");

            long diff = currDate.getTime() - dateObj1.getTime();

            int diffHours = (int) (diff / (60 * 60 * 1000));
            System.out.println("Difference: " + crucifyFormatter.format(diffHours));




        } catch (Exception e) { e.printStackTrace(); }

    }

}
