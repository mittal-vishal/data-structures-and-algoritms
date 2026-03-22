package com.vishal.atlassian.dsa;

import java.util.HashMap;
import java.util.Objects;
import java.util.TreeMap;

/*
* Problem: Max Price Tracker
You are building a system to process a stream of (timestamp, price) updates. Each update represents the price of a stock or asset at a particular timestamp.

🧩 Requirements:
You may receive duplicate timestamps, and timestamps can arrive out of order.

If a timestamp already exists, the new price should override the old one.

At any point, you should be able to query the system to get the maximum price among all current (latest) timestamp-price pairs.

📘 Implement the following operations:
void update(int timestamp, int price)

Adds or updates the price at the given timestamp.

int getMaxPrice()

Returns the current maximum price in the system.

Assumes at least one price has been inserted.
* */
public class MaxPriceTracker {

    // ts:price
    private HashMap<Integer,Integer> timestampPrices;
    //sorted_price:count
    private TreeMap<Integer,Integer> sortedPriceCount;

    public MaxPriceTracker(){
        timestampPrices = new HashMap<>();
        sortedPriceCount = new TreeMap<>();
    }

    public void update(int ts, int price){
        Integer oldPrice = timestampPrices.get(ts);
        if(Objects.nonNull(oldPrice)){
            sortedPriceCount.put(oldPrice, sortedPriceCount.get(oldPrice) - 1);
            if(sortedPriceCount.get(oldPrice) == 0){
                sortedPriceCount.remove(oldPrice);
            }
        }
        timestampPrices.put(ts, price);
        sortedPriceCount.put(price, sortedPriceCount.getOrDefault(price, 0) + 1);
    }

    public int getMaxPrice(){
        return sortedPriceCount.lastKey();
    }

    public static void main(String[] args) {
        MaxPriceTracker tracker = new MaxPriceTracker();
        tracker.update(1, 100);
        tracker.update(2, 200);
        tracker.update(3, 150);
        System.out.println(tracker.getMaxPrice());   // returns 200

        tracker.update(2, 180);  // overrides price at timestamp 2
        System.out.println(tracker.getMaxPrice());   // returns 180

        tracker.update(4, 220);
        System.out.println(tracker.getMaxPrice());    // returns 220
    }
}
