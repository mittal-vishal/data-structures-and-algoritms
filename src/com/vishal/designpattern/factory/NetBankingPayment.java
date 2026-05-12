package com.vishal.designpattern.factory;

public class NetBankingPayment implements Payment {

    @Override
    public boolean makePayment(PaymentRequest request) {
        return false;
    }
}
