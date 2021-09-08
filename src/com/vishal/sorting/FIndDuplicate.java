package com.vishal.sorting;

public class FIndDuplicate {

    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 != i){
                return nums[i];
            }
        }

        return -1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
