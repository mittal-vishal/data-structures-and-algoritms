package com.vishal.designpattern.factory;

public class CreditCardPayment implements Payment {

    @Override
    public boolean makePayment(PaymentRequest request) {
        return false;
    }
}
