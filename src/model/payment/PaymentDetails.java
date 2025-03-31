package model.payment;

public abstract class PaymentDetails {
    protected String password;

    protected PaymentDetails(String password) {
        this.password = password;
    }

    public boolean authenticate(String credential) {
        return this.password.equals(credential);
    }
}
