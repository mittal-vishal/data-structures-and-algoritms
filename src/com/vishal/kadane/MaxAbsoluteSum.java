package com.vishal.kadane;

public class MaxAbsoluteSum {

    public int maxAbsoluteSum(int[] nums) {
        int positiveSum = 0;
        int negativeSum = 0;
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            int currNum = nums[i];
            positiveSum = Math.max(0, positiveSum + currNum);
            negativeSum = Math.min(0, negativeSum + currNum);
            result = Math.max(result, Math.max(positiveSum, Math.abs(negativeSum)));
        }
        return result;
    }

}
