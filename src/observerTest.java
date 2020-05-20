import java.util.ArrayList;
import java.util.List;

//subject registering objects and update them
interface Subject
{
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();
    Object getUpdate(Observer observer);
}


//email topic subscriber
class emailTopic implements Subject {
    private List<Observer> observers;
    private String message;

    public emailTopic() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        if (observer == null) throw new NullPointerException("Null object/Observer");

        if (!observers.contains(observer))
        {
            observers.add(observer);
        }
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);

    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers)
        {
            observer.update();
        }

    }

    @Override
    public Object getUpdate(Observer observer) {
        return this.message;
    }

    public void postMessage(String message)
    {
        System.out.println("Message posted to my topic: " + message);
        this.message = message;
        notifyObservers();
    }
}


//Email topics inherits directiy subject interfaces
class emailTopicSubscriber implements Observer
{
    private String name;

    private Subject topic;

    public emailTopicSubscriber(String name)
    {
        this.name = name;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if (msg == null)
        {
            System.out.println(name + " No new message on this topic!");
        }
        else
        {
            System.out.println(name + " Retrieving message: " + msg);
        }

    }

    @Override
    public void setSubject(Subject subject) {
        this.topic = subject;

    }
}



//observer
interface Observer
{
    void update();
    void setSubject(Subject subject);
}



public class observerTest {

    public static void main(String[] args) {

        emailTopic topic = new emailTopic();

        Observer firstObserver = new emailTopicSubscriber("FirstObserver");
        Observer secondObserver = new emailTopicSubscriber("SecondObserver");
        Observer thirdObserver = new emailTopicSubscriber("ThirdObserver");

        //Registering them to list
        topic.register(firstObserver);
        topic.register(secondObserver);
        topic.register(thirdObserver);

        // attaching observer to subject
        firstObserver.setSubject(topic);
        secondObserver.setSubject(topic);
        thirdObserver.setSubject(topic);

        //check for update
        firstObserver.update();

        //message test
        topic.postMessage("Hi biçuz");
    }
}
