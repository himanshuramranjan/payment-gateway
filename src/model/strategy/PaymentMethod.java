package model.strategy;

import model.payment.PaymentDetails;

public abstract class PaymentMethod {
    private final PaymentDetails paymentDetails;

    protected PaymentMethod(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public boolean processPayment(double amount, String password) {
        if(this.paymentDetails.authenticate(password)) {
            return pay(amount);
        }
        return false;
    }

    protected abstract boolean pay(double amount);
}
