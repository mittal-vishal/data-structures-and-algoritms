package com.vishal.designpattern.decorator;

public class MilkAddOn extends AddOn {
    public MilkAddOn(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 5;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk added as addon";
    }
}
