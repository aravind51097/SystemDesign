package Dependency_Injection.Constructor_Injection;

public class DIExecution {
    public static void main(String[] args) {
        INotificationService notify = new EmailNotificationService();

        UserService service = new UserService(notify);

        service.order("Banglore");
    }
}
