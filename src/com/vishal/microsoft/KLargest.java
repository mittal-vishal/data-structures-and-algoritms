package com.vishal.microsoft;

import java.util.Arrays;
import java.util.Scanner;

public class KLargest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = sc.nextInt();
			int array[] = new int[n];
			for (int j = 0; j < array.length; j++) {
				array[j] = sc.nextInt();
			}
			int k = sc.nextInt();
			System.out.println(find(array, k));
		}
		sc.close();
	}

	private static int find(int[] array, int k) {
		Arrays.sort(array);
		return array[k-1];
	}

}
