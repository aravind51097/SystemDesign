package Abstract_Factory;

public class IndainFactory implements IRegionFactory {

    @Override
    public IPaymentGateway createPaymentGateWay(String type) {
        if (type.equalsIgnoreCase("UPI")) {
            return new UpiPayment();
        } else {
            return new IndiaCarPayment();
        }
    }

}
