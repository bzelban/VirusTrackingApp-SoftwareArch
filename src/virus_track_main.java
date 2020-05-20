/*
        Virus Tracking Application

    Bedirhan Z. ELBAN
    Berk YILMAZ
    Mert DOYURGAN
    H. Tuğgün ASRAK

*/
/*
// THE FACTORY
// In here, 2 different factories creating specific phones.
// TO-DO: Add Storage!
// Note: Lecturer doesn't want this part. NEGATIVE!!!

abstract class CellPhone {
    abstract public String displayBrand();
    abstract public String displayModel();
    abstract public void displayAll();
}

class ApplePhone extends CellPhone{
    protected String brand;
    protected String model;

    @Override
    public String displayBrand(){ return brand; }

    @Override
    public String displayModel(){ return model; }

    @Override
    public void displayAll(){ displayBrand(); displayModel(); }

    public ApplePhone(String brand, String model)
    {
        this.brand = brand;
        this.model = model;
    }

}

abstract class AppleFactory {
    public static CellPhone createApple(String brand, String model)
    {
       if ("Apple".equalsIgnoreCase(brand))
       {
           return new ApplePhone("Apple", "iPhone");
       }
       else
       {
           System.out.println("Wrong Type");
       }
       return null;
    }
}

class SamsungPhone extends CellPhone{
    protected String brand;
    protected String model;

    @Override
    public String displayBrand(){ return brand; }

    @Override
    public String displayModel(){ return model; }

    @Override
    public void displayAll(){ displayBrand(); displayModel(); }

    public SamsungPhone(String brand, String model)
    {
        this.brand = brand;
        this.model = model;
    }

}

abstract class SamsungFactory{
    public static CellPhone createSamsung(String brand, String model)
    {
        if("Samsung".equalsIgnoreCase(brand))
        {
            return new SamsungPhone("Samsung", "Galaxy");
        }
        else
        {
            System.out.println("Wrong Type");
        }
        return null;
    }
}

////////////////////////////////////////////////////////////////////////////////////
*/


// The RawAppInc.
// This part ports Raw Native Virus Track app to the specific phone also for the Library

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


class MobileApp { //Volt-like

    private String appName; //Currently Template for App
    private String platform; //iOS or Android

    public MobileApp() // Default~
    {
        this.appName = "NONAME";
        this.platform = "NONAME";
    }

    public MobileApp(String appName, String platform) { // Parameterized~
        this.appName = appName;
        this.platform = platform;
    }

    public MobileApp createApp(String appName, String platform) {

        this.appName = appName;
        this.platform = platform;
        System.out.println(appName + " is Created for " + platform + " phone");
        return new MobileApp(appName, platform);
    }

}

class RawVirusTrackApp{ //Socket-like (SOURCE)

    private String UserNAME;
    private String UserSURNAME;
    private int UserAGE;
    private String UserADDRESS;
    private boolean tempFEWER;
    private boolean tempM_ACHE;
    private boolean tempR_NOSE;

    public String getUserNAME() {
        return UserNAME;
    }

    public void setUserNAME(String userNAME) {
        UserNAME = userNAME;
    }

    public String getUserSURNAME() {
        return UserSURNAME;
    }

    public void setUserSURNAME(String userSURNAME) {
        UserSURNAME = userSURNAME;
    }

    public int getUserAGE() {
        return UserAGE;
    }

    public void setUserAGE(int userAGE) {
        UserAGE = userAGE;
    }

    public String getUserADDRESS() {
        return UserADDRESS;
    }

    public void setUserADDRESS(String userADDRESS) {
        UserADDRESS = userADDRESS;
    }

    public boolean isTempFEWER() {
        return tempFEWER;
    }

    public void setTempFEWER(boolean tempFEWER) {
        this.tempFEWER = tempFEWER;
    }

    public boolean isTempM_ACHE() {
        return tempM_ACHE;
    }

    public void setTempM_ACHE(boolean tempM_ACHE) {
        this.tempM_ACHE = tempM_ACHE;
    }

    public boolean isTempR_NOSE() {
        return tempR_NOSE;
    }

    public void setTempR_NOSE(boolean tempR_NOSE) {
        this.tempR_NOSE = tempR_NOSE;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public Date getOldDate() {
        return oldDate;
    }

    public void setOldDate(Date oldDate) {
        this.oldDate = oldDate;
    }

    public boolean isClockIntervalCheck() {
        return clockIntervalCheck;
    }

    public void setClockIntervalCheck(boolean clockIntervalCheck) {
        this.clockIntervalCheck = clockIntervalCheck;
    }

    //TO-DO: NEED CLOCK TIME DATE
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
    Date oldDate = sdf.parse("01/05/2020" + " " + "20:00");

    RawVirusTrackApp() throws ParseException { } //This default constructor is for Parse
    boolean clockIntervalCheck = false;

    public void clockFunction(Date oldDate) throws InterruptedException
    {
        Date currDate = Calendar.getInstance().getTime();

        DecimalFormat cFormat = new DecimalFormat("###,###");

        long diff = currDate.getTime() - oldDate.getTime();
        int diffHours = (int) (diff / (60 * 60 * 1000));

        TimeUnit.MINUTES.sleep(5);

        if(diffHours == 2 || diffHours > 2)
        {
            System.out.println("You have to enter your status ");
            this.clockIntervalCheck = true;
        }
        else
        {
            this.clockIntervalCheck = false;
        }
    }

    //This is going to be overridden by socket-adapter-implementation classes
    void firstRun() throws InterruptedException {}

    public static MobileApp rawApp(String appName, String platform){
        return new MobileApp("rawVirusTrack", "debugOnly");
    }


}

interface NativeFramework{ //SocketAdapter-like
    MobileApp buildForApple();
    MobileApp buildForAndroid();
    MobileApp buildForLibrary();

}

// Class Adapter SOCKET-ADAPTER-IMPLEMENTATION-Like
class Apple_VirusTrackAppBuild extends RawVirusTrackApp implements NativeFramework, SubjectInterface {


    Apple_VirusTrackAppBuild(List<LibraryAppObserver> observers) throws ParseException {
        this.observers = observers;
    } //This default constructor is for Matching Super

    public Apple_VirusTrackAppBuild() throws ParseException {

    }

    @Override
    public MobileApp buildForApple()
    {
        return RawVirusTrackApp.rawApp("Virus Track", "Apple");
    } //DONE

    @Override
    public MobileApp buildForAndroid() {return null;}

    @Override
    public MobileApp buildForLibrary() {return null;}

    @Override
    public void firstRun() throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Name?: ");
        setUserNAME(sc.next());
        System.out.println("Surname?: ");
        setUserSURNAME(sc.next());
        System.out.println("Age?: ");
        setUserAGE(sc.nextInt());
        System.out.println("Address?: ");
        setUserADDRESS(sc.next());

        //APPLE SPECIFIQUE
        read();
        write();


        while(true)
        {
            TimeUnit.MINUTES.sleep(5);

            clockFunction(oldDate);

            if(this.isClockIntervalCheck() == true)
            {
                read();
                write();
            }
        }
    }

    public void read() // This will read from the User //DONE
    {

        String temp;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your recent physical conditions");

        System.out.println("Fewer?: (Y)es or (N)o");
        temp = sc.next();
        if(temp == "Y" || temp == "y" )
        {
            setTempFEWER(true);
        }
        else if (temp == "N" || temp == "n")
        {
            setTempFEWER(false);

        }
        else
        {
            System.out.println("Wrong input!");
        }


        System.out.println("Muscle Ache?: (Y)es or (N)o");
        temp = sc.next();
        if(temp == "Y" || temp == "y" )
        {
            setTempM_ACHE(true);
        }
        else if (temp == "N" || temp == "n")
        {
            setTempM_ACHE(false);
        }
        else
        {
            System.out.println("Wrong input!");
        }


        System.out.println("Runny Nose?: (Y)es or (N)o");
        temp = sc.next();
        if(temp == "Y" || temp == "y" )
        {
            setTempR_NOSE(true);

        }
        else if (temp == "N" || temp == "n")
        {
            setTempR_NOSE(false);

        }
        else
        {
            System.out.println("Wrong input!");
        }

        System.out.println("Thank You, Stay Safe!");
    }

    public void write() // This send data on patient_db to the system
    {
        //if Any of the patient has some health anomalies, cast postMessage(this.getNAME(), this.getSURNAME())

        patient_db.updateStatus(virus_track_main.patient_dbs ,this.getUserNAME(), this.getUserSURNAME(), this.isTempFEWER(), this.isTempM_ACHE(), this.isTempR_NOSE());

        if(isTempFEWER() || isTempM_ACHE() || isTempR_NOSE())
        {
            postMessage(this.getUserNAME(), this.getUserSURNAME());
        }

    }

    //Subject organs
    private List<LibraryAppObserver> observers;
    private String message;


    @Override
    public void register(LibraryAppObserver observer) { //DONE
        if (observer == null) throw new NullPointerException(("No Observer Found"));

        if(!observers.contains(observer))
        {
            observers.add(observer);
        }

    }

    @Override
    public void notifyObserver() { // Done
        for(LibraryAppObserver observer : observers)
        {
            observer.update();
        }

    }

    @Override
    public Object sendUpdate(LibraryAppObserver observer) {
        return this.message;
    }

    public void postMessage(String name, String surname)
    {
        System.out.println("This guy needs help! Name: " + name + " Surname: " + surname);
        notifyObserver();
    }

}

//  TO-DO:
//      Samsung_VirusTrackAppBuild
//      Library_VirusTrackAppBuild
//          NEEDED AFTER ADDING CLOCK TIME/DATE AND WRITE FUNCTION

class Android_VirusTrackAppBuild extends RawVirusTrackApp implements NativeFramework, SubjectInterface {


    Android_VirusTrackAppBuild(List<LibraryAppObserver> observers) throws ParseException {
        this.observers = observers;
    } //This default constructor is for Matching Super

    public void Android_VirusTrackAppBuild() throws ParseException {

    }

    @Override
    public MobileApp buildForApple()
    {
        return null;
    } //DONE

    @Override
    public MobileApp buildForAndroid()
    {
        return RawVirusTrackApp.rawApp("Virus Track", "Apple");
    }

    @Override
    public MobileApp buildForLibrary() {return null;}

    @Override
    public void firstRun() throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Name?: ");
        setUserNAME(sc.next());
        System.out.println("Surname?: ");
        setUserSURNAME(sc.next());
        System.out.println("Age?: ");
        setUserAGE(sc.nextInt());
        System.out.println("Address?: ");
        setUserADDRESS(sc.next());

        //APPLE SPECIFIQUE
        get();
        set();


        while(true)
        {
            TimeUnit.MINUTES.sleep(5);

            clockFunction(oldDate);

            if(this.isClockIntervalCheck() == true)
            {
                get();
                set();
            }
        }
    }

    public void get() // This will read from the User //DONE
    {

        String temp;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your recent physical conditions");

        System.out.println("Fewer?: (Y)es or (N)o");
        temp = sc.next();
        if(temp == "Y" || temp == "y" )
        {
            setTempFEWER(true);
        }
        else if (temp == "N" || temp == "n")
        {
            setTempFEWER(false);

        }
        else
        {
            System.out.println("Wrong input!");
        }


        System.out.println("Muscle Ache?: (Y)es or (N)o");
        temp = sc.next();
        if(temp == "Y" || temp == "y" )
        {
            setTempM_ACHE(true);
        }
        else if (temp == "N" || temp == "n")
        {
            setTempM_ACHE(false);
        }
        else
        {
            System.out.println("Wrong input!");
        }


        System.out.println("Runny Nose?: (Y)es or (N)o");
        temp = sc.next();
        if(temp == "Y" || temp == "y" )
        {
            setTempR_NOSE(true);

        }
        else if (temp == "N" || temp == "n")
        {
            setTempR_NOSE(false);

        }
        else
        {
            System.out.println("Wrong input!");
        }

        System.out.println("Thank You, Stay Safe!");
    }

    public void set() // This send data on patient_db to the system
    {
        //if Any of the patient has some health anomalies, cast postMessage(this.getNAME(), this.getSURNAME())

        patient_db.updateStatus(virus_track_main.patient_dbs ,this.getUserNAME(), this.getUserSURNAME(), this.isTempFEWER(), this.isTempM_ACHE(), this.isTempR_NOSE());

        if(isTempFEWER() || isTempM_ACHE() || isTempR_NOSE())
        {
            postMessage(this.getUserNAME(), this.getUserSURNAME());
        }

    }

    //Subject organs
    private List<LibraryAppObserver> observers;
    private String message;


    @Override
    public void register(LibraryAppObserver observer) { //DONE
        if (observer == null) throw new NullPointerException(("No Observer Found"));

        if(!observers.contains(observer))
        {
            observers.add(observer);
        }

    }

    @Override
    public void notifyObserver() { // Done
        for(LibraryAppObserver observer : observers)
        {
            observer.update();
        }

    }

    @Override
    public Object sendUpdate(LibraryAppObserver observer) {
        return this.message;
    }

    public void postMessage(String name, String surname)
    {
        System.out.println("This guy needs help! Name: " + name + " Surname: " + surname);
        notifyObserver();
    }

}

class Library_VirusTrackAppBuild extends RawVirusTrackApp implements NativeFramework, LibraryAppObserver
{

    public Library_VirusTrackAppBuild() throws ParseException {
    }

    @Override
    public MobileApp buildForApple() {
        return null;
    }

    @Override
    public MobileApp buildForAndroid() {
        return null;
    }

    @Override
    public MobileApp buildForLibrary() {
        return RawVirusTrackApp.rawApp("Library Virus Track App", "Ministry of Health Systems");
    }

    LibraryReceive receive = new LibraryReceive();
    LibrarySend send = new LibrarySend();

    LibraryFacade lr = new LibraryFacade(receive, send);

    //Observer Part
    private SubjectInterface patients;

    @Override
    public void update() {
        String msg = (String) patients.sendUpdate(this);
        if (msg == null)
        {
            System.out.println(" No new message on this topic!");
        }
        else
        {
            System.out.println(" Retrieving message: " + msg);
        }


    }

    @Override
    public void setPatients(SubjectInterface patients) {

        this.patients = patients;
    }
}

//////////////////////////////////////////////////////////////////////////////////

// Auto.widgets
//      This part represents facade for Library_VirusTrackAppBuild
//      Also we can do to the others but if Time runs out, we will lose.

class LibraryFacade
{
    private LibraryReceive receive;
    private LibrarySend send;

    public LibraryFacade(LibraryReceive receive, LibrarySend send) {
        this.receive = receive;
        this.send = send;
    }

    public void start()
    {
        while(true)
        {

            Scanner sc = new Scanner(System.in);
            int tempMenu = 0;
            System.out.println("Start Receive, Press 1\nStart Send, Press 2");
            tempMenu = sc.nextInt();

            if(tempMenu == 1)
            {
                receive.receive();
            }
            else if (tempMenu == 2)
            {
                send.send();
            }
            else
            {
                System.out.println("Wrong input! please try again...");
            }
        }
    }
}

class LibraryReceive // NOT DONE YET
{
    boolean loopControl = true;

    public void receive()
    {


        while(loopControl)
        {

            

        }
    }
}

class LibrarySend // Done
{
    int age = 0;
    String name = " ", surname = " ", address = " ";
    boolean fewer = false, r_nose = false, m_ache = false;
    int tempSendMenu = 0;

    public void send()
    {



        //Adding new patient to database

        Scanner sc = new Scanner(System.in);

        System.out.println("Name of the Patient");
        name = sc.next();
        System.out.println("Surname of the Patient");
        surname = sc.next();
        System.out.println("Address of the Patient");
        address = sc.next();
        System.out.println("Age of the Patient");
        age = sc.nextInt();


        System.out.println("Fewer? 1 for True, 2 for False");
        tempSendMenu = sc.nextInt();
        if(tempSendMenu == 1 )
        {
            fewer = true;
        }
        else if(tempSendMenu == 2)
        {
            fewer = false;
        }
        else
        {
            System.out.println("Wrong input, DEFAULT FALSE");
        }

        System.out.println("Muscle Ache? 1 for True, 2 for False");
        tempSendMenu = sc.nextInt();
        if(tempSendMenu == 1)
        {
            m_ache = true;
        }
        else if(tempSendMenu == 2)
        {
            m_ache = false;
        }
        else
        {
            System.out.println("Wrong input, DEFAULT FALSE");
        }

        System.out.println("Runny Nose? 1 for True, 2 for False");
        tempSendMenu = sc.nextInt();
        if(tempSendMenu == 1)
        {
            r_nose = true;
        }
        else if (tempSendMenu == 2)
        {
            r_nose = false;
        }
        else
        {
            System.out.println("Wrong input, DEFAULT FALSE");
        }
        patient_db.addNewPatient(virus_track_main.patient_dbs, name, surname, age, address, false, false, false);
    }

}



///////////////////////////////////////////////////////////////////////////////////

//LibraryNotifier.io
//  This part is for Observer Pattern
interface SubjectInterface  //Subject-like
{
    void register(LibraryAppObserver observer);
    void notifyObserver();
    Object sendUpdate(LibraryAppObserver observer);
} //d

interface LibraryAppObserver //Observer
{
    void update();
    void setPatients(SubjectInterface patients);

} //d

/////////////////////////////////////////////////////////////////////////////////////

public class virus_track_main {

    public static ArrayList<patient_db> patient_dbs;

    public static void main(String[] args) throws ParseException, InterruptedException {

        //Aight boys Let's do this

        //Factory example here, Need main for User requests.
        //CellPhone iPhone = new AppleFactory.createApple("Apple", "iPhone 6");
        //CellPhone Galaxy = new SamsungFactory.createSamsung("Samsung", "Galaxy 5");

        //Creating a Database
        patient_dbs = new ArrayList<>();
        patient_dbs = patient_db._createDummyTable();
        //Test User: ali uzun 40 konak

        //Adaptor example here, Need main for User Requests.
        //RawVirusTrackApp VTA_Samsung = new Samsung_VirusTrackAppBuild();
        //RawVirusTrackApp VTA_Library = new Library_VirusTrackAppBuild();
        RawVirusTrackApp VTA_Apple = new Apple_VirusTrackAppBuild();
        RawVirusTrackApp VTA_Library = new Apple_VirusTrackAppBuild();



        // If any patient condition goes true,






        ////////////////////////////////////////////
        //This part is gibberish

        //Need Plots

        //Prologue
        //Meanwhile in Netherland


        //Act 1, Baking and Serving
        //Consumer will buy some phones
        //System.out.println("BestBuy Selling Samsung and Apple");


        //Act 2, Uvid-Strikes-Back
        //Ill people installing app on phone
        //  sending reports



        //Act 3, Health Ministry On Duty

    }


}