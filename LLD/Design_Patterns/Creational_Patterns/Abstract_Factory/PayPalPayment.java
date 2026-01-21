package Abstract_Factory;

public class PayPalPayment implements IPaymentGateway {
    public void makePayment() {
        System.out.println("Payment made via PayPal");
    }
}
