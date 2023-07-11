package com.vishal.google;

import java.util.HashMap;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {

    private HashMap<String, TreeMap<Integer,String>> keyTimeMap;

    public TimeBasedKeyValueStore() {
        keyTimeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(keyTimeMap.containsKey(key)){
            TreeMap<Integer, String> timeValue = keyTimeMap.get(key);
            timeValue.put(timestamp, value);
        }else{
            TreeMap<Integer, String> newTimeValue = new TreeMap<>();
            newTimeValue.put(timestamp, value);
            keyTimeMap.put(key, newTimeValue);
        }
    }

    public String get(String key, int timestamp) {
        if(keyTimeMap.containsKey(key)){
            Integer latestTS = keyTimeMap.get(key).floorKey(timestamp);
            if(latestTS == null){
                return "";
            }else{
                return keyTimeMap.get(key).get(latestTS);
            }
        }else{
            return "";
        }
    }

}
