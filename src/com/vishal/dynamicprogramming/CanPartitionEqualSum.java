package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CanPartitionEqualSum {
	
	public boolean canPartition(int[] nums) {
        Map<String, Boolean> map = new HashMap<>();
        int sum = 0;
        for(int num : nums){
            sum = sum + num;
        }
        
        if(sum % 2 == 1){
            return false;
        }else{
            return canPartition(nums, sum/2, nums.length, map);
        }
        
    }
    
    private boolean canPartition(int[] nums, int sum, int n, Map<String, Boolean> map){
        String key = sum + "|" + n;
        if(map.containsKey(key)){
            return map.get(key);
        }
        else if(sum == 0){
            map.put(key, true);
        }else if(n < 1){
            map.put(key, false);
        }else if(sum - nums[n-1] < 0){
            map.put(key, canPartition(nums, sum, n-1, map));
            return map.get(key);
        }else if(canPartition(nums, sum - nums[n-1], n - 1, map) || canPartition(nums, sum, n - 1, map)){
            map.put(key, true);
        }else{
            map.put(key, false);
        }
        return map.get(key);
    }

}
