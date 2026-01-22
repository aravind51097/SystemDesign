package Structural_Pattern.Facade;

public class TicketService {
    public boolean reserveTicket(String movie) {
        System.out.println("Ticekt reserved for a movie " + movie);
        return true;
    }
}
