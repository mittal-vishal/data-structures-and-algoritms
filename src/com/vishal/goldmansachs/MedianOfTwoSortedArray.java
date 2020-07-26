package com.vishal.goldmansachs;

public class MedianOfTwoSortedArray {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] num = new int[nums1.length + nums2.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] <= nums2[j]) {
				num[k++] = nums1[i++];
			} else {
				num[k++] = nums2[j++];
			}
		}
		while (i < nums1.length) {
			num[k++] = nums1[i++];
		}
		while (j < nums2.length) {
			num[k++] = nums2[j++];
		}

		double median = 0;
		
		if (num.length % 2 == 1) {
			double d = num[num.length / 2];
			median = d;
		} else {
			double d1 = num[(num.length / 2) - 1];
			double d2 = num[num.length / 2];
			median = (d1 + d2) / 2;
		}
		return median;
	}

}
