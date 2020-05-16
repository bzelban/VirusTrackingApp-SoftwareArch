/*
        Virus Tracking Application




*/

// THE FACTORY
// In here, 2 different factories creating specific phones.
// TO-DO: Add Storage!

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

// The RawAppInc.
// This part ports Raw Native Virus Track app to the specific phone also for d Admins

class MobileApp { //Volt-like
    private String appName; //Currently VirusTracking app
    private String platform; //iOS or Android

    public MobileApp(String appName, String platform) {
        this.appName = appName;
        this.platform = platform;
    }

    public void getApp(String appName, String platform) {

        this.appName = appName;
        this.platform = platform;

        System.out.println(appName + " is Created for " + platform + " phone");
    }

}

class RawVirusTrackApp{ //Socket-like

    public MobileApp rawApp(){
        return new MobileApp("null", "null");
    }

}

interface NativeFramework{ //SocketAdapter-like
    MobileApp buildForApple();
    MobileApp buildForAndroid();

}

class Apple_VirusTrackApp extends RawVirusTrackApp implements NativeFramework {


    @Override
    public MobileApp buildForApple() {
        return getApp("Virus Tracking App", "iOS");
    }

    @Override
    public MobileApp buildForAndroid() {
        return null;
    }

    public read()
    {

    }

    public write() //Write Pushlayacak
    {

    }


}

class Samsung_VirusTrackApp extends RawVirusTrackApp implements NativeFramework {


    @Override
    public MobileApp buildForApple() {
        return getApp("Virus Tracking App", "Android");
    }

    @Override
    public MobileApp buildForAndroid() {
        return null;
    }

    public get()
    {

    }

    public set() //Write Pushlayacak
    {

    }


}

class Admin_VirusTrackApp extends RawVirusTrackApp implements NativeFramework {


    @Override
    public MobileApp buildForApple() {
        return getApp("Admin Virus Tracking App", "Every");
    }

    @Override
    public MobileApp buildForAndroid() {
        return null;
    }

    public receive()
    {

    }

    public send() //Write Pushlayacak
    {

    }


}





///////////////////////////////////////////////////////////////////////////////////



public class virus_track_main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        //Aight boys Let's do this: Leroooooyy JENKIIINNNNNS!

        //Factory example here, Need main for User requests.
        CellPhone iPhone = AppleFactory.createApple("Apple", "iPhone 6");
        CellPhone Galaxy = SamsungFactory.createSamsung("Samsung", "Galaxy 5");



        //Need Plots

        //Prologue
        //Meanwhile in Netherland


        //Act 1, Baking and Serving
        //Consumer will buy some phones
        System.out.println("BestBuy Selling Samsung and Apple");


        //Act 2, Uvid-Strikes-Back
        //Ill people installing app on phone
        //  sending reports



        //Act 3, Health Ministry On Duty













    }
}
