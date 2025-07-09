package service.strategy;

import model.payment.PaymentDetails;

public class NetBankingPayment extends PaymentMethod {
    public NetBankingPayment(PaymentDetails paymentDetails) {
        super(paymentDetails);
    }

    @Override
    protected boolean validatePayment(double amount) {
        // can add some custom logic like banking password or some validation
        System.out.println("Processing NetBanking payment of: " + amount);
        return true;
    }
}
