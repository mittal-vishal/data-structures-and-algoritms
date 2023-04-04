package com.vishal.arrays;

import java.util.Arrays;

public class MinIncrementToMakeArrayUnique {

    public int minIncrementForUnique(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        Arrays.sort(nums);
        int prev = nums[0];
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            if(prev >= nums[i]){
                count += (prev - nums[i]) + 1;
                prev = nums[i] + (prev - nums[i]) + 1;
            }else{
                prev = nums[i];
            }
        }
        return count;
    }

}
