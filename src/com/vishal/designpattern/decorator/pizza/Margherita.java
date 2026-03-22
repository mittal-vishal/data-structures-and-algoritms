package com.vishal.designpattern.decorator.pizza;

public class Margherita implements Pizza{
    @Override
    public double getPrice() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }
}
