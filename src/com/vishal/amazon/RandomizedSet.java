package com.vishal.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {

    /** Initialize your data structure here. */
    private HashMap<Integer, Integer> elementIndexMap;
    private ArrayList<Integer> elementList;

    public RandomizedSet() {
        elementIndexMap = new HashMap<>();
        elementList = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!elementIndexMap.containsKey(val)){
            elementIndexMap.put(val, elementList.size());
            elementList.add(elementList.size(), val);
            return true;
        }else{
            return false;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(elementIndexMap.containsKey(val)){
            int index = elementIndexMap.get(val);
            //Delete from map
            elementIndexMap.remove(val);
            //Delete from list
            //Swap with last element
            int lastElement = elementList.get(elementList.size()-1);
            elementList.set(index, lastElement);
            elementList.remove(elementList.size()-1);
            if(elementIndexMap.containsKey(lastElement)){
                elementIndexMap.put(lastElement, index);
            }
            return true;
        }else{
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        return elementList.get(random.nextInt(elementList.size()));
    }
}
