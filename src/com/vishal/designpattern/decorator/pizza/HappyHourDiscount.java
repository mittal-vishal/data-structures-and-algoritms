package com.vishal.designpattern.decorator.pizza;

public class HappyHourDiscount extends Discount {

    public HappyHourDiscount(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() - (0.10 * pizza.getPrice());
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Happy Hour discount applied";
    }
}
