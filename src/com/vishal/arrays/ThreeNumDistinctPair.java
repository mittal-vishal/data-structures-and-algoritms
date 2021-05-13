package com.vishal.arrays;

import java.util.*;

public class ThreeNumDistinctPair {

	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> tripletSet = new HashSet<>();
		if(nums == null || nums.length == 0) {
			return new ArrayList<>(tripletSet);
		}
		Arrays.sort(nums);
		int firstNum = 0, left = 0, right = 0;
		for(int i = 0; i < nums.length - 2; i++) {
			firstNum = nums[i];
			left = i + 1;
			right = nums.length - 1;
			while(left < right){
				if(firstNum + nums[left] + nums[right] == 0){
					tripletSet.add(Arrays.asList(firstNum, nums[left], nums[right]));
					left++; right--;
				}else if(firstNum + nums[left] + nums[right] < 0){
					left++;
				}else{
					right--;
				}
			}

		}
		return new ArrayList(tripletSet);
	}

}
