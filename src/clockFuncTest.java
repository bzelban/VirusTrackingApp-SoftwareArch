import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


class cellPhone
{

    cellPhone() throws ParseException {}


    String date1 = "19/05/2020";
    String time1 = "20:00";

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
    Date oldDate = sdf.parse("19/05/2020" + " " + "20:00");


    public boolean clockFunction(Date oldDate) throws InterruptedException {
        Date currDate = Calendar.getInstance().getTime();

        DecimalFormat cFormat = new DecimalFormat("###,###");

        long diff = currDate.getTime() - oldDate.getTime();
        int diffHours = (int) (diff / (60 * 60 * 1000));

        TimeUnit.MINUTES.sleep(5);

        if(diffHours == 2 || diffHours > 2) {
            System.out.println("You have to enter your status ");
            //Buraya fonksiyon gelecek
            return true;
        }
        else
        {
            return false;
        }

    }
}


public class clockFuncTest{


    public static void main(String[] args) throws ParseException, InterruptedException {

        cellPhone pTest = new cellPhone();

        pTest.clockFunction(pTest.oldDate);



    }
}
