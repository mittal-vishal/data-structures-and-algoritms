package com.vishal.atlassian.codedesign.productsubscription;

import com.vishal.atlassian.codedesign.DiscountStrategy;

public class PercentageDiscount implements DiscountStrategy {

    private final double percent;

    public PercentageDiscount(double percent){
        this.percent = percent;
    }

    @Override
    public double apply(double originalPrice) {
        return (1 - percent) * originalPrice;
    }

}
