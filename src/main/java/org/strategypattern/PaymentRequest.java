package org.strategypattern;

public record PaymentRequest(
        PaymentType paymentType,
        Integer total
) {
}
