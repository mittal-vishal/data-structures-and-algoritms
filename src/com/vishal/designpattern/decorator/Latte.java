package com.vishal.designpattern.decorator;

public class Latte implements Coffee{
    @Override
    public double getCost() {
        return 120;
    }

    @Override
    public String getDescription() {
        return "Latte Coffee";
    }
}
