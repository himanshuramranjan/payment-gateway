package model.strategy;

import model.payment.PaymentDetails;

public abstract class PaymentMethod {
    private final PaymentDetails paymentDetails;

    protected PaymentMethod(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public boolean authenticatePayment(double amount, String password) {
        if(this.paymentDetails.authenticate(password)) {
            return processPayment(amount);
        }
        return false;
    }

    protected abstract boolean processPayment(double amount);
}
