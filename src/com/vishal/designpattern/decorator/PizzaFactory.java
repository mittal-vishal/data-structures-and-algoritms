package com.vishal.designpattern.decorator;

public class PizzaFactory {

    public static void main(String[] args) {
        //Cheese Burst Farm house
        BasePizza farmhouse =  new CheeseBurst(new FarmHouse());
        System.out.println(farmhouse.getCost());

        //Cheese Burst Farm house with Jalapano
        BasePizza farmhouseWithToppings =  new CheeseBurst(new Jalapano(new FarmHouse()));
        System.out.println(farmhouseWithToppings.getCost());
    }

}
