package com.vishal.heap;

public class HeapSort {

	private static int[] heap = {4, 1, 3, 9, 7};
	private static int size;

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
		if (getLeft(pos) < size && heap[getLeft(pos)] > heap[pos]) {
			max = getLeft(pos);
		}
		if (getRight(pos) < size && heap[getRight(pos)] > heap[max]) {
			max = getRight(pos);
		}
		if (max != pos) {
			int temp = heap[pos];
			heap[pos] = heap[max];
			heap[max] = temp;
			maxHeapify(heap, max);
		}
	}
	
	public static void buildHeap(int[] heap) {
		for (int i = (size / 2) - 1; i >= 0; i--) {
			maxHeapify(heap, i);
		}
	}
	
	public static void heapSort() {
		buildHeap(heap);
		while(size > 0) {
			int temp = heap[size-1];
			heap[size-1] = heap[0];
			heap[0] = temp;
			size--;
			maxHeapify(heap, 0);
		}
		size = heap.length;
	}

	public static void main(String[] args) {
		size = heap.length;
		display();
		System.out.println();
		heapSort();
		display();
	}
	
}
