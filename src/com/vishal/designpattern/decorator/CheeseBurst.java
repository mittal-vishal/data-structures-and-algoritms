package com.vishal.designpattern.decorator;

public class CheeseBurst extends ToppingDecorator{

    private BasePizza basePizza;

    public CheeseBurst(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int getCost() {
        return basePizza.getCost() + 100;
    }
}
