package com.vishal.designpattern.decorator.pizza;

public abstract class Discount implements Pizza {

    protected Pizza pizza;

    public Discount(Pizza pizza) {
        this.pizza = pizza;
    }

}
