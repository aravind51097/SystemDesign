package Dependency_Injection.Constructor_Injection;

public class EmailNotificationService implements INotificationService {

    @Override
    public void send(String address) {
        System.out.println("Notification sent to " + address);
    }

}
