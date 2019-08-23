package com.vishal.bitwise;

public class OddOccuranceNumber {

	public static void main(String[] args) {
		int a[] = {2,3,3,2,3,5,5};
		System.out.println(find(a));
	}

	private static int find(int[] a) {
		int result = 0;
		for(int i : a) {
			result = result ^ i;
		}
		return result;
	}

}
