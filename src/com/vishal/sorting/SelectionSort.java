package com.vishal.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int a[] = {12,3,5,18,25};
		a = sort(a);
		for(int i : a) {
			System.out.print(i + " ");
		}
	}

	private static int[] sort(int[] a) {
		int temp = 0;
		for(int i = 0;i<a.length;i++) {
			int min = i;
			for(int j = i+1;j<a.length;j++) {
				if(a[j] < a[min]) {
					min = j;
				}
			}
			temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
		return a;
	}

}
