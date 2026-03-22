package com.vishal.designpattern.decorator.pizza;

public class PizzaPosDriver {

    public static void main(String[] args) {
        Pizza pizzaOrdered = new VeggieDelight();
        pizzaOrdered = new ExtraCheese(pizzaOrdered);
        pizzaOrdered = new DoublePepperoni(pizzaOrdered);
        pizzaOrdered = new HappyHourDiscount(pizzaOrdered);
        System.out.println("Order: " + pizzaOrdered.getDescription());
        System.out.println("$" + pizzaOrdered.getPrice());
    }
}
