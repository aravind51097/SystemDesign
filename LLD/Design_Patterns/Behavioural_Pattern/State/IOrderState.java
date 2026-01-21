package Behavioural_Pattern.State;

public interface IOrderState {
    void next(OrderContext context);
    void cancel(OrderContext context);
    String getCurretntState();
    
}
