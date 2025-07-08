package model.factory;

import enums.PaymentType;
import model.payment.PaymentDetails;
import service.strategy.CardPayment;
import service.strategy.NetBankingPayment;
import service.strategy.PaymentMethod;
import service.strategy.UpiPayment;

public class PaymentFactory {
    public PaymentMethod getPaymentMethod(PaymentType paymentType, PaymentDetails paymentDetails) {
        return switch (paymentType) {
            case CARD -> new CardPayment(paymentDetails);
            case UPI -> new UpiPayment(paymentDetails);
            case NET_BANKING -> new NetBankingPayment(paymentDetails);
        };
    }
}
