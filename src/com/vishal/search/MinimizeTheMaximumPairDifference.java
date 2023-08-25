package com.vishal.search;

import java.util.Arrays;

public class MinimizeTheMaximumPairDifference {

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int beg = 0;
        int end = nums[nums.length-1] - nums[0];
        int result = end;
        while(beg <= end){
            int guess = beg + (end-beg)/2;
            if(isPossible(nums, p, guess)){
                result = guess;
                end = guess-1;
            }else{
                beg = guess+1;
            }
        }
        return result;
    }

    private boolean isPossible(int[] nums, int p, int threshold){
        int count = 0;
        for(int i = 0; i < nums.length-1; i++){
            if((nums[i+1] - nums[i]) <= threshold){
                count++;
                i++;
            }
        }
        return count >= p;
    }

}
