package Behavioural_Pattern.State;

public class OrderPickedUpState implements IOrderState {

    @Override
    public void next(OrderContext context) {
        context.setState(new OrderOutForDeliver());
    }

    @Override
    public void cancel(OrderContext context) {
        if (context.getCurrentStateName() == "OUT_FOR_DELIVERY") {
            System.out.println("Oder cannot be cancelled , please return order ..");
        } else {
            context.setState(new CancelOrder());
            System.out.println("order cancelled ");
        }
    }

    @Override
    public String getCurretntState() {
        return "ORDER_PICKED_UP";
    }

}
