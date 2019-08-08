package com.vishal.arrays;

public class Wave {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		convertToWave(a, a.length);
	}

	public static void convertToWave(int arr[], int n) {

		for (int i = 0; i < n; i = i + 2) {
			int j = i;
			if (j < n - 2) {
				System.out.print(arr[++j] + " " + arr[i] + " ");
			} else if (j == n - 2) {
				System.out.print(arr[++j] + " " + arr[i]);
			}
		}

		if (n % 2 == 1) {
			System.out.print(arr[n - 1]);
		}

	}

}
