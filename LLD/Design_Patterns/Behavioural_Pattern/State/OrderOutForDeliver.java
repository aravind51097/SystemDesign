package Behavioural_Pattern.State;

public class OrderOutForDeliver implements IOrderState {

    @Override
    public void next(OrderContext context) {
        context.setState(new OrderDelivered());
    }

    @Override
    public void cancel(OrderContext context) {
        if (context.getCurrentStateName() == "OUT_FOR_DELIVERY") {
            System.out.println("Oder cannot be cancelled , please return during delivery ..");
        }
    }

    @Override
    public String getCurretntState() {
        return "OUT_FOR_DELIVERY";
    }
}
