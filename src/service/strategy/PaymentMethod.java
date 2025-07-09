package service.strategy;

import model.payment.PaymentDetails;

public abstract class PaymentMethod {
    private final PaymentDetails paymentDetails;

    protected PaymentMethod(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public boolean processPayment(double amount, String password) {
        if(this.paymentDetails.authenticate(password)) {
            return validatePayment(amount);
        }
        return false;
    }

    // This method can be used for some async delays, bank ack or fraud detection
    protected abstract boolean validatePayment(double amount);
}
