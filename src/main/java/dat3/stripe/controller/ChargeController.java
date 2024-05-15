package dat3.stripe.controller;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
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
        Map<String, String> response = new HashMap<>();
        String clientSecret = stripeService.createPaymentIntent(chargeRequest.getAmount(), chargeRequest.getCurrency().toString());
        response.put("client_secret", clientSecret);
        return response;
    }

}
