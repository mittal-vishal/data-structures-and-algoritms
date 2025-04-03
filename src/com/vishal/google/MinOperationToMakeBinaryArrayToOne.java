package com.vishal.google;

public class MinOperationToMakeBinaryArrayToOne {

    public int minOperations(int[] nums) {
        int operations = 0;
        int n = nums.length;
        for(int i = 0; i < n-2; i++){
            if(nums[i] == 0){
                flip(nums, i, i+2);
                operations++;
            }
        }
        if(nums[nums.length-1] == 0 || nums[nums.length-2] == 0){
            return -1;
        }else{
            return operations;
        }
    }

    private void flip(int[] nums, int i, int j){
        for(int k = i; k <= j; k++){
            if(nums[k] == 0){
                nums[k] = 1;
            }else{
                nums[k] = 0;
            }
        }
    }

}
