import enums.PaymentType;
import model.User;
import service.factory.PaymentFactory;
import model.payment.PaymentDetails;
import model.payment.UpiPaymentDetails;
import service.strategy.PaymentMethod;

public class Main {
    public static void main(String[] args) {

        User alice = new User("U1", "Alice", 1000);
        User bob = new User("U2", "Bob", 500);

        PaymentDetails details = new UpiPaymentDetails("alice@upi", "securepass");
        PaymentMethod method = PaymentFactory.getPaymentMethod(PaymentType.UPI, details);
        alice.sendMoney(bob, 200, method);
    }
}