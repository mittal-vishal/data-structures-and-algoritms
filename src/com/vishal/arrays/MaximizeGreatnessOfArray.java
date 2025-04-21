package com.vishal.arrays;

import java.util.TreeMap;

public class MaximizeGreatnessOfArray {

    public int maximizeGreatness(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        int greatness = 0;
        for(int num: nums){
            Integer higherKey = map.higherKey(num);
            if(higherKey == null){
                continue;
            }
            if(higherKey > num){
                map.put(higherKey, map.get(higherKey) - 1);
                if(map.get(higherKey) == 0){
                    map.remove(higherKey);
                }
                greatness++;
            }
        }
        return greatness;
    }

}
