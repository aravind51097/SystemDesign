package Structural_Pattern.Adapter;

public class RazorPayAdapter implements IPayment {

    private RazorPayApi razorPayApi;

    public RazorPayAdapter() {
        this.razorPayApi = new RazorPayApi();
    }

    @Override
    public void makePayment() {
        razorPayApi.competetTransaction();
    }

}
