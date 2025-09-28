package service.strategy;

import model.User;
import model.payment.PaymentDetails;

public abstract class PaymentMethod {
    private final PaymentDetails paymentDetails;

    protected PaymentMethod(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public boolean processPayment(User sender, double amount) {
        if(this.paymentDetails.authenticate()) {
            return validatePayment(sender, amount);
        }
        return false;
    }

    // This method can be used for some async delays, bank ack or fraud detection
    protected abstract boolean validatePayment(User sender, double amount);
}
