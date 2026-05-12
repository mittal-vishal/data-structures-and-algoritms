package com.vishal.designpattern.factory;

public class PaymentClient {

    public static void main(String[] args) {
        PaymentRequest request = new PaymentRequest();
        PaymentType type = request.getPaymentType();
        Payment payment = PaymentProvider.getPaymentMethod(type);
        payment.makePayment(request);
    }

}
