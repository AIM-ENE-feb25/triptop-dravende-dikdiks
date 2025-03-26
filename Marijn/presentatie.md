
### Encapsulate What Varies 
Definitie: Isoleren van code die waarschijnlijk zal veranderen, zodat deze eenvoudig aangepast kan worden zonder de rest van de applicatie te beïnvloeden.

### Consequenties 
Flexibiliteit
Onderhoud
Herbruikbaarheid
Testbaarheid


``` java

public interface PaymentGateway {
    PaymentResult processPayment(PaymentRequest request);
}


public class PayPalPaymentGateway implements PaymentGateway {
    public PaymentResult processPayment(PaymentRequest request) {
        // logica PayPal API
    }
}

public class StripePaymentGateway implements PaymentGateway {
    public PaymentResult processPayment(PaymentRequest request) {
        // logica Stripe API
    }
}

```

### Gebaseerd op
Open-Closed Principle – Code is open voor uitbreiding, maar gesloten voor wijziging.
Separation of Concerns – Scheiding tussen veranderlijke en stabiele delen.
Single Responsibility Principle  – Elke klasse heeft één duidelijke verantwoordelijkheid.
