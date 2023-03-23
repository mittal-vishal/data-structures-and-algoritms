package com.vishal.subarray;

public class MaximumSubarrayProduct {

    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int currProduct = 1;
        for(int i = 0; i < nums.length; i++){
            currProduct *= nums[i];
            res = Math.max(res, currProduct);
            if(currProduct == 0){
                currProduct = 1;
            }
        }
        currProduct = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            currProduct *= nums[i];
            res = Math.max(res, currProduct);
            if(currProduct == 0){
                currProduct = 1;
            }
        }
        return res;
    }

}
