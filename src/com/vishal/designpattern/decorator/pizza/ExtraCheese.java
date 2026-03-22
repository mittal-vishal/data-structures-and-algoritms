package com.vishal.designpattern.decorator.pizza;

public class ExtraCheese extends Toppings {

    public ExtraCheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 1.50;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Cheese added";
    }
}
