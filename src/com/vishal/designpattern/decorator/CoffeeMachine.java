package com.vishal.designpattern.decorator;

public class CoffeeMachine {

    public static void main(String[] args) {
        Coffee coffee = new Espresso();
        coffee = new MilkAddOn(coffee);
        coffee = new SugarAddOn(coffee);
        System.out.println(coffee.getCost());
        System.out.println(coffee.getDescription());
    }

}
