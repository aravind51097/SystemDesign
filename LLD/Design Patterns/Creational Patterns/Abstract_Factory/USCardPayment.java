package Abstract_Factory;

public class USCardPayment implements IPaymentGateway {
    public void makePayment() {
        System.out.println("US Card payment done ");
    }
}
