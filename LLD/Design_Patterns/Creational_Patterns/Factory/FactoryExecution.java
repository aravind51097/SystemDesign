package Factory;

public class FactoryExecution {
    public static void main(String[] args) {

        // Factory execution
        PaymentService upiPayment = PaymentFactory.getPaymentService("Upi");
        System.out.println();
        System.out.println(upiPayment.makePayment() + " :: " + upiPayment.paymentTotal());

    }
}
