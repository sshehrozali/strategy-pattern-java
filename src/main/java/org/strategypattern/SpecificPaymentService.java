package org.strategypattern;

public class SpecificPaymentService {

    public SpecificPaymentService() {
    }

    public void process(PaymentRequest request) {
        // get from factory, call payment provider
        PaymentProcessor paymentProcessor = PaymentsFactory.create(request.paymentType());
        paymentProcessor.pay(request.total());
    }
}
