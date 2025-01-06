package com.vishal.arrays;

import java.util.Arrays;

public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int i = 1;
        int j = nums.length-1;
        int[] result = new int[nums.length];
        while(i < nums.length){
            result[i] = nums[j--];
            i += 2;
        }
        i = 0;
        while(i < nums.length){
            result[i] = nums[j--];
            i += 2;
        }
        for(int k = 0; k < result.length; k++){
            nums[k] = result[k];
        }
    }

}
