import java.util.List;

class patient implements patientInterface
{

    private List<doctorInterface> observers;
    String message = "Hasta durumu";

    public patient(List<doctorInterface> observers)
    {
        this.observers = observers;
    }

    @Override
    public void register(doctorInterface observer) {
        if(observer == null) throw new NullPointerException("Takipci Doktor Bulunmuyor");

        if(!observers.contains(observer))
        {
            observers.add(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for(doctorInterface observer : observers)
        {
            observer.update();
        }

    }

    @Override
    public Object getUpdate(doctorInterface observer) {
        return this.message;
    }

    public void postMessage(String msg) // bu hasta durumu ile ilgili bildirim atıyor
    {
        System.out.println(msg);
        this.message = msg;
        notifyObservers();
    }
}

interface patientInterface
{
    void register(doctorInterface observer);
    void notifyObservers();

    Object getUpdate(doctorInterface observer);
}


interface doctorInterface
{
    void update();
    void setSubject(patientInterface patientinterface);
}

class doctor implements doctorInterface{

    private String message;

    private patientInterface patient;

    public doctor(String message) {
        this.message = message;
    }

    @Override
    public void update() {
        String msg = (String) patient.getUpdate(this);

        if(msg == null)
        {
            System.out.println("No message");
        }
        else
        {
            System.out.println(msg);
        }
    }

    @Override
    public void setSubject(patientInterface patientinterface) {

    }
}



public class observerTryOut {
}
