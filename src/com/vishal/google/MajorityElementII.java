package com.vishal.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> occurance = new HashMap<>();
        for(int num: nums){
            occurance.put(num, occurance.getOrDefault(num,0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: occurance.entrySet()){
            if(entry.getValue() > (nums.length/3d)){
                result.add(entry.getKey());
            }
        }
        return result;
    }

}
