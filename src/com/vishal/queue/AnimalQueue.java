package com.vishal.queue;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalQueue {

    private Queue<Dog> dogQueue;
    private Queue<Cat> catQueue;
    private int ts;

    public AnimalQueue(){
        ts = 0;
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
    }

    public void enqueue(Animal animal){
        animal.ts = ts++;
        if(animal instanceof Dog){
            dogQueue.offer((Dog)animal);
        }else{
            catQueue.offer((Cat)animal);
        }
    }

    public Animal dequeueAny(){
        if(dogQueue.isEmpty()){
            return dequeueCat();
        }else if(catQueue.isEmpty()){
            return dequeueDog();
        }else if(catQueue.peek().ts < dogQueue.peek().ts){
            return dequeueCat();
        }else{
            return dequeueDog();
        }
    }

    public Animal dequeueDog(){
        if(!dogQueue.isEmpty()){
            return dogQueue.poll();
        }else{
            return null;
        }
    }

    public Animal dequeueCat(){
        if(!catQueue.isEmpty()){
            return catQueue.poll();
        }else{
            return null;
        }
    }

}

abstract class Animal{
    public String name;
    public int ts;
    public Animal(String name){
        this.name = name;
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