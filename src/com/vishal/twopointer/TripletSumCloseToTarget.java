package com.vishal.twopointer;

import java.util.Arrays;

class TripletSumCloseToTarget {

    public static int searchTriplet(int[] nums, int target) {
        Arrays.sort(nums);
        int tripletSum = 0;
        int closest = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                tripletSum = nums[i] + nums[left] + nums[right];
                if(tripletSum == target){
                    return tripletSum;
                }
                if(Math.abs(target - tripletSum) < Math.abs(closest)){
                    closest = target - tripletSum;
                }
                if(tripletSum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return target - closest;
    }
}
