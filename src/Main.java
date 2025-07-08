import enums.PaymentType;
import model.User;
import model.factory.PaymentFactory;
import model.payment.PaymentDetails;
import model.payment.UpiPaymentDetails;
import service.strategy.PaymentMethod;
import service.PaymentGateway;

public class Main {
    public static void main(String[] args) {

        User alice = new User("U1", "Alice", 1000);
        User bob = new User("U2", "Bob", 500);
        PaymentGateway gateway = PaymentGateway.getInstance();

        PaymentFactory factory = new PaymentFactory();
        PaymentDetails details = new UpiPaymentDetails("alice@upi", "securepass");
        PaymentMethod method = factory.getPaymentMethod(PaymentType.UPI, details);
        gateway.addNewTransaction(alice, bob, 200, method, "securepass");
    }
}