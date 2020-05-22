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

    private String NAME;
    private String SURNAME;
    private int AGE;
    private String ADDRESS;
    private boolean tempFEWER;
    private boolean tempM_ACHE;
    private boolean tempR_NOSE;

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public void setSURNAME(String userSURNAME) {
        this.SURNAME = SURNAME;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
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


    public Apple_VirusTrackAppBuild(List<LibraryAppObserver> observers) throws ParseException {
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
    public void register(LibraryAppObserver observer) { //DONE
        if (observer == null) throw new NullPointerException(("No Observer Found"));

        if(!observers.contains(observer))
        {
            observers.add(observer);
        }

    }

    @Override
    public void firstRun() throws InterruptedException {

        System.out.println("(AppleApp)");
        Scanner sc = new Scanner(System.in);

        System.out.println("Name?: ");
        setNAME(sc.next());
        System.out.println("Surname?: ");
        String tempStr = sc.next();
        this.setSURNAME(tempStr);
        System.out.println("Age?: ");
        setAGE(sc.nextInt());
        System.out.println("Address?: ");
        setADDRESS(sc.next());
        sc.nextLine();


        //APPLE SPECIFIQUE
        read();
        write();


        while(true)
        {
            TimeUnit.MINUTES.sleep(5);
            System.out.println("Checking time interval");

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
        if(temp.equalsIgnoreCase("Y") || temp.equalsIgnoreCase("y") )
        {
            setTempFEWER(true);
        }
        else if (temp.equalsIgnoreCase("N") || temp.equalsIgnoreCase("n"))
        {
            setTempFEWER(false);

        }
        else
        {
            System.out.println("Wrong input!");
        }


        System.out.println("Muscle Ache?: (Y)es or (N)o");
        temp = sc.next();
        if(temp.equalsIgnoreCase("Y") || temp.equalsIgnoreCase("y"))
        {
            setTempM_ACHE(true);
        }
        else if (temp.equalsIgnoreCase("N") || temp.equalsIgnoreCase("n"))
        {
            setTempM_ACHE(false);
        }
        else
        {
            System.out.println("Wrong input!");
        }


        System.out.println("Runny Nose?: (Y)es or (N)o");
        temp = sc.next();
        if(temp.equalsIgnoreCase("Y") || temp.equalsIgnoreCase("y") )
        {
            setTempR_NOSE(true);

        }
        else if (temp.equalsIgnoreCase("N") || temp.equalsIgnoreCase("n"))
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
        virus_track_main.lister.updatePatient(this.getNAME(), this.getSURNAME(), this.isTempFEWER(), this.isTempM_ACHE(), this.isTempR_NOSE());


        if(isTempFEWER() || isTempM_ACHE() || isTempR_NOSE())
        {
            //postMessage(this.getNAME(), this.getSURNAME());
        }

    }

    //Subject organs
    private List<LibraryAppObserver> observers;
    private String message;




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
        //System.out.println("This guy needs help! Name: " + name + " Surname: " + surname);
        notifyObserver();
    }

}

//  TO-DO:
//      Samsung_VirusTrackAppBuild
//      Library_VirusTrackAppBuild
//          NEEDED AFTER ADDING CLOCK TIME/DATE AND WRITE FUNCTION

class Android_VirusTrackAppBuild extends RawVirusTrackApp implements NativeFramework, SubjectInterface {

    /*
    public Android_VirusTrackAppBuild(List<LibraryAppObserver> observers) throws ParseException {
        this.observers = observers;
    } //This default constructor is for Matching Super
    */

    public Android_VirusTrackAppBuild() throws ParseException {

    }


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

        System.out.println("(Samsung App)");
        Scanner sc = new Scanner(System.in);

        System.out.println("Name?: ");
        setNAME(sc.next());
        System.out.println("Surname?: ");
        setSURNAME(sc.next());
        System.out.println("Age?: ");
        setAGE(sc.nextInt());
        System.out.println("Address?: ");
        setADDRESS(sc.next());

        //APPLE SPECIFIQUE
        get();
        set();


        while(true)
        {
            TimeUnit.MINUTES.sleep(5);
            System.out.println("Checking time interval");
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
        if(temp.equalsIgnoreCase("Y") || temp.equalsIgnoreCase("y") )
        {
            setTempFEWER(true);
        }
        else if (temp.equalsIgnoreCase("N") || temp.equalsIgnoreCase("n") )
        {
            setTempFEWER(false);

        }
        else
        {
            System.out.println("Wrong input!");
        }


        System.out.println("Muscle Ache?: (Y)es or (N)o");
        temp = sc.next();
        if(temp.equalsIgnoreCase("Y") || temp.equalsIgnoreCase("y") )
        {
            setTempM_ACHE(true);
        }
        else if (temp.equalsIgnoreCase("N")  || temp.equalsIgnoreCase("n") )
        {
            setTempM_ACHE(false);
        }
        else
        {
            System.out.println("Wrong input!");
        }


        System.out.println("Runny Nose?: (Y)es or (N)o");
        temp = sc.next();
        if(temp.equalsIgnoreCase("Y") || temp.equalsIgnoreCase("y") )
        {
            setTempR_NOSE(true);

        }
        else if (temp.equalsIgnoreCase("N") || temp.equalsIgnoreCase("n"))
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

        virus_track_main.lister.updatePatient(this.getNAME(), this.getSURNAME(), this.isTempFEWER(), this.isTempM_ACHE(), this.isTempR_NOSE());

        if(isTempFEWER() || isTempM_ACHE() || isTempR_NOSE())
        {
            //postMessage(this.getNAME(), this.getSURNAME());
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


    public static void receive()
    {
        boolean loopControl = true;

        while(loopControl)
        {


        }

    }

    // We also wanted to add a "You are away from main location, please go home" like notification
    // but the time isn't enough for lazy students.
    public void send()
    {

        //Adding new patient to database
        int tempSendMenu = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Name of the Patient");
        setNAME(sc.next());
        System.out.println("Surname of the Patient");
        setSURNAME(sc.next());
        System.out.println("Address of the Patient");
        setADDRESS(sc.next());
        System.out.println("Age of the Patient");
        setAGE(sc.nextInt());


        System.out.println("Fewer? 1 for True, 2 for False");
        tempSendMenu = sc.nextInt();
        if(tempSendMenu == 1 )
        {
            setTempFEWER(true);
        }
        else if(tempSendMenu == 2)
        {
            setTempFEWER(false);
        }
        else
        {
            System.out.println("Wrong input, DEFAULT FALSE");
            setTempFEWER(false);
        }

        System.out.println("Muscle Ache? 1 for True, 2 for False");
        tempSendMenu = sc.nextInt();
        if(tempSendMenu == 1)
        {

            setTempM_ACHE(true);
        }
        else if(tempSendMenu == 2)
        {

            setTempM_ACHE(false);
        }
        else
        {
            System.out.println("Wrong input, DEFAULT FALSE");
            setTempM_ACHE(false);
        }

        System.out.println("Runny Nose? 1 for True, 2 for False");
        tempSendMenu = sc.nextInt();
        if(tempSendMenu == 1)
        {
            setTempR_NOSE(true);
        }
        else if (tempSendMenu == 2)
        {
            setTempR_NOSE(false);

        }
        else
        {
            setTempR_NOSE(false);
            System.out.println("Wrong input, DEFAULT FALSE");
        }
        //patient_db.addNewPatient(virus_track_main.patient_dbs, getNAME(), getSURNAME(), getAGE(), getADDRESS(), isTempFEWER(), isTempM_ACHE(), isTempR_NOSE());

    }


    //Observing Part
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



///////////////////////////////////////////////////////////////////////////////////

//LibraryNotifier.io
//  This part is for Observer Pattern
interface SubjectInterface   //Subject-like
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

// Main_auto
//      This part represents facade for Main(requester)

class MainFacade
{
    private AppleMainFacade AppleF;
    private AndroidMainFacade AndroidF;
    private LibraryMainFacade LibraryF;

    Apple_VirusTrackAppBuild appleApp; //= virus_track_main.VTA_Apple;
    Android_VirusTrackAppBuild androidApp; //= virus_track_main.VTA_Android;
    Library_VirusTrackAppBuild libraryApp; //

    public MainFacade(RawVirusTrackApp appleApp, RawVirusTrackApp androidApp, RawVirusTrackApp libraryApp, AppleMainFacade appleF, AndroidMainFacade androidF, LibraryMainFacade libraryF)
    {
        //We have to cast as SocketAdapter Implementation to not corrupt our adapter pattern
        //Or myBrain.exe not found (note from Bedirhan)
        this.appleApp = (Apple_VirusTrackAppBuild) appleApp;
        this.androidApp = (Android_VirusTrackAppBuild) androidApp;
        this.libraryApp = (Library_VirusTrackAppBuild) libraryApp;

        this.AppleF = appleF;
        this.AndroidF = androidF;
        this.LibraryF = libraryF;
    }

    public void Start() throws InterruptedException {

        System.out.println("Starting the Virus Tracking App Simulator\n");
        boolean loopControl = true;
        int tempStartMenuInt = 0;

        Scanner sc = new Scanner(System.in);

        while(loopControl)
        {
            System.out.println("\n To start Apple Virus Track App Simulator enter 1\n To start Samsung Virus Track App Simulator press 2\n To start Library Virus Track App Simulator enter 3\n To terminate enter 4 ");
            tempStartMenuInt = sc.nextInt();

            switch(tempStartMenuInt)
            {
                case 1:
                    AppleF.AppleMenu(appleApp);
                    break;

                case 2:
                    AndroidF.AndroidMenu(androidApp);
                    break;

                case 3:
                    LibraryF.LibraryMenu(libraryApp);
                    break;

                case 4:
                    System.out.println("Terminating the Simulator");
                    loopControl = false;
                    break;

                default:
                    System.out.println("Wrong Choice, try again");
                    break;
            }
        }
        //AppleF.AppleMenu(appleApp);
        //AndroidF.AndroidMenu(androidApp);
        //LibraryF.LibraryMenu(libraryApp);
    }


}

class AppleMainFacade
{
    boolean loopControl = true;
    int tempMenu = 0;
    public void AppleMenu(Apple_VirusTrackAppBuild app) throws InterruptedException
    {
        System.out.println("\nWelcome to Virus Track App for Apple\n");
        System.out.println("This has also a AutoStart function, but to try other apps, \nyou have to stop and run again \nI don't know how to trap a signal in Java");
        System.out.println("\nNote: To test, use Name: ali, Surname: uzun, Age: 40, Address: konak\n\n");

        app.firstRun();
    }
}

class AndroidMainFacade
{
    boolean loopControl = true;
    int tempMenu = 0;
    public void AndroidMenu(Android_VirusTrackAppBuild app) throws InterruptedException
    {
        System.out.println("\nWelcome to Virus Track App for Apple\n");
        System.out.println("This has also a AutoStart function, but to try other apps, \nyou have to stop and run again \nI don't know how to trap a signal in Java");
        System.out.println("\nNote: To test, use Name: ali, Surname: uzun, Age: 40, Address: konak\n\n");

        app.firstRun();
    }
}

class LibraryMainFacade
{
    boolean loopControl = true;
    boolean loopSub = true;
    int tempMenu = 0;
    public void LibraryMenu(Library_VirusTrackAppBuild app)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Library part of Virus Track APP");
        while(loopControl)
        {
            System.out.println("Enter 1 to List Menu (receive)\nEnter 2 to add new patient menu (send)\nEnter 3 to exit from Library Simulation ");
            tempMenu = sc.nextInt();
            if(tempMenu == 1)
            {
                System.out.println("List Menu ");
                //app.receive();
                virus_track_main.lister.printMultipleQueries();
            }
            else if(tempMenu == 2)
            {
                System.out.println("New Patient Menu");
                //app.send();
                virus_track_main.lister.addPatient();
            }
            else if(tempMenu == 3)
            {
                System.out.println("Exiting");
                loopControl = false;
            }
            else
            {
                System.out.println("Wrong choice, try again");
            }
        }
    }


}

/////////////////////////////////////////////////////////////////////////////////////
interface iterator
{
    boolean hasNext();

    Object next();
}

class DatabaseIterator implements iterator
{
    ArrayList<PatientClass> patientsList;
    int position = 0;

    public DatabaseIterator(ArrayList<PatientClass> patientsList) {
        this.patientsList = patientsList;
    }

    @Override
    public boolean hasNext() {
        if (position >= patientsList.size() || patientsList.get(position) == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public Object next() {
        PatientClass patient = patientsList.get(position);
        position = position + 1;

        return patient;
    }
}

//////////////////////////////////////////////////////
class Lister //Patient Lister.
{
    patient_db patientDB;

    public Lister(patient_db patientDB)
    {
        this.patientDB = patientDB;
    }

    public void printAll()
    {
        DatabaseIterator databaseIterator = patientDB.createIterator();
        System.out.println("Listing All Patients: ");
        printAll(databaseIterator);
    }

    private void printAll(DatabaseIterator iterator)
    {
        while (iterator.hasNext())
        {
            PatientClass patientsList = (PatientClass)iterator.next();
            System.out.println("Name: " + patientsList.getNAME() + ", Surname: " + patientsList.getSURNAME() + ", Age: " + patientsList.getAGE() + ", Address: " + patientsList.getADDRESS() + ", Fewer: " + patientsList.getFEWER() + ", Muscle Ache:  " + patientsList.getM_ACHE() + ", Runny Nose: " + patientsList.getR_NOSE());

        }
    }

    public void printBetweenAge()
    {
        DatabaseIterator databaseIterator = patientDB.createIterator();
        System.out.println("Listing Ages between 25-60 Patients: ");
        printBetweenAge(databaseIterator);
    }

    private void printBetweenAge(DatabaseIterator iterator)
    {
        while(iterator.hasNext())
        {
            PatientClass patientsList = (PatientClass)iterator.next();
            if(patientsList.getAGE() > 25 && patientsList.getAGE() < 60)
            {
                System.out.println("Name: " + patientsList.getNAME() + ", Surname: " + patientsList.getSURNAME() + ", Age: " + patientsList.getAGE() + ", Address: " + patientsList.getADDRESS() + ", Fewer: " + patientsList.getFEWER() + ", Muscle Ache:  " + patientsList.getM_ACHE() + ", Runny Nose: " + patientsList.getR_NOSE());
            }

        }
    }

    public void printAllAddress()
    {
        DatabaseIterator databaseIterator = patientDB.createIterator();
        System.out.println("Listing all patient addresses: ");
        printAllAddress(databaseIterator);
    }

    private void printAllAddress(DatabaseIterator iterator)
    {
        while(iterator.hasNext())
        {
            PatientClass patientsList = (PatientClass)iterator.next();
            System.out.println(patientsList.getADDRESS());
        }
    }

    public void printTotalPatients()
    {
        DatabaseIterator databaseIterator = patientDB.createIterator();
        System.out.println("Total patient number: ");
        printTotalPatients(databaseIterator);
    }

    private void printTotalPatients(DatabaseIterator iterator)
    {
        int patientCount = 0;

        while(iterator.hasNext())
        {
            patientCount = patientCount + 1;
        }
        System.out.println(patientCount);
    }


    public void printMultipleQueries()
    {
        int queryTemp = 2;
        boolean queryAge = false;
        boolean queryAddress = false;
        boolean queryCount = false;

        DatabaseIterator databaseIterator = patientDB.createIterator();
        Scanner sc = new Scanner(System.in);

        System.out.println("Do you want Age interval between 25-60? To yes press 1, to no press 2");
        queryTemp = sc.nextInt();
        if(queryTemp == 1)
        {
            queryAge = true;
        }
        else if (queryTemp == 2)
        {
            queryAge = false;
        }
        else
        {
            System.out.println("wrong choice, default NO");
        }

        System.out.println("Do you want addresses of the patients? to yes press 1, to no press 2");
        queryTemp = sc.nextInt();
        if(queryTemp == 1)
        {
            queryAddress = true;
        }
        else if (queryTemp == 2)
        {
            queryAddress = false;
        }
        else
        {
            System.out.println("wrong choice, default NO");
        }

        System.out.println("Do you want to count patients? to yes press 1, to yess press 2");
        queryTemp = sc.nextInt();
        if(queryTemp == 1)
        {
            queryCount = true;
        }
        else if (queryTemp == 2)
        {
            queryCount = false;
        }
        else
        {
            System.out.println("wrong choice, default NO");
        }
        printMultipleQueries(databaseIterator, queryAge, queryAddress, queryCount);
    }

    private void printMultipleQueries(DatabaseIterator iterator, boolean age_, boolean address_, boolean count_)
    {
        int patientCount = 0;

        while(iterator.hasNext())
        {
            PatientClass patientsList = (PatientClass)iterator.next();

            if(age_ && address_ && count_)
            {
                System.out.println(patientsList.getAGE() + " " + patientsList.getADDRESS());
                patientCount = patientCount + 1;
            }
            else if (age_ && address_ && !count_)
            {
                System.out.println(patientsList.getAGE() + " " + patientsList.getADDRESS());
            }
            else if (age_ && !address_ && count_)
            {
                System.out.println(patientsList.getAGE());
                patientCount = patientCount + 1;
            }
            else if (age_ && !address_ && !count_)
            {
                System.out.println(patientsList.getAGE());
            }
            else if (!age_ && !address_ && !count_)
            {
                System.out.println("Nothing to show");
            }
            else if (!age_ && address_ && count_)
            {
                System.out.println(patientsList.getADDRESS());
                patientCount = patientCount + 1;
            }
            else if (!age_ && address_ && !count_)
            {
                System.out.println(patientsList.getADDRESS());
            }
            else if (!age_ && !address_ && count_)
            {
                patientCount = patientCount + 1;
            }

            if(patientCount != 0)
            {
                System.out.println("Number of Listed patients " + patientCount);
            }
        }
    }


    public void updatePatient(String NAME, String SURNAME, boolean FEWER, boolean M_ACHE, boolean R_NOSE)
    {
        DatabaseIterator databaseIterator = patientDB.createIterator();
        updatePatient(databaseIterator, NAME, SURNAME, FEWER, M_ACHE, R_NOSE);
    }
    private void updatePatient(DatabaseIterator iterator, String NAME, String SURNAME, boolean FEWER, boolean M_ACHE, boolean R_NOSE)
    {
        while(iterator.hasNext())
        {
            PatientClass patientsList = (PatientClass)iterator.next();

            if(patientsList.getNAME().equalsIgnoreCase(NAME))
            {
                if(patientsList.getSURNAME().equalsIgnoreCase(SURNAME))
                {
                    patientsList.setFEWER(FEWER);
                    patientsList.setM_ACHE(M_ACHE);
                    patientsList.setR_NOSE(R_NOSE);
                }
            }
        }
        System.out.println("Status Updated");
    }

    public void addPatient()
    {
        DatabaseIterator databaseIterator = patientDB.createIterator();
        System.out.println("Adding new patient");
        printTotalPatients(databaseIterator);

    }
    private void addPatient(DatabaseIterator iterator)
    {
        PatientClass patientsList = (PatientClass)iterator.next();
        Scanner sc = new Scanner(System.in);
        while(iterator.hasNext())
        {
            if(!iterator.hasNext())
            {
                System.out.println("Name of the Patient");
                patientsList.setNAME(sc.next());
                System.out.println("Surname of the Patient");
                patientsList.setSURNAME(sc.next());
                System.out.println("Address of the Patient");
                patientsList.setADDRESS(sc.next());
                System.out.println("Age of the Patient");
                patientsList.setAGE(sc.nextInt());

                System.out.println("Fewer? 1 for True, 2 for False");
                int tempSendMenu = sc.nextInt();
                if(tempSendMenu == 1 )
                {
                    patientsList.setFEWER(true);
                }
                else if(tempSendMenu == 2)
                {
                    patientsList.setFEWER(false);
                }
                else
                {
                    System.out.println("Wrong input, DEFAULT FALSE");
                    patientsList.setFEWER(false);
                }

                System.out.println("Muscle Ache? 1 for True, 2 for False");
                tempSendMenu = sc.nextInt();
                if(tempSendMenu == 1)
                {

                    patientsList.setM_ACHE(true);
                }
                else if(tempSendMenu == 2)
                {

                    patientsList.setM_ACHE(false);
                }
                else
                {
                    System.out.println("Wrong input, DEFAULT FALSE");
                    patientsList.setM_ACHE(false);
                }

                System.out.println("Runny Nose? 1 for True, 2 for False");
                tempSendMenu = sc.nextInt();
                if(tempSendMenu == 1)
                {
                    patientsList.setR_NOSE(true);
                }
                else if (tempSendMenu == 2)
                {
                    patientsList.setR_NOSE(false);

                }
                else
                {
                    patientsList.setR_NOSE(false);
                    System.out.println("Wrong input, DEFAULT FALSE");
                }
            }
        }

    }

}


//////////////////////////////////////////////////////////////////////////////////////
public class virus_track_main {

    //public static ArrayList<patient_db> patient_dbs;

    static patient_db patient_dbs;
    static ArrayList patientList;
    static Lister lister;

    //public static RawVirusTrackApp VTA_Apple;
    //public static RawVirusTrackApp VTA_Android;
    //public static RawVirusTrackApp VTA_Library;

    public static void main(String[] args) throws ParseException, InterruptedException {

        //Aight boys Let's do this

        //Factory example here, Need main for User requests.
        //CellPhone iPhone = new AppleFactory.createApple("Apple", "iPhone 6");
        //CellPhone Galaxy = new SamsungFactory.createSamsung("Samsung", "Galaxy 5");

        //Creating a Database with iterator
        //patient_dbs = patient_db._createTable();
        patient_dbs = new patient_db();
        patientList = patient_dbs.getPatientList();
        lister = new Lister(patient_dbs);

        //Adaptor example here, Need main for User Requests.
        //RawVirusTrackApp VTA_Apple = new Apple_VirusTrackAppBuild();
        //RawVirusTrackApp VTA_Android = new Android_VirusTrackAppBuild();
        //RawVirusTrackApp VTA_Library = new Library_VirusTrackAppBuild();


        //First creating different libraries as Observers
        RawVirusTrackApp VTA_Library0 = new Library_VirusTrackAppBuild();
        RawVirusTrackApp VTA_Library1 = new Library_VirusTrackAppBuild();
        RawVirusTrackApp VTA_Library2 = new Library_VirusTrackAppBuild();
        RawVirusTrackApp VTA_Library3 = new Library_VirusTrackAppBuild();


        //Creating for the simulation
        RawVirusTrackApp VTA_Apple = new Apple_VirusTrackAppBuild();
        RawVirusTrackApp VTA_Android = new Android_VirusTrackAppBuild();
        RawVirusTrackApp VTA_Library = new Library_VirusTrackAppBuild();


        //VTA_Apple.register(VTA_Library0);
        //in java, something happened and something not works.
        //Can't use the object part(like VTA_Apple.register()) if multiple implementations of interfaces.
        //Can't show the observer as simulation, Sorry.
        //Because, some parts related to observer pattern is assigned as comment.
        //VTA_Apple.set() > postMessage() & VTA_Android.set > postMessage()
        //Also we tried to extend chain interfaces to implement adapter but is not a solution for us.


        //Need to call Facade part //DONE

        AppleMainFacade appleTest = new AppleMainFacade();
        AndroidMainFacade androidTest = new AndroidMainFacade();
        LibraryMainFacade libraryTest = new LibraryMainFacade();

        MainFacade mf = new MainFacade(VTA_Apple, VTA_Android, VTA_Library, appleTest, androidTest, libraryTest);

        mf.Start();






    }


}


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