package com.vishal.google;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    // T(N) ----- O(N)
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = 0;
        HashSet<Integer> numSet = new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }
        for(int i = 0; i < nums.length; i++){
            if(!numSet.contains(nums[i] - 1)){
                int longest = 1;
                int start = nums[i] + 1;
                while(numSet.contains(start)){
                    longest++;
                    start++;
                }
                max = Math.max(max, longest);
            }
        }
        return max;
    }

}
