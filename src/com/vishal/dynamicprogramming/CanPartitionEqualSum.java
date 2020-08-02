package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CanPartitionEqualSum {
	
	public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 == 1){
            return false;
        }else{
            sum = sum / 2;
        }
        Map<String, Boolean> lookup = new HashMap<>();
        return canPartition(lookup, nums, sum, nums.length - 1);
    }
    
    private boolean canPartition(Map<String, Boolean> lookup, int[] nums, int sum, int n){
        String key = n + "|" + sum;
        if(sum == 0){
            return true;
        }else if(sum < 0 || n < 0){
            return false;
        }else if(lookup.containsKey(key)){
            return lookup.get(key);
        }else if(sum - nums[n] < 0){
            lookup.put(key, canPartition(lookup, nums, sum, n-1));
            return lookup.get(key);
        }else{
            lookup.put(key, canPartition(lookup, nums, sum, n-1) || canPartition(lookup, nums, sum - nums[n], n-1));
            return lookup.get(key);
        }
    }

}
