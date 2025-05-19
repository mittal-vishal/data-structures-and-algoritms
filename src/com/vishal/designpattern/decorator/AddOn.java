package com.vishal.designpattern.decorator;

public abstract class AddOn implements Coffee{

    protected Coffee coffee;

    public AddOn(Coffee coffee){
        this.coffee = coffee;
    }
}
