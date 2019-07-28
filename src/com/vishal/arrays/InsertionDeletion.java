package com.vishal.arrays;

public class InsertionDeletion {

	public static int[] insertAtEnd(int a[], int item, int currIndex) {
		currIndex = currIndex + 1;
		a[currIndex] = item;
		return a;
	}

	public static int[] insertAtMiddle(int a[], int item, int currIndex, int desiredIndex) {
		if(currIndex < a.length) {
			for (int i = currIndex; i >= desiredIndex; i--) {
				a[i + 1] = a[i];
			}
			a[desiredIndex] = item;
			return a;
		}else {
			return null;
		}
	}

}
