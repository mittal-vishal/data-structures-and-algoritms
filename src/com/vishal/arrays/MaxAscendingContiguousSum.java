package com.vishal.arrays;

public class MaxAscendingContiguousSum {

    public int maxAscendingSum(int[] nums) {
        int currSum = nums[0];
        int result = currSum;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                currSum += nums[i];
            }else{
                currSum = nums[i];
            }
            result = Math.max(currSum, result);
        }
        return result;
    }

}
