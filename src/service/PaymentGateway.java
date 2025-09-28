package service;

import enums.TransactionStatus;
import model.Transaction;
import model.User;
import service.strategy.PaymentMethod;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PaymentGateway {

    private final Queue<Transaction> transactions;
    private PaymentGateway() {
        transactions = new ConcurrentLinkedQueue<>();
    }

    private static class PaymentGatewayHelper {
        private static final PaymentGateway INSTANCE = new PaymentGateway();
    }
    public static PaymentGateway getInstance() {
        return PaymentGatewayHelper.INSTANCE;
    }

    public synchronized boolean createNewTransaction(User sender, User receiver, double amount, PaymentMethod method) {
        this.transactions.add(new Transaction(sender, receiver, amount, method));
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
                return true;
            }
        }

        if(retryAttempt == 0) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            return false;
        }
        return true;
    }
}
