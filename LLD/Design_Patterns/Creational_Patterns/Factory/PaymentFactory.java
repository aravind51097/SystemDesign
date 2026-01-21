package Factory;

public class PaymentFactory {
    public static PaymentService getPaymentService(String type) {
        if (type.equalsIgnoreCase("UPI")) {
            return new UpiPayment();
        } else {
            return new Cardpayment();
        }
    }

}
