package com.vishal.twopointer;

import java.util.HashMap;
import java.util.Map;

public class FourSumTwo {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int firstPair = 0;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                firstPair = nums1[i] + nums2[j];
                numMap.put(firstPair, numMap.getOrDefault(firstPair, 0) + 1);
            }
        }
        int count = 0;
        int secondPair = 0;
        for(int i = 0; i < nums3.length; i++){
            for(int j = 0; j < nums4.length; j++){
                secondPair = -(nums3[i] + nums4[j]);
                if(numMap.containsKey(secondPair)){
                    count += numMap.get(secondPair);
                }
            }
        }
        return count;
    }

}
