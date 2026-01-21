package Abstract_Factory;

public class UpiPayment implements IPaymentGateway {

    @Override
    public void makePayment() {
        System.out.println("UPI Payment made");
    }

}
