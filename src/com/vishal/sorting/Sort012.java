package com.vishal.sorting;

public class Sort012 {

	public static void main(String[] args) {
		int a[] = {1,0,1,2,0,1,2,1};
		a = sort(a);
		for(int i : a) {
			System.out.print(i + " ");
		}
	}

	private static int[] sort(int[] a) {
		int temp = 0;
		int beg = 0, i = 0, end = a.length-1;
		while(i <= end) {
			switch (a[i]) {
			case 0:
				temp = a[i];
				a[i] = a[beg];
				a[beg] = temp;
				beg++;
				i++;
				break;
			case 1:
				i++;
				break;
			case 2:
				temp = a[i];
				a[i] = a[end];
				a[end] = temp;
				end--;
				break;
			default:
				break;
			}
		}
		return a;
	}

}
