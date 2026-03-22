package com.vishal.atlassian.codedesign.productsubscription;

import com.vishal.atlassian.codedesign.DiscountStrategy;

public class NoDiscount implements DiscountStrategy {
    @Override
    public double apply(double originalPrice) {
        return originalPrice;
    }
}
