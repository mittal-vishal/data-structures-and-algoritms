package com.vishal.arrays;

public class RearrangeSequence {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		rearrange(a);
	}

	private static void rearrange(int[] a) {
		for (int i = 0; i < Math.ceil((double) a.length / 2); i++) {
			System.out.println(a[a.length - (i + 1)]);
			if (i != a.length - (i + 1)) {
				System.out.println(a[i]);
			}
		}
	}

}
