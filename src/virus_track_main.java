/*
        Virus Tracking Application




*/

// THE FACTORY
// In here, 2 different factories creating specific phones.

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
// This part ports Raw Native Virus Track app to the specific phone



///////////////////////////////////////////////////////////////////////////////////



public class virus_track_main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        //Aight boys Let's do this: Leroooooyy JENKIIINNNNNS!

        //Factory example here, Need main for User requests.
        CellPhone iPhone = AppleFactory.createApple("Apple", "iPhone 6");
        CellPhone Galaxy = SamsungFactory.createSamsung("Samsung", "Galaxy 5");


        System.out.println("BestBuy Selling Samsung and Apple");



        System.out.println("Ali wants to buy Samsung phone");











    }
}
