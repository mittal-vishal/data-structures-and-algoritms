package com.vishal.twopointer;

import java.util.Arrays;

public class MinimizeMaximumPairSum {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int pairSum = 0;
        while(left < right){
            pairSum = Math.max(pairSum, nums[left] + nums[right]);
            left++;
            right--;
        }
        return pairSum;
    }

}
