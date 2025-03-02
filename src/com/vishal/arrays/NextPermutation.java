package com.vishal.arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int indexToBeSwapped = -1;
        int i = nums.length-2;
        while(i >= 0){
            if(nums[i] < nums[i+1]){
                indexToBeSwapped = i;
                break;
            }
            i--;
        }
        if(indexToBeSwapped != -1){
            i = nums.length-1;
            while(i != indexToBeSwapped){
                if(nums[i] > nums[indexToBeSwapped]){
                    swap(nums, i, indexToBeSwapped);
                    reverse(indexToBeSwapped+1, nums);
                    break;
                }
                i--;
            }
        }else{
            reverse(0, nums);
        }
    }

    private void reverse(int i, int[] nums){
        int left = i;
        int right = nums.length-1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
