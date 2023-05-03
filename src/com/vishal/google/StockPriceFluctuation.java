package com.vishal.google;

import java.util.HashMap;
import java.util.TreeMap;

public class StockPriceFluctuation {

    private HashMap<Integer,Integer> tsPriceMap;
    private TreeMap<Integer,Integer> priceFreqMap;
    private int latestTs;

    public StockPriceFluctuation() {
        this.tsPriceMap = new HashMap<>();
        this.priceFreqMap = new TreeMap<>();
        this.latestTs = 0;
    }

    public void update(int timestamp, int price) {
        latestTs = Math.max(timestamp, latestTs);
        Integer prevPrice = tsPriceMap.containsKey(timestamp) ? tsPriceMap.get(timestamp): null;
        tsPriceMap.put(timestamp, price);
        if(prevPrice != null && priceFreqMap.get(prevPrice) > 1){
            priceFreqMap.put(prevPrice, priceFreqMap.get(prevPrice) - 1);
        }else if(prevPrice != null){
            priceFreqMap.remove(prevPrice);
        }
        priceFreqMap.put(price, priceFreqMap.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return tsPriceMap.get(latestTs);
    }

    public int maximum() {
        return priceFreqMap.lastKey();
    }

    public int minimum() {
        return priceFreqMap.firstKey();
    }

}
