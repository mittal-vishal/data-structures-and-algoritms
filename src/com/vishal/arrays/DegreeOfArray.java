package com.vishal.arrays;

import java.util.HashMap;

public class DegreeOfArray {

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> frequency = new HashMap<>();
        int n = nums.length;
        int degree = 0;
        HashMap<Integer,Integer> lastPosition = new HashMap<>();
        int minLength = 0;
        for(int i = 0; i < n; i++){
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
            lastPosition.putIfAbsent(nums[i], i);
            if(frequency.get(nums[i]) > degree){
                degree = frequency.get(nums[i]);
                minLength = i - lastPosition.get(nums[i]) + 1;
            }else if(frequency.get(nums[i]) == degree){
                minLength = Math.min(minLength, i - lastPosition.get(nums[i]) + 1);
            }
        }
        return minLength;
    }

}
