package com.vishal.amazon;

public class MoveZero {

    public void moveZeroes(int[] nums) {
        int nonZeroIdx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[nonZeroIdx] = nums[i];
                nonZeroIdx++;
            }
        }
        for(int i = nonZeroIdx; i < nums.length; i++){
            nums[i] = 0;
        }
    }

}
