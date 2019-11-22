package com.vishal.queue;

import java.util.Deque;
import java.util.LinkedList;

public class MaxOfSubarrayOfSizeK {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
		int k = 3;
		findUsingQueue(arr, k);
	}

	private static void find(int[] arr, int k) {
		int max = 0;
		for(int i=0;i<arr.length;i++){
			max = Integer.MIN_VALUE;
			if((i+k) <= arr.length) {
				for(int j = i; j<(i+k);j++) {
					if(arr[j] > max) {
						max = arr[j];
					}
				}
			}else {
				break;
			}
			System.out.print(max + " ");
		}
	}
	
	private static void findUsingQueue(int[] arr, int k) {
		int max = Integer.MIN_VALUE;
		Deque<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<k;i++) {
			if(arr[i] > max) {
				max = arr[i];
				queue.addFirst(max);
			}else {
				queue.addLast(arr[i]);
			}
		}
		System.out.print(queue.peek() + " ");
		queue.removeLast();
		for(int i=k;i<arr.length;i++){
			if(arr[i] > max) {
				max = arr[i];
				queue.addFirst(max);
			}else {
				queue.addLast(arr[i]);
			}
			System.out.print(queue.peek() + " ");
			queue.removeLast();
		}
	}

}
