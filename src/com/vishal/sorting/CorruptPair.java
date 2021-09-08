package com.vishal.sorting;

import java.util.Arrays;

public class CorruptPair {

    public static int[] findNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }
        int[] res = new int[2];
        Arrays.fill(res, -1);
        for(int i = 0; i < nums.length; i++){
            if(i != nums[i] - 1){
                res[0] = nums[i];
                res[1] = i + 1;
            }
        }
        return res;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 2};
        findNumbers(nums);
    }

}
