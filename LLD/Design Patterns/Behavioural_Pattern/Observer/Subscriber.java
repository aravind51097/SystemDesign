package Behavioural_Pattern.Observer;


//Oberver who observing the even on channel and notify all subscribers
public interface Subscriber {
    void update(String videoTitle, String name);

    String getName();
}

//Subscriber who subscribed a channel
class EmailSubscriber implements Subscriber {

    private String userName;

    public EmailSubscriber(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String videoTitle, String name) {
        System.out.println("Hi  " + name + " " + videoTitle + " is Uploaded to channel");
    }

    public String getName() {
        return userName;
    }

}
//Subscriber who subscribed a channel
class MobileApp implements Subscriber {
    private String userName;

    public MobileApp(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String videoTitle, String name) {
        System.out.println("Hi  " + name + " " + videoTitle + " is Uploaded to channel");
    }

    public String getName() {
        return userName;
    }

}