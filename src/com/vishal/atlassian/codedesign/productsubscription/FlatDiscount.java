package com.vishal.atlassian.codedesign.productsubscription;

import com.vishal.atlassian.codedesign.DiscountStrategy;

public class FlatDiscount implements DiscountStrategy {

    private int flatDiscountPrice;

    public FlatDiscount(int flatDiscountPrice){
        this.flatDiscountPrice = flatDiscountPrice;
    }

    @Override
    public double apply(double originalPrice) {
        return Math.max(0, originalPrice - flatDiscountPrice);
    }
}
