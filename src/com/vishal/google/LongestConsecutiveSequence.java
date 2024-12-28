package com.vishal.google;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for(int num: nums){
            numbers.add(num);
        }
        int longest = 0;
        for(int i = 0; i < nums.length; i++){
            int currNum = nums[i];
            if(!numbers.contains(currNum-1)){
                int count = 1;
                while(true){
                    currNum++;
                    if(numbers.contains(currNum)){
                        count++;
                    }else{
                        break;
                    }
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

}
