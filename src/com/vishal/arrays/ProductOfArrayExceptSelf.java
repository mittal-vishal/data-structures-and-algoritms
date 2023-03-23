package com.vishal.arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        int leftProduct = 1;
        for(int i = 1; i < n; i++){
            leftProduct = nums[i-1] * leftProduct;
            left[i] = leftProduct;
        }
        right[n-1] = 1;
        int rightProduct = 1;
        for(int i = n-2; i >= 0; i--){
            rightProduct = nums[i+1] * rightProduct;
            right[i] = rightProduct;
        }
        for(int i = 0; i < n; i++){
            res[i] = left[i] * right[i];
        }
        return res;
    }

}
