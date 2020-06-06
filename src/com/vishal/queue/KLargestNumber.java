package com.vishal.queue;

import java.util.PriorityQueue;

public class KLargestNumber {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 8, 7, 32, 3, 10 };
		kthLargest(arr, 3);
	}

	public static void kthLargest(int arr[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < k-1; i++) {
			pq.add(arr[i]);
			System.out.print("-1 ");
		}
		pq.add(arr[k-1]);
		System.out.print(pq.peek() + " ");
		for(int i = k; i < arr.length; i++) {
			if(arr[i] > pq.peek()) {
				pq.poll();
				pq.add(arr[i]);
			}
			System.out.print(pq.peek() + " ");
		}
	}


}
