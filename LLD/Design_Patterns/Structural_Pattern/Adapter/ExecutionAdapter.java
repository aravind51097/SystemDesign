package Structural_Pattern.Adapter;

public class ExecutionAdapter {
    public static void main(String[] args) {
        CheckOutService checkOut = new CheckOutService(new UPIPayment());
        checkOut.compeleteOrder();
    }
}
