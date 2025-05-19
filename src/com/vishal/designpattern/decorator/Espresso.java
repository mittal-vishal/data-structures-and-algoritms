package com.vishal.designpattern.decorator;

public class Espresso implements Coffee{

    @Override
    public double getCost() {
        return 100;
    }

    @Override
    public String getDescription() {
        return "Espresso coffee";
    }

}
