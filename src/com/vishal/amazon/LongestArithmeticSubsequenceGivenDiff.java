package com.vishal.amazon;

import java.util.HashMap;

public class LongestArithmeticSubsequenceGivenDiff {

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
