package com.vishal.windowsliding;

public class MaxSubArraySumOfSizeK {

    public static int findMaxSumSubArray(int k, int[] arr) {
        int max = Integer.MIN_VALUE;
        int left = 0, right = 0;
        int sum = 0;
        while(right < arr.length){
            //Expand the window, untill cond met
            sum += arr[right++];
            //Shrink the window if cond is not satisfying
            if(right - left > k){
                sum -= arr[left++];
            }

            if(right - left == k){
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.print(findMaxSumSubArray(k, arr));
    }

}
