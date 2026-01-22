package Structural_Pattern.Facade;

public class MesseageService {
    void send(String userId, String movie) {
        System.out.println("Hi " + userId + " you have sucessfully booked ticekt for " + movie);
    }
}
