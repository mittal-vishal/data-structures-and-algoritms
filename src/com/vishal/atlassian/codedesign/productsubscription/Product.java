package com.vishal.atlassian.codedesign.productsubscription;

public class Product {

    public String name;
    public double monthlyPrice;
    public int trialInDays;

    public Product(String name, Double monthlyPrice, int trialInDays){
        this.name = name;
        this.monthlyPrice = monthlyPrice;
        this.trialInDays = trialInDays;
    }

}
