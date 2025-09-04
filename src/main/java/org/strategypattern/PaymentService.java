package org.strategypattern;

import java.util.Map;

public class PaymentService {

    private final Integer total;
    private final Map<String, PaymentProcessor> methods;

    public PaymentService(Integer total, Map<String, PaymentProcessor> methods) {
        this.total = total;
        this.methods = methods;
    }

    public void process() {
        int deduct = total; // 100

        // keep deducting amount until it becomes 0
        while (deduct != 0) {
            for (PaymentProcessor paymentProcessor : methods.values()) {
                int remaining = paymentProcessor.pay(deduct);

                // If the primary provider deducts all amount -> remaining: 0, update deduct, end loop
                if (remaining == 0) {
                    System.out.printf("Payment processed successfully! using: %s%n", paymentProcessor.getProviderName());
                    deduct = 0;
                    break;
                }

                // else, deduct remaining amount from provider and move to next
                System.out.printf("Payment processed successfully! using: %s%n", paymentProcessor.getProviderName());
                deduct = remaining;
            }

            System.out.printf("Payment failed to process successfully, remaining amount: %s", deduct);
            throw new RuntimeException("payment_failure");
        }
    }
}
