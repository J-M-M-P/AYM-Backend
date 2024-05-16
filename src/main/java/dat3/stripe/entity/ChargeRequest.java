package dat3.stripe.entity;

import lombok.Data;

@Data
public class ChargeRequest {

    public enum Currency {
        EUR, USD, DKK;
    }

    private String description;
    private int amount;
    private Currency currency;
    private String stripeEmail;
    private String stripeToken;
    private String paymentMethod; // Add payment method

}
