package Structural_Pattern.Adapter;

public class CheckOutService {
    private IPayment payment;

    // Expecting the payment interface
    public CheckOutService(IPayment payment) {
        this.payment = payment;
    }

    public void compeleteOrder() {
        payment.makePayment();
    }
}
