package com.vishal.subarray;

public class NumberSubarrayProdLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        int prod = 1;
        int count = 0;
        while(right < nums.length){
            prod = prod * nums[right++];
            while(prod >= k){
                prod /= nums[left++];
            }
            count += (right - left);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {10,5,2,6};
        int k = 100;
        System.out.print(numSubarrayProductLessThanK(arr, k));
    }
}
