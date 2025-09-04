package org.strategypattern;

public interface PaymentProcessor {
    int pay(int amount);
    String getProviderName();
}
