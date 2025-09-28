package model.payment;

public abstract class PaymentDetails {
    protected String password;

    protected PaymentDetails(String password) {
        this.password = password;
    }

    // details can authenticate based on saved encrypted password and the password provided
    // post fetching the details based on id (or other info)
    public abstract boolean authenticate();
}
