package com.vishal.amazon;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        HashMap<Integer,Double> occurances = new HashMap<>();
        for(int num: nums){
            occurances.put(num, occurances.getOrDefault(num, 0d) + 1d);
        }
        double majorityFactor = nums.length/2d;
        for(Map.Entry<Integer,Double> entry: occurances.entrySet()){
            if(entry.getValue() > majorityFactor){
                return entry.getKey();
            }
        }
        return 0;
    }

}
