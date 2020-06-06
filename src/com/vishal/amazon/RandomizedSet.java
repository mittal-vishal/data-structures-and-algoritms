package com.vishal.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

class RandomizedSet {

    /** Initialize your data structure here. */
    private Set<Integer> set;
    private List<Integer> list;
    
    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!set.contains(val)){
            list.add(val);
            set.add(val);
            return true;
        }else{
            return false;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            return true;
        }else{
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if(!set.isEmpty()){
            int rNum = new Random().nextInt(set.size());
            return (int)set.stream().toArray()[rNum];
        }else{
            return -1;
        }
    }
}
