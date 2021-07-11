package com.vishal.arrays;

public class Duplicate {

    public int findDuplicate(int[] nums) {
        if(nums == null && nums.length < 2){
            return 0;
        }
        int element = -1;
        for(int i = 0; i < nums.length; i++){
            element = Math.abs(nums[i]);
            if(nums[element] < 0){
                return element;
            }else{
                nums[element] = nums[element] * (-1);
            }
        }
        return 0;
    }

}
