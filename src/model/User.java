package model;

import service.PaymentGateway;
import service.strategy.PaymentMethod;

public class User {
    private final String userId;
    private final String name;
    private double balance;

    public User(String userId, String name, double balance) {
        this.userId = userId;
        this.name = name;
        this.balance = balance;
    }

    public boolean sendMoney(User recipient, double amount, PaymentMethod paymentMethod) {
        boolean isMoneySent = PaymentGateway.getInstance().createNewTransaction(this, recipient, amount, paymentMethod);

        if (!isMoneySent) {
            System.out.println("Transaction failed due to some issue !!!");
            return false;
        }

        System.out.println(name + " sent " + amount + " to " + recipient.getName());
        return true;
    }

    public synchronized void receiveMoney(double amount) {
        this.balance += amount;
        System.out.println(name + " received " + amount);
    }

    public synchronized boolean deductMoney(double amount) {
        this.balance -= amount;
        System.out.println("Amount deducted from the sender");

        return true;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
}
