package com.vishal.subarray;

public class LongestNiceSubarray {

    public int longestNiceSubarray(int[] nums) {
        int maxLength = 1;
        for(int i = 0; i < nums.length-1; i++){
            int currMask = nums[i];
            for(int j = i+1; j < nums.length; j++){
                if((currMask & nums[j]) != 0){
                    break;
                }else{
                    currMask |= nums[j];
                    maxLength = Math.max(maxLength, (j-i+1));
                }
            }
        }
        return maxLength;
    }

}
