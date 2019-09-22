package com.vishal.google;

public class SumSubArray {

	public static void main(String[] args) {
		int a[] = { 68, 100, 36, 95, 104, 12, 123, 134 };
		find(a.length, 468, a);
	}

	private static void find(int length, int item, int[] a) {
		int startIndex = 0;
		int lastIndex = 0;
		int totalSum = a[startIndex];
		while(totalSum != item) {
			if (totalSum > item) {
				totalSum = totalSum - a[startIndex];
				startIndex++;
			} else {
				lastIndex++;
				if(lastIndex < length) {
					totalSum = totalSum + a[lastIndex];
				}else {
					break;
				}
			}
		}
		if (totalSum == item) {
			System.out.println((startIndex + 1) + " " + (lastIndex + 1));
		} else {
			System.out.println("-1");
		}
	}

}
