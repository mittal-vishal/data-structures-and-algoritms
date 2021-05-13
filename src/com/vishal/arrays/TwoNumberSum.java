package com.vishal.arrays;

import java.util.Arrays;

public class TwoNumberSum {

	public static void main(String[] args) {
		int a[] = {2, 5, 8, 12, 30};
		System.out.println(twoSum(a, 42));
	}

	public static int[] twoSum(int[] numbers, int target) {
		Arrays.sort(numbers);
		int left = 0, right = numbers.length - 1;

		int output[] = new int[2];
		Arrays.fill(output, -1);

		while(left < right){
			if(numbers[left] + numbers[right] == target){
				output[0] = left + 1;
				output[1] = right + 1;
				return output;
			}else if(numbers[left] + numbers[right] < target){
				left++;
			}else{
				right--;
			}
		}

		return output;

	}

}
