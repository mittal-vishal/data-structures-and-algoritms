package com.vishal.subarray;

public class PrintMaxSubArraySum {
    public int[] maxSubArray(int[] nums) {
        int maxSubarraySum = Integer.MIN_VALUE;
        int currMaxSum = 0;
        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;
        for(int i = 0; i < nums.length; i++){
            if(currMaxSum == 0){
                start = i;
            }
            currMaxSum += nums[i];
            if(currMaxSum > maxSubarraySum) {
                maxSubarraySum = currMaxSum;
                ansStart = start;
                ansEnd = i;
            }
            if(currMaxSum < 0){
                currMaxSum = 0;
            }
        }
        int[] result = {ansStart, ansEnd};
        return result;
    }
}
