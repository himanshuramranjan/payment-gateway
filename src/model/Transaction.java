package model;

import enums.TransactionStatus;
import service.strategy.PaymentMethod;

public class Transaction {
    private final User sender;
    private final User receiver;
    private final double amount;
    private final PaymentMethod method;
    private TransactionStatus transactionStatus;

    public Transaction(User sender, User receiver, double amount, PaymentMethod method) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.method = method;
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

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public boolean initiatePayment() {
        if(method.processPayment(sender, amount)) {

            sender.deductMoney(amount);

            // maybe we can have a check if this fails then do a rollback
            receiver.receiveMoney(amount);
            return true;
        } else {
            System.out.println("Your transaction failed, no deductions made");
            return false;
        }
    }
}
