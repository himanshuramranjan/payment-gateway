package model.factory;

import enums.PaymentType;
import model.payment.CardPaymentDetails;
import model.payment.PaymentDetails;
import model.payment.UpiPaymentDetails;
import model.strategy.CardPayment;
import model.strategy.NetBankingPayment;
import model.strategy.PaymentMethod;
import model.strategy.UpiPayment;

public class PaymentFactory {
    public PaymentMethod getPaymentMethod(PaymentType paymentType, PaymentDetails paymentDetails) {
        return switch (paymentType) {
            case CARD -> new CardPayment(paymentDetails);
            case UPI -> new UpiPayment(paymentDetails);
            case NET_BANKING -> new NetBankingPayment(paymentDetails);
        };
    }
}
