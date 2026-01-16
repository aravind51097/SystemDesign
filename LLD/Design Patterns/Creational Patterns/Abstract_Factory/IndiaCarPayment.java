package Abstract_Factory;

public class IndiaCarPayment implements IPaymentGateway {
    public void makePayment() {
        System.out.println("Inidan card payement Done ");
    }
}
