package service.strategy;

import model.User;
import model.payment.PaymentDetails;

public class NetBankingPayment extends PaymentMethod {
    public NetBankingPayment(PaymentDetails paymentDetails) {
        super(paymentDetails);
    }

    @Override
    protected boolean validatePayment(User sender, double amount) {
        // can add some custom logic like otp validation
        System.out.println("Processing NetBanking payment of: " + amount);
        return sender.getBalance() >= amount;
    }
}
