package model.payment;

import java.time.LocalDate;

public class CardPaymentDetails extends PaymentDetails {
    private final String cardNumber;
    private final String cvv;
    private final LocalDate expiryDate;

    public CardPaymentDetails(String password, String cardNumber, String cvv, LocalDate expiryDate) {
        super(password);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean authenticate() {
        return true;
    }
}
