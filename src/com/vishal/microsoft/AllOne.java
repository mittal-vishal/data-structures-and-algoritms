package com.vishal.microsoft;

import java.util.*;

public class AllOne {

    /** Initialize your data structure here. */
    private HashMap<String, Integer> countMap;
    private TreeMap<Integer, Set<String>> topFreqMap;

    public AllOne() {
        countMap = new HashMap<>();
        topFreqMap = new TreeMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        // update count map
        int count = countMap.getOrDefault(key, 0) + 1;
        countMap.put(key, count);
        // update freq map
        if(!topFreqMap.containsKey(count)){
            topFreqMap.put(count, new HashSet<>());
        }
        topFreqMap.get(count).add(key);
        if(count > 1){
            topFreqMap.get(count - 1).remove(key);
            if(topFreqMap.get(count - 1).size() == 0){
                topFreqMap.remove(count - 1);
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
        topFreqMap.get(count + 1).remove(key);
        if(topFreqMap.get(count + 1).size() == 0){
            topFreqMap.remove(count + 1);
        }
        if(count > 0){
            if(!topFreqMap.containsKey(count)){
                topFreqMap.put(count, new HashSet<>());
            }
            topFreqMap.get(count).add(key);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(topFreqMap.lastEntry() != null){
            return topFreqMap.lastEntry().getValue().iterator().next();
        }else{
            return "";
        }
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(topFreqMap.firstEntry() != null){
            return topFreqMap.firstEntry().getValue().iterator().next();
        }else{
            return "";
        }
    }
}