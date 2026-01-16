package Structural_Pattern.Adapter;

public class UPIPayment implements IPayment {
    public void makePayment() {
        System.out.println("UPI payment completed ... . ");
    }
}
