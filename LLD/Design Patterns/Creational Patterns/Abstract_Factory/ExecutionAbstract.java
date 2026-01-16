package Abstract_Factory;

public class ExecutionAbstract {
    public static void main(String[] args) {

        CheckOutService checkout = new CheckOutService(new IndainFactory(), "upi");
        System.out.println();
        checkout.completePayment();

    }

}
