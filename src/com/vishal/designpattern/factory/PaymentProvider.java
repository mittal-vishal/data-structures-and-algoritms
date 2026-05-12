package com.vishal.designpattern.factory;

public class PaymentProvider {

    public static Payment getPaymentMethod(PaymentType type){
        return switch (type){
            case PaymentType.CREDIT -> new CreditCardPayment();
            case PaymentType.DEBIT -> new DebitCardPayment();
            case NET_BANKING -> new NetBankingPayment();
        };
    }

}
