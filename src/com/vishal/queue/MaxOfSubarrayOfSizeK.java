package com.vishal.queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxOfSubarrayOfSizeK {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 1, 2, 0, 5 };
		int k = 3;
		findUsingQueue(arr, k);
	}

	private static void find(int[] arr, int k) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Integer.MIN_VALUE;
			if ((i + k) <= arr.length) {
				for (int j = i; j < (i + k); j++) {
					if (arr[j] > max) {
						max = arr[j];
					}
				}
			} else {
				break;
			}
			System.out.print(max + " ");
		}
	}

	private static void findUsingQueue(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}
		System.out.print(pq.peek() + " ");
		for (int i = 0; i < arr.length - k; i++) {
			pq.remove(arr[i]);
			pq.add(arr[i + k]);
			System.out.print(pq.peek() + " ");
		}
	}

}
