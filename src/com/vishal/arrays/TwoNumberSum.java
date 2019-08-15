package com.vishal.arrays;

public class TwoNumberSum {

	public static void main(String[] args) {
		int a[] = {2, 5, 8, 12, 30};
		System.out.println(find(a, 42));
	}

	private static String find(int[] a, int item) {
		int left = 0; 
		int right = a.length - 1;
		while(left != right) {
			if(a[left] + a[right] == item) {
				return "found";
			}else if(a[left] + a[right] > item) {
				right--;
			}else {
				left++;
			}
		}
		return "not found";
	}

}
