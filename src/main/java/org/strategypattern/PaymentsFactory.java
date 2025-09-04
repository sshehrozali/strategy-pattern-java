package org.strategypattern;

public class PaymentsFactory {

    public static PaymentProcessor create(PaymentType type) {
        return switch (type) {
            case CARD -> new CardProvider();
            case WALLET -> new WalletProvider();
            case PAYPAL -> new PayPalProvider();

            default -> new CardProvider(); // default
        };
    }
}
