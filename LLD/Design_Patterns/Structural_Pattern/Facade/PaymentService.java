package Structural_Pattern.Facade;

public class PaymentService {
    public boolean makePayment(double price) {
        System.out.println("Payment of :: " + price + " Success");
        return true;

    }

}
