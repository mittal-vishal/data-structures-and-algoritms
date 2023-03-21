package com.vishal.walmart;

import java.util.*;

public class TopKFrequent {

    public int[] topKFrequentUsingHeap(int[] nums, int k) {
        int[] result = new int[k];
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Map<Integer, Integer> occurances = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            occurances.put(nums[i], occurances.getOrDefault(nums[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: occurances.entrySet()){
            maxHeap.offer(entry);
        }
        int index = 0;
        while(k-- > 0){
            result[index++] = maxHeap.poll().getKey();
        }
        return result;
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> occurMap = new HashMap<>();

        for(int num: nums){
            occurMap.put(num, occurMap.getOrDefault(num, 0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(occurMap.entrySet());

        Collections.sort(entryList, (Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) -> e2.getValue() - e1.getValue());

        int index = 0;
        for(Map.Entry<Integer, Integer> entry: entryList){
            if(k-- > 0){
                res[index++] = entry.getKey();
            }
        }
        return res;
    }

}
