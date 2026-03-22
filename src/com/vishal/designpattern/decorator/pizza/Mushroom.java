package com.vishal.designpattern.decorator.pizza;

public class Mushroom extends Toppings {

    public Mushroom(Pizza pizza){
        super(pizza);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 1.0;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushroom Added";
    }
}
