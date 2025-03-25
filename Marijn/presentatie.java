public interface PaymentGateway {
    PaymentResult processPayment(PaymentRequest request);
}


public class PayPalPaymentGateway implements PaymentGateway {
    public PaymentResult processPayment(PaymentRequest request) {
        // Use the PayPal API to process the payment and return a PaymentResult object
        // ...
    }
}

public class StripePaymentGateway implements PaymentGateway {
    public PaymentResult processPayment(PaymentRequest request) {
        // Use the Stripe API to process the payment and return a PaymentResult object
        // ...
    }
}