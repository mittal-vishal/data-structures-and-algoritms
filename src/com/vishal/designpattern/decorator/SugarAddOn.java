package com.vishal.designpattern.decorator;

public class SugarAddOn extends AddOn{

    public SugarAddOn(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 2;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar added as add on";
    }
}
