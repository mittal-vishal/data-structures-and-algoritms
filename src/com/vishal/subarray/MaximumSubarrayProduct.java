package com.vishal.subarray;

public class MaximumSubarrayProduct {

    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            prefix *= nums[i];
            suffix *= nums[n-i-1];
            result = Math.max(result, Math.max(prefix, suffix));
            if(prefix == 0){
                prefix = 1;
            }
            if(suffix == 0){
                suffix = 1;
            }
        }
        return result;
    }

}
