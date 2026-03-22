package com.vishal.designpattern.decorator.pizza;

public class VeggieDelight implements Pizza {
    @Override
    public double getPrice() {
        return 12;
    }

    @Override
    public String getDescription() {
        return "Veggie Delight Pizza";
    }
}
