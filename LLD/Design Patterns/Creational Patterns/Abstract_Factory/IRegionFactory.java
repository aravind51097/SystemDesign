package Abstract_Factory;

public interface IRegionFactory {
    IPaymentGateway createPaymentGateWay(String type);
}
