package Abstract_Factory;

public class UsFactory implements IRegionFactory {

    @Override
    public IPaymentGateway createPaymentGateWay(String type) {
       if(type.equalsIgnoreCase("paypal")){
        return new PayPalPayment();
       }else{
        return new USCardPayment();
       }
    }
    
}
