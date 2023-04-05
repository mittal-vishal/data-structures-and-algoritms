package com.vishal.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public int findMaxLengthOptimal(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
        }
        int prefixSum = 0;
        int maxLen = 0;
        Map<Integer, Integer> prefixPosMap = new HashMap<>();
        prefixPosMap.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            if(prefixPosMap.containsKey(prefixSum)){
                maxLen = Math.max(maxLen, i - prefixPosMap.get(prefixSum));
            }
            prefixPosMap.putIfAbsent(prefixSum, i);
        }
        return maxLen;
    }

    public int findMaxLength(int[] nums) {
        int maxRes = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int oneCount = 0, zeroCount = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[j] == 0){
                    zeroCount++;
                }else{
                    oneCount++;
                }
                if(zeroCount == oneCount){
                    maxRes = Math.max(maxRes, (j - i) + 1);
                }
            }
        }
        return maxRes;
    }

}
