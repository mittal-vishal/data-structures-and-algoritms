package com.vishal.olacabs;

import java.util.Scanner;

public class MediumOfSortedArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int array1[] = new int[m];
			int array2[] = new int[n];
			for (int j = 0; j < array1.length; j++) {
				array1[j] = sc.nextInt();
			}
			for (int j = 0; j < array2.length; j++) {
				array2[j] = sc.nextInt();
			}
			System.out.println(find(array1, array2));
		}
		sc.close();
	}

	private static int find(int[] array1, int[] array2) {
		int array[] = new int[array1.length + array2.length];
		int m = 0;
		int n = 0;
		for (int k = 0; k < array.length; k++) {
			if ((m < array1.length && n < array2.length && array1[m] <= array2[n])) {
				array[k] = array1[m];
				m++;
			} else if ((m < array1.length && n < array2.length && array2[n] < array1[m])) {
				array[k] = array2[n];
				n++;
			} else if (m < array1.length) {
				array[k] = array1[m];
				m++;
			} else if (n < array2.length) {
				array[k] = array2[n];
				n++;
			}
		}
		if (array.length % 2 == 1) {
			return array[array.length / 2];
		} else {
			return (array[(array.length / 2) - 1] + array[array.length / 2]) / 2;
		}
	}

}
