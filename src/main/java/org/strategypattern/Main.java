package org.strategypattern;

import java.util.Map;

import static org.strategypattern.PaymentType.CARD;

public class Main {
    public static void main(String[] args) {

        int total = 100;

        // Auto-detection of total amount iterating over all payment providers (strategy pattern)
        var autoPaymentService = new AutoPaymentService(total,
                Map.of(
                        "wallet", new WalletProvider(),
                        "card", new CardProvider(),
                        "paypal", new PayPalProvider()
                ));

        try {
            autoPaymentService.process();
        } catch (RuntimeException e) {
            System.out.printf("Error: %s", e.getMessage());
        }

        // Specific payment processing based on payment mode (factory + strategy pattern)
        var specificPaymentService = new SpecificPaymentService();

        try {
            specificPaymentService.process(new PaymentRequest(CARD, 100));
        } catch (RuntimeException e) {
            System.out.printf("Error: %s", e.getMessage());
        }
    }
}