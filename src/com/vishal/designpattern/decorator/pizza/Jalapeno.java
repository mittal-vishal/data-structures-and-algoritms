package com.vishal.designpattern.decorator.pizza;

public class Jalapeno extends Toppings{

    public Jalapeno(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 0.75;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Jalapeno added";
    }
}
