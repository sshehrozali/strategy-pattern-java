package org.strategypattern;

public class PayPalProvider implements PaymentProcessor {

    @Override
    public int pay(int amount) {
        return 0;
    }

    @Override
    public String getProviderName() {
        return "PayPal";
    }
}
