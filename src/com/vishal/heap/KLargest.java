package com.vishal.heap;

import java.util.PriorityQueue;

public class KLargest {

	private static int[] heap = { 5, 1, 8, 7, 32, 3, 10 };
	private static int size = 7;

	public static int getLeft(int i) {
		return 2 * i + 1;
	}

	public static int getRight(int i) {
		return 2 * i + 2;
	}

	public static int getParent(int i) {
		return (i - 1) / 2;
	}

	public static void display() {
		for (int i = 0; i < size; i++) {
			if (heap[i] != -1) {
				System.out.print(heap[i] + " ");
			}
		}
	}

	public static void maxHeapify(int[] heap, int pos) {
		int max = pos;
		if (getLeft(pos) < size && heap[getLeft(pos)] > heap[max]) {
			max = getLeft(pos);
		}
		if (getRight(pos) < size && heap[getRight(pos)] > heap[max]) {
			max = getRight(pos);
		}
		if (max != pos) {
			int temp = heap[pos];
			heap[pos] = heap[max];
			heap[max] = temp;
			pos = max;
			maxHeapify(heap, pos);
		}
	}

	public static int extractMax() {
		if (size < 1) {
			System.out.println("Underflow");
			return -1;
		} else {
			int temp = heap[0];
			heap[0] = heap[size - 1];
			heap[size - 1] = temp;
			size--;
			maxHeapify(heap, 0);
		}
		return heap[size];
	}

	public static void buildHeap(int[] heap) {
		for (int i = (size / 2) - 1; i >= 0; i--) {
			maxHeapify(heap, i);
		}
	}

	public static void main(String[] args) {
		int k = 3;
		display();
		System.out.println();
		extractKLargestOptimal(k);
	}

	private static void extractKLargest(int k) {
		buildHeap(heap);
		while(k > 0) {
			System.out.println(extractMax());
			maxHeapify(heap, 0);
			k--;
		}
	}
	
	private static void extractKLargestOptimal(int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < k; i++) {
			pq.add(heap[i]);
		}
		for(int i = k; i < heap.length; i++) {
			if(heap[i] > pq.peek()) {
				pq.poll();
				pq.add(heap[i]);
			}
		}
		pq.forEach(p -> System.out.println(p + " "));
	}
	
}
