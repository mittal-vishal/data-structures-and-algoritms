package com.vishal.walmart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequent {

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
