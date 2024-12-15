package com.vishal.designpattern.decorator;

public class Jalapano extends ToppingDecorator{

    private BasePizza basePizza;

    public Jalapano(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int getCost() {
        return basePizza.getCost() + 20;
    }
}
