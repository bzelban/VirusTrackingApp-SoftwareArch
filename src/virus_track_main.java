/*
        Virus Tracking Application




*/


// THE FACTORY
//In here, Factory is for creating phones and adding to the inventories.

abstract class cellPhone {
    abstract public String displayBrand();
    abstract public String displayModel();
    abstract public void displayAll();
}

class ApplePhone extends cellPhone{
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

class SamsungPhone extends cellPhone{
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

abstract class AppleFactory {
    public static cellPhone cellPhone(String type, String brand, String model)
    {
        if("Apple".equalsIgnoreCase(type))
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

abstract class SamsungFactory{
    public static cellPhone cellPhone(String type, String brand, String mode)
    {
        if("Samsung".equalsIgnoreCase(type))
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



public class virus_track_main {

    public static void virus_track_main(String[] args) {

        System.out.println("OK boys Let's do this.\n Leroooooyy");







    }
}
