package com.vishal.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumDistinctPair {

	public List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		List<List<Integer>> resList = new ArrayList<>();
		List<Integer> innerList = null;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i + 1;
			int right = nums.length - 1;
			int target = 0;
			while (left < right) {
				if ((left - i) > 1 && nums[left] == nums[left - 1]) {
					left++;
					continue;
				}
				if ((right < nums.length - 1) && nums[right] == nums[right + 1]) {
					right--;
					continue;
				}
				if (nums[i] + nums[left] + nums[right] == target) {
					innerList = new ArrayList<>();
					innerList.add(nums[i]);
					innerList.add(nums[left]);
					innerList.add(nums[right]);
					left++;
					right--;
					resList.add(innerList);
				} else if (nums[i] + nums[left] + nums[right] < target) {
					left++;
				} else {
					right--;
				}
			}

		}
		return resList;
	}

}
