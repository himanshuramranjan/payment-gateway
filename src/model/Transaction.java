package model;

import enums.TransactionStatus;
import service.strategy.PaymentMethod;

public class Transaction {
    private final User sender;
    private final User receiver;
    private final double amount;
    private final PaymentMethod method;
    private final String credential;
    private TransactionStatus transactionStatus;

    public Transaction(User sender, User receiver, double amount, PaymentMethod method, String credential) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.method = method;
        this.credential = credential;
        this.transactionStatus = TransactionStatus.PENDING;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public String getCredential() {
        return credential;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public boolean initiatePayment() {
        return this.sender.sendMoney(receiver, amount, method, credential);
    }
}
