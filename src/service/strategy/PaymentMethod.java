package service.strategy;

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

    // This method can be used for some async delays, bank ack or fraud detection
    protected abstract boolean processPayment(double amount);
}
