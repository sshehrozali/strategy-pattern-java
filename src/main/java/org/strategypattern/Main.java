package org.strategypattern;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        int total = 100;

        // Auto-detection of total amount iterating over all payment providers
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

        // Specific payment processing based on payment mode
        var paymentProcessor = PaymentsFactory.create(PaymentType.CARD);
        var specificPaymentService = new SpecificPaymentService(total, paymentProcessor);

        try {
            specificPaymentService.process();
        } catch (RuntimeException e) {
            System.out.printf("Error: %s", e.getMessage());
        }
    }
}