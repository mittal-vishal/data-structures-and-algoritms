package com.vishal.designpattern.decorator.pizza;

public abstract class Toppings implements Pizza {

    protected Pizza pizza;

    public Toppings(Pizza pizza){
        this.pizza = pizza;
    }

}
