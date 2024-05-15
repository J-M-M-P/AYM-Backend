package dat3.stripe.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${STRIPE_SECRET_KEY}")
    private String secretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    public String createPaymentIntent(int amount, String currency) throws StripeException {
        Map<String, Object> params = new HashMap<>();
        params.put("amount", amount);
        params.put("currency", currency);

        PaymentIntent intent = PaymentIntent.create(params);
        return intent.getClientSecret();
    }
}
