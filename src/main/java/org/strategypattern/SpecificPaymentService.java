package org.strategypattern;

public class SpecificPaymentService {
    private final Integer total;
    private final PaymentProcessor paymentProcessor;

    public SpecificPaymentService(Integer total, PaymentProcessor paymentProcessor) {
        this.total = total;
        this.paymentProcessor = paymentProcessor;
    }

    public void process() {
        // call provider
        paymentProcessor.pay(total);
    }
}
