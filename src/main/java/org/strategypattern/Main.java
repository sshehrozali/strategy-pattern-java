package org.strategypattern;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        int total = 100;

        PaymentService paymentService = new PaymentService(total,
                Map.of(
                        "wallet", new WalletProvider(),
                        "card", new CardProvider(),
                        "paypal", new PayPalProvider()
                ));

        try {
            paymentService.process();
        } catch (RuntimeException e) {
            System.out.printf("Error: %s", e.getMessage());
        }
    }
}