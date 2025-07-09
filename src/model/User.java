package model;

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

    public synchronized boolean sendMoney(User recipient, double amount, PaymentMethod paymentMethod, String credential) {
        if (this.balance >= amount || !paymentMethod.authenticatePayment(amount, credential)) {
            System.out.println("Transaction failed due to Insufficient balance or some internal issue !!!");
            return false;
        }

        this.balance -= amount;
        System.out.println(name + " sent " + amount + " to " + recipient.getName());
        return true;
    }

    public synchronized void receiveMoney(double amount) {
        this.balance += amount;
        System.out.println(name + " received " + amount);
    }

    public String getName() {
        return name;
    }
}
