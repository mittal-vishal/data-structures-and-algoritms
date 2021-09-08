package com.vishal.sorting;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i && nums[i] < nums.length){
                swap(nums, nums[i], i);
                i--;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
