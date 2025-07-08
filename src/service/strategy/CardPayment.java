package model.strategy;

import model.payment.PaymentDetails;

public class CardPayment extends PaymentMethod {
    public CardPayment(PaymentDetails paymentDetails) {
        super(paymentDetails);
    }

    @Override
    protected boolean processPayment(double amount) {
        // can add some custom logic like otp validation or something
        System.out.println("Processing Card payment of: " + amount);
        return true;
    }
}
