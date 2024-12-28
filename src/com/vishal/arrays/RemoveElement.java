package com.vishal.arrays;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int nonEqualElementIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[nonEqualElementIndex++] = nums[i];
            }
        }
        return nonEqualElementIndex;
    }

}
