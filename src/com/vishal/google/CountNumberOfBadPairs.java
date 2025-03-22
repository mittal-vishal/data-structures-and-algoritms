package com.vishal.google;

import java.util.HashMap;

public class CountNumberOfBadPairs {

    public long countBadPairs(int[] nums) {
        long goodPairCount = 0;
        int n = nums.length;
        HashMap<Integer,Integer> goodPairOccurance = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(goodPairOccurance.containsKey(i-nums[i])){
                goodPairCount += goodPairOccurance.get(i-nums[i]);
            }
            goodPairOccurance.put(i-nums[i], goodPairOccurance.getOrDefault(i-nums[i], 0) + 1);
        }
        long total = (n*1l*(n-1))/2*1l;
        return total - goodPairCount;
    }

}
