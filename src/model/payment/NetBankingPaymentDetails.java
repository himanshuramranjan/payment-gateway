package model.payment;

public class NetBankingPaymentDetails extends PaymentDetails {
    private final String bankingId;

    public NetBankingPaymentDetails(String password, String bankingId) {
        super(password);
        this.bankingId = bankingId;
    }

    public String getBankingId() {
        return bankingId;
    }

    @Override
    public boolean authenticate() {
        return true;
    }
}
