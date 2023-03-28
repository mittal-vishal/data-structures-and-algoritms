package com.vishal.twopointer;

import java.util.Arrays;

public class ShortestUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int[] copyArr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            copyArr[i] = nums[i];
        }
        Arrays.sort(copyArr);
        int start = -1;
        int end = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != copyArr[i]){
                start = i;
                break;
            }
        }
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] != copyArr[i]){
                end = i;
                break;
            }
        }
        if(start == -1 || end == -1){
            return 0;
        }
        return end-start+1;
    }

    public int findUnsortedSubarrayOptimal(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //min decreasing element
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                min = Math.min(min, nums[i]);
            }
        }
        //max increasing element
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i] > nums[i+1]){
                max = Math.max(max, nums[i]);
            }
        }
        if(min == Integer.MAX_VALUE && max == Integer.MIN_VALUE){
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        //first element from left which is greater than min decreasing element
        for(; start < nums.length; start++){
            if(nums[start] > min){
                break;
            }
        }
        //first element from right which is lower than max increasing element
        for(; end >= 0; end--){
            if(nums[end] < max){
                break;
            }
        }
        return end - start + 1;
    }

}
