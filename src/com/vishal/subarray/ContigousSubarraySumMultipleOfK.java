package com.vishal.subarray;

import java.util.HashMap;

public class ContigousSubarraySumMultipleOfK {

    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> remainderIndex = new HashMap<>();
        int currSum = 0;
        remainderIndex.put(0,-1);
        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
            int remainder = currSum % k;
            if(remainderIndex.containsKey(remainder) && i - remainderIndex.get(remainder) > 1){
                return true;
            }else if(!remainderIndex.containsKey(remainder)){
                remainderIndex.put(remainder, i);
            }
        }
        return false;
    }

}
