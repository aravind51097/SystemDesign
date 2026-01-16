package Factory;

public class UpiPayment implements PaymentService {

    public String makePayment() {
        return "UPI payment successfull";
    }

    public double paymentTotal() {

        return 3000.00;

    }

}
