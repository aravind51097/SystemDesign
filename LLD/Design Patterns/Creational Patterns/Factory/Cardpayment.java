package Factory;

public class Cardpayment implements PaymentService {

    public String makePayment(){
        return " Card payment successfull";
    }

    public double paymentTotal(){
        
        return 1236.00;

    }
}
