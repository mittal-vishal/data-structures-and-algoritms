package com.vishal.arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k < 0){
            k += nums.length;
        }
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end){
        int n = (end - start + 1) / 2;
        for(int i = 0; i < n; i++){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotateBrute(int[] nums, int k) {
        k = k % nums.length;
        if(k < 0){
            k += nums.length;
        }
        int temp = 0;
        for(int i = 0; i < k; i++){
            int prev = nums[nums.length - 1];
            for(int j = 0; j < nums.length; j++){
                temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }

}
