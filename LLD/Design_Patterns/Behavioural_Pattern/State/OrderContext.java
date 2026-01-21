package Behavioural_Pattern.State;

public class OrderContext {

    private IOrderState currentState;

    public OrderContext() {
        this.currentState = new OrderPlacedState();
    }

    public void setState(IOrderState nextState) {
        this.currentState = nextState;
    }

    public void next() {
        currentState.next(this);
    }

    public void cancel() {
        currentState.cancel(this);
    }

    public String getCurrentStateName() {
        return currentState.getCurretntState();
    }

}
