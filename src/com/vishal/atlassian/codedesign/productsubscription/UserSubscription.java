package com.vishal.atlassian.codedesign.productsubscription;

import com.vishal.atlassian.codedesign.DiscountStrategy;

import java.time.LocalDate;

public class UserSubscription {

    public String userId;
    public Product product;
    public LocalDate startDate;
    public DiscountStrategy discountStrategy;

    public UserSubscription(String userId, Product product, LocalDate startDate, DiscountStrategy discountStrategy){
        this.userId = userId;
        this.product = product;
        this.startDate = startDate;
        this.discountStrategy = discountStrategy;
    }

}
