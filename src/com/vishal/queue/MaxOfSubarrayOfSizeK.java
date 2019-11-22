package com.vishal.queue;

import java.util.LinkedList;
import java.util.Queue;

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
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<k;i++) {
			if(arr[i] > max) {
				max = arr[i];
				queue.add(max);
			}
		}
		System.out.print(max + " ");
		queue.remove();
		for(int i=k;i<arr.length;i++){
			if(arr[i] > max) {
				max = arr[i];
			}
			queue.add(arr[i]);
			System.out.print(max + " ");
			queue.remove();
		}
	}

}
