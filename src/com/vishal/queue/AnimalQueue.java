package com.vishal.queue;

import java.util.LinkedList;

public class AnimalQueue {

    private LinkedList<Dog> dogList = new LinkedList<>();
    private LinkedList<Cat> catList = new LinkedList<>();
    private int ts = 0;

    public void enqueue(Animal animal){
        animal.setTs(ts++);
        if(animal instanceof Dog){
            dogList.add((Dog)animal);
        }else{
            catList.add((Cat)animal);
        }
    }

    public Animal dequeueAny(){
        if(!dogList.isEmpty() && (dogList.peek().getTs() < catList.peek().getTs())){
            return dogList.removeFirst();
        }else{
            return catList.removeFirst();
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
    String name;
    int ts;
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
    String name;
    public Dog(String name){
        super(name);
    }
}

class Cat extends Animal{
    String name;
    public Cat(String name){
        super(name);
    }
}