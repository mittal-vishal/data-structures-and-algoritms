package com.vishal.hashing;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;

public class DesignHashMap {

    private final int CAPACITY = 1000;
    private LinkedList<Map.Entry<Integer,Integer>>[] buckets;

    public DesignHashMap() {
        buckets = new LinkedList[CAPACITY];
    }

    public void put(int key, int value) {
        int hash = key % CAPACITY;
        if(buckets[hash] == null){
            buckets[hash] = new LinkedList<>();
        }
        if(buckets[hash].size() == 0){
            buckets[hash].add(new AbstractMap.SimpleEntry<>(key,value));
        }
        for(Map.Entry<Integer,Integer> existingEntry: buckets[hash]){
            if(existingEntry.getKey() == key){
                existingEntry.setValue(value);
                return;
            }
        }
        buckets[hash].add(new AbstractMap.SimpleEntry<>(key,value));
    }

    public int get(int key) {
        int hash = key % CAPACITY;
        if(buckets[hash] == null){
            return -1;
        }else{
            for(Map.Entry<Integer,Integer> existingEntry: buckets[hash]){
                if(existingEntry.getKey() == key){
                    return existingEntry.getValue();
                }
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = key % CAPACITY;
        if(buckets[hash] == null){
            return;
        }else{
            for(Map.Entry<Integer,Integer> existingEntry: buckets[hash]){
                if(existingEntry.getKey() == key){
                    buckets[hash].remove(existingEntry);
                    return;
                }
            }
        }
    }

}
