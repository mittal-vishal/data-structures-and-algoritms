package com.vishal.subarray;

public class LargestSum {

	public static void main(String[] args) {
		int arr[] = {-2, -3, 4, -1, -2, 6, 0, -3};
		System.out.println(find(arr));

	}

	private static int find(int[] arr) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(sum + arr[i] <= 0) {
				sum = 0;
			}
			else {
				sum = sum + arr[i];
				if(sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}

}
