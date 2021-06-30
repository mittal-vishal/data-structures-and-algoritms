package com.vishal.twopointer;

import java.util.Arrays;

class TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int left = -1, right = -1;
        int closest = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < arr.length - 2; i++){
            left = i + 1;
            right = arr.length - 1;
            while(left < right){
                sum = arr[i] + arr[left] + arr[right];
                if(sum == targetSum){
                    return sum;
                }
                if(Math.abs(sum - targetSum) < closest){
                    closest = Math.abs(sum - targetSum);
                }
                if(sum < targetSum){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return targetSum - closest;
    }
}
