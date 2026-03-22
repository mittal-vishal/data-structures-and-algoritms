package com.vishal.designpattern.decorator.pizza;

public class DoublePepperoni extends Toppings{

    public DoublePepperoni(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 2.0;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Double Pepperoni added";
    }
}
