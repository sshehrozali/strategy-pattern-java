package org.strategypattern;

public class CardProvider implements PaymentProcessor {

    @Override
    public int pay(int amount) {
        return 0;
    }

    @Override
    public String getProviderName() {
        return "Card";
    }
}
