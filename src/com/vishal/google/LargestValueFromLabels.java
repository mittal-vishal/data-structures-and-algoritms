package com.vishal.google;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LargestValueFromLabels {

    static class Item{
        int value;
        int label;
        public Item(int value, int label){
            this.value = value;
            this.label = label;
        }
    }
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        if(values == null || values.length == 0 || use_limit == 0 || num_wanted == 0){
            return 0;
        }
        int n = values.length;
        PriorityQueue<Item> itemQueue = new PriorityQueue<>((a, b) -> b.value - a.value);
        for(int i = 0; i < n; i++){
            itemQueue.offer(new Item(values[i], labels[i]));
        }
        Map<Integer, Integer> labelMap = new HashMap<>();
        int maxValue = 0;
        while(num_wanted > 0 && !itemQueue.isEmpty()){
            Item currItem = itemQueue.poll();
            labelMap.put(currItem.label, labelMap.getOrDefault(currItem.label, 0) + 1);
            if(labelMap.get(currItem.label) <= use_limit){
                maxValue += currItem.value;
                num_wanted--;
            }
        }
        return maxValue;
    }

}
