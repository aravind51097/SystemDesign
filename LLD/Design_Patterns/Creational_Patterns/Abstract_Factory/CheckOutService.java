package Abstract_Factory;

public class CheckOutService {
    private IPaymentGateway paymentGateway;
    private String paymentType;

    public CheckOutService(IRegionFactory fact, String paymentType) {
        this.paymentGateway = fact.createPaymentGateWay(paymentType);
        this.paymentType = paymentType;
    }

    public void completePayment() {
        paymentGateway.makePayment();
    }
}
