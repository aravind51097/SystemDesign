package Dependency_Injection.Constructor_Injection;

public class UserService {
    private INotificationService notification;

    // Constructor dependency injection , always use interface for scalability and
    // Unit testing will be easy
    public UserService(INotificationService notification) {
        this.notification = notification;
    }

    public void order(String add) {
        System.out.println("Order success ..");
        notification.send(add);
    }
}
