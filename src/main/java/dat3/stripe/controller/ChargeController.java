package dat3.stripe.controller;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import dat3.stripe.entity.ChargeRequest;
import dat3.stripe.service.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ChargeController {

    @Autowired
    private StripeService stripeService;

    @PostMapping("/create-payment-intent")
    public Map<String, String> createPaymentIntent(@RequestBody ChargeRequest chargeRequest) throws StripeException {
        PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                .setAmount((long) chargeRequest.getAmount())
                .setCurrency(chargeRequest.getCurrency().toString())
                .setPaymentMethod(chargeRequest.getPaymentMethod()) // Set payment method
                .setConfirm(true) // Confirm the payment intent immediately
                .build();
        PaymentIntent paymentIntent = PaymentIntent.create(createParams);

        Map<String, String> response = new HashMap<>();
        response.put("client_secret", paymentIntent.getClientSecret()); // Get the client secret
        return response;
    }


}
