package com.vishal.microsoft;

import java.util.*;

public class AllOne {

    /** Initialize your data structure here. */
    private HashMap<String, Integer> countMap;
    private TreeMap<Integer, Set<String>> freqMap;

    public AllOne() {
        countMap = new HashMap<>();
        freqMap = new TreeMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        // update count map
        int count = countMap.getOrDefault(key, 0) + 1;
        countMap.put(key, count);
        // update freq map
        if(!freqMap.containsKey(count)){
            freqMap.put(count, new HashSet<>());
        }
        freqMap.get(count).add(key);
        if(freqMap.containsKey(count - 1)){
            freqMap.get(count - 1).remove(key);
            if(freqMap.get(count - 1).size() == 0){
                freqMap.remove(count - 1);
            }
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!countMap.containsKey(key)){
            return;
        }
        //Update count map
        if(countMap.get(key) == 1){
            countMap.remove(key);
        }else{
            countMap.put(key, countMap.get(key) - 1);
        }
        int count = countMap.containsKey(key) ? countMap.get(key) : 0;
        //Update freq map
        freqMap.get(count + 1).remove(key);
        if(freqMap.get(count + 1).size() == 0){
            freqMap.remove(count + 1);
        }
        if(count > 0){
            if(!freqMap.containsKey(count)){
                freqMap.put(count, new HashSet<>());
            }
            freqMap.get(count).add(key);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(freqMap.lastEntry() != null){
            return freqMap.lastEntry().getValue().iterator().next();
        }else{
            return "";
        }
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(freqMap.firstEntry() != null){
            return freqMap.firstEntry().getValue().iterator().next();
        }else{
            return "";
        }
    }
}