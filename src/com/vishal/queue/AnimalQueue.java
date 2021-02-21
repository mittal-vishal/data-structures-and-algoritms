package com.vishal.queue;

import java.util.LinkedList;

public class AnimalQueue {

    private LinkedList<Dog> dogList = new LinkedList<>();
    private LinkedList<Cat> catList = new LinkedList<>();

    public void enqueue(Animal animal){
        animal.setTs(animal.getTs());
        animal.setTs(animal.getTs() + 1);
        if(animal instanceof Dog){
            dogList.add((Dog)animal);
        }else{
            catList.add((Cat)animal);
        }
    }

    public Animal dequeueAny(){
        if(dogList.size() == 0){
            return dequeueCat();
        }else if(catList.size() == 0){
            return dequeueDog();
        }
        Cat firstCat = catList.peek();
        Dog firstDog = dogList.peek();
        if(firstCat.getTs() < firstDog.getTs()){
            return dequeueCat();
        }else{
            return dequeueDog();
        }
    }

    public Animal dequeueDog(){
        if(!dogList.isEmpty()){
            return dogList.removeFirst();
        }else{
            return null;
        }
    }

    public Animal dequeueCat(){
        if(!catList.isEmpty()){
            return catList.removeFirst();
        }else{
            return null;
        }
    }

}

abstract class Animal{
    protected String name;
    private int ts = 0;
    public Animal(String name){
        this.name = name;
    }
    public int getTs(){
        return ts;
    }
    public void setTs(int ts){
        this.ts = ts;
    }
}

class Dog extends Animal{
    public Dog(String name){
        super(name);
    }
}

class Cat extends Animal{
    public Cat(String name){
        super(name);
    }
}