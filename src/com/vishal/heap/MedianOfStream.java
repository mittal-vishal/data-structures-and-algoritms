package com.vishal.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {

	public static void main(String[] args) {
		int a[] = { 25, 7, 10, 15, 20 };
		find(a);
	}

	private static void find(int[] a) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i : a) {
			if (maxHeap.size() <= minHeap.size()) {
				if (maxHeap.isEmpty() || i < minHeap.peek()) {
					maxHeap.add(i);
				} else {
					maxHeap.add(minHeap.poll());
					minHeap.add(i);
				}
			} else {
				if ((minHeap.isEmpty() && i < maxHeap.peek()) || ((!minHeap.isEmpty()) && i < minHeap.peek())) {
					minHeap.add(maxHeap.poll());
					maxHeap.add(i);
				} else {
					minHeap.add(i);
				}
			}
			if ((minHeap.size() + maxHeap.size()) % 2 == 1) {
				System.out.println(maxHeap.peek());
			} else {
				double median = (maxHeap.peek() + minHeap.peek()) / 2;
				System.out.println(median);
			}
		}

	}

}
