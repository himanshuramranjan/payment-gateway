package service;

import enums.TransactionStatus;
import model.Transaction;
import model.User;
import model.strategy.PaymentMethod;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PaymentGateway {

    private static volatile PaymentGateway paymentGateway;
    private final Queue<Transaction> transactions;
    private PaymentGateway() {
        transactions = new ConcurrentLinkedQueue<>();
    };

    public static PaymentGateway getInstance() {
        if(paymentGateway == null) {
            synchronized (PaymentGateway.class) {
                if(paymentGateway == null) {
                    paymentGateway = new PaymentGateway();
                }
            }
        }
        return paymentGateway;
    }

    public boolean addNewTransaction(User sender, User receiver, double amount, PaymentMethod method, String credential) {
        this.transactions.add(new Transaction(sender, receiver, amount, method, credential));
        return processTransaction();
    }

    private synchronized boolean processTransaction() {
        int retryAttempt = 3; // can be saved in Config
        Transaction transaction = transactions.poll();
        while(retryAttempt > 0) {
            if(!transaction.initiatePayment()) {
                retryAttempt--;
            } else {
                transaction.setTransactionStatus(TransactionStatus.SUCCESS);
            }
        }

        if(retryAttempt == 0) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            return false;
        }
        return true;
    }
}
