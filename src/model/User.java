package model;

import model.strategy.PaymentMethod;

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
        if (!paymentMethod.processPayment(amount, credential)) {
            System.out.println("Transaction failed.");
            return false;
        }

        if (this.balance >= amount) {
            this.balance -= amount;
            recipient.receiveMoney(amount);
            System.out.println(name + " sent " + amount + " to " + recipient.getName());
            return true;
        }
        System.out.println(name + " has insufficient balance for this transaction.");
        return false;
    }

    public synchronized void receiveMoney(double amount) {
        this.balance += amount;
        System.out.println(name + " received " + amount);
    }

    public String getName() {
        return name;
    }
}
