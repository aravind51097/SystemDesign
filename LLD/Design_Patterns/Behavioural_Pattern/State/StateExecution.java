package Behavioural_Pattern.State;

public class StateExecution {
    public static void main(String[] args) {

        OrderContext order = new OrderContext();
        System.out.println(order.getCurrentStateName());

        order.next(); // shold be order Picked up

        System.out.println(order.getCurrentStateName());

        order.next(); // OutForDelover
        order.cancel();
        System.out.println(order.getCurrentStateName());

        order.next(); // Order Dilevired
        System.out.println(order.getCurrentStateName());

    }
}
