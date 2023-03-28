package com.vishal.twopointer;

import java.util.Arrays;

class TripletWithSmallerSum {

    public static int searchTriplets(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                int tripletSum = nums[i] + nums[left] + nums[right];
                if(tripletSum < target){
                    count += (right-left);
                    left++;
                }else{
                    right--;
                }
            }
        }
        return count;
    }
}
