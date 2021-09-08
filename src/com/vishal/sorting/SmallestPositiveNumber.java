package com.vishal.sorting;

public class SmallestPositiveNumber {

    public static int findNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(i + 1 != nums[i]){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {-3, 1, 5, 4, 2};
        int num = findNumber(nums);
        System.out.print(num);
    }

}
