package Structural_Pattern.Facade;

class BookMovieTicketService implements IBookingService {
    private PaymentService payment;
    private TicketService ticket;
    private MesseageService message;

    public BookMovieTicketService() {
        this.payment = new PaymentService();
        this.ticket = new TicketService();
        this.message = new MesseageService();

    }

    @Override
    public void bookTicket(String movie, String userId, double price) {
        if (payment.makePayment(price)) {
            if (ticket.reserveTicket(movie)) {
                message.send(userId, movie);

            }
        }

    }

}

public class MovieTicketBookingfacade {

    public static void main(String[] args) {
        BookMovieTicketService bookTicket = new BookMovieTicketService();

        System.out.println();
        bookTicket.bookTicket("Endgame", "Aravind", 20);

    }

}
