package com.vishal.google;

import java.util.Map;
import java.util.TreeMap;

public class RangeModule {

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(10,20);
        rangeModule.addRange(15,25);
    }
    /*
    [10,20]
    [15,25]
    * */

    private TreeMap<Integer,Integer> ranges;

    public RangeModule() {
        ranges = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Map.Entry<Integer,Integer> leftOverlappedEntry = ranges.floorEntry(left);
        if(leftOverlappedEntry != null && leftOverlappedEntry.getValue() >= left){
            left = leftOverlappedEntry.getKey();
        }
        Map.Entry<Integer,Integer> rightOverlappedEntry = ranges.floorEntry(right);
        if(rightOverlappedEntry != null && rightOverlappedEntry.getValue() > right){
            right = rightOverlappedEntry.getValue();
        }
        ranges.subMap(left, right).clear();
        ranges.put(left, right);
    }

    /**
     [10,20]

     [20,17]

     */

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer,Integer> leftOverlappedEntry = ranges.floorEntry(left);
        if(leftOverlappedEntry != null && leftOverlappedEntry.getValue() >= right){
            return true;
        }else{
            return false;
        }
    }

    /**
     [10,40]
     [15,25]
     */

    public void removeRange(int left, int right) {
        Map.Entry<Integer,Integer> leftOverlappedEntry = ranges.floorEntry(left);
        Map.Entry<Integer,Integer> rightOverlappedEntry = ranges.floorEntry(right);
        if(leftOverlappedEntry != null && leftOverlappedEntry.getValue() > left){
            ranges.put(leftOverlappedEntry.getKey(), left);
        }
        if(rightOverlappedEntry != null && rightOverlappedEntry.getValue() > right){
            ranges.put(right, rightOverlappedEntry.getValue());
        }
        ranges.subMap(left, right).clear();
    }

}
