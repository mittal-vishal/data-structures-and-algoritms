package com.vishal.sorting;

public class Sort012 {

	public void sortColors(int[] nums) {
		int zeroIdx = 0;
		int twoIdx = nums.length - 1;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 0 && i > zeroIdx){
				swap(nums, i, zeroIdx);
				zeroIdx++;
				i--;
			}else if(nums[i] == 2 && i < twoIdx){
				swap(nums, i, twoIdx);
				twoIdx--;
				i--;
			}
		}
	}

	private void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
