package model.payment;

public class UpiPaymentDetails extends PaymentDetails {
    private final String upiId;

    public UpiPaymentDetails(String password, String upiId) {
        super(password);
        this.upiId = upiId;
    }

    public String getUpiId() {
        return upiId;
    }
}
