package com.vishal.windowsliding;

public class MaxSubArraySumOfSizeK {

    public static int findMaxSumSubArray(int k, int[] arr) {
        int start = 0, end = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        while(end < arr.length){
            sum += arr[end++];
            if((end - start) == k){
                max = Math.max(max, sum);
                sum -= arr[start++];
            }
        }

        return max;

    }

}
