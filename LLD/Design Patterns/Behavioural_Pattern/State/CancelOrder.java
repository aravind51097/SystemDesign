package Behavioural_Pattern.State;

public class CancelOrder implements IOrderState {
    @Override
    public void next(OrderContext context) {
        context.setState(new CancelOrder());
    }

    @Override
    public void cancel(OrderContext context) {
        if (context.getCurrentStateName() == "OUT_FOR_DELIVERY") {
            System.out.println("Oder cannot be cancelled , please return order ..");
        } else {
            context.setState(new CancelOrder());
            System.out.println("Order cancelled ..");
        }
    }

    @Override
    public String getCurretntState() {
        return "ORDER_CANCELLED";
    }
}
