package com.vishal.designpattern.factory;

public class DebitCardPayment implements Payment {

    @Override
    public boolean makePayment(PaymentRequest request) {
        return false;
    }
}
