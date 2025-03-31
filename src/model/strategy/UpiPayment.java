package model.strategy;

import model.payment.PaymentDetails;

public class UpiPayment extends PaymentMethod {
    public UpiPayment(PaymentDetails paymentDetails) {
        super(paymentDetails);
    }

    @Override
    protected boolean pay(double amount) {
        // can add some custom logic like mpin check
        System.out.println("Processing Upi payment of: " + amount);
        return true;
    }
}
