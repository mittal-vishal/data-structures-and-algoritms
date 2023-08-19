package com.vishal.amazon;

import java.util.HashMap;

public class LongestArithmeticSubsequence {

    public int longestArithSeqLength(int[] nums) {
        int min = 0;
        int max = 0;
        for(int num: nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int result = 0;
        int diff = max-min;
        for(int i = -diff; i <= diff; i++){
            int currResult = longestSubsequence(nums, i);
            result = Math.max(result, currResult);
        }
        return result;
    }

    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int result = 1;
        for(int i = 0; i < arr.length; i++){
            int currentAP = arr[i]-difference;
            int prevLength = map.containsKey(currentAP)? map.get(currentAP): 0;
            result = Math.max(result, prevLength+1);
            map.put(arr[i], prevLength+1);
        }
        return result;
    }

}
