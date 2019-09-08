package com.vishal.amazon;

public class InversionDuringSorting {

	private static int count = 0;

	public static void main(String[] args) {
		int a[] = { 2, 4, 1, 3, 5 };
		find(a);
	}

	private static void find(int[] a) {
		sort(a, 0, a.length - 1);
		System.out.println(count);
	}

	private static void sort(int[] a, int beg, int end) {
		if (beg < end) {
			int mid = (beg + end) / 2;
			sort(a, beg, mid);
			sort(a, mid + 1, end);
			merge(a, beg, mid, end);
		}
	}

	private static void merge(int[] a, int beg, int mid, int end) {
		int i = beg, j = mid + 1, k = beg;
		int temp[] = new int[a.length];

		for (int l = beg; l <= end; l++) {
			temp[l] = a[l];
		}

		while (i <= mid && j <= end) {
			if (temp[i] <= temp[j]) {
				a[k] = temp[i];
				i++;
				k++;
			} else {
				count = count + (j - i);
				a[k] = temp[j];
				j++;
				k++;
			}
		}

		while (i <= mid) {
			a[k] = temp[i];
			i++;
			k++;
		}

		while (j <= end) {
			a[k] = a[j];
			j++;
			k++;
		}
	}

}
