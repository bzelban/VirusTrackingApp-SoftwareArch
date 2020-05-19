import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


class cellPhone
{

    cellPhone() throws ParseException {}


    String date1 = "19/05/2020";
    String time1 = "20:00";

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
    Date oldDate = sdf.parse(date1 + " " + time1);


    public boolean clockFunction(Date oldDate)
    {
        Date currDate = Calendar.getInstance().getTime();

        DecimalFormat cFormat = new DecimalFormat("###,###");

        long diff = currDate.getTime() - oldDate.getTime();
        int diffHours = (int) (diff / (60 * 60 * 1000));

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


    public static void main(String[] args) throws ParseException {

        cellPhone pTest = new cellPhone();

        pTest.clockFunction(pTest.oldDate);



    }
}
