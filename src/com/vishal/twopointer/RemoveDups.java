package com.vishal.twopointer;

public class RemoveDups {

    public static int remove(int[] nums) {
        int index = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDups.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDups.remove(arr));
    }
}
