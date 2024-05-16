package dat3.stripe.controller;

import dat3.stripe.entity.ChargeRequest;
import dat3.stripe.service.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @Autowired
    private StripeService stripeService;

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 50 * 100); // in øre
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.DKK);

        try {
            String paymentIntentClientSecret = stripeService.createPaymentIntent(50 * 100, "DKK", "pm_card_visa");
            model.addAttribute("paymentIntentClientSecret", paymentIntentClientSecret);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception
        }

        return "checkout";
    }
}
