package service.strategy;

import model.User;
import model.payment.PaymentDetails;

public class UpiPayment extends PaymentMethod {
    public UpiPayment(PaymentDetails paymentDetails) {
        super(paymentDetails);
    }

    @Override
    protected boolean validatePayment(User sender, double amount) {
        // can add some custom logic like mpin check
        System.out.println("Processing Upi payment of: " + amount);
        return sender.getBalance() >= amount;
    }
}
