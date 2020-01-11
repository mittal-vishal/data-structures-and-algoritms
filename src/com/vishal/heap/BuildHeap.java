package com.vishal.heap;

public class BuildHeap {

	private static int[] heap = { 5, 1, 8, 7, 0, 3, 10 };
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

	public static void minHeapify(int[] heap, int pos) {
		int min = pos;
		if (getLeft(min) < size && heap[getLeft(min)] < heap[min]) {
			min = getLeft(min);
		}
		if (getRight(min) < size && heap[getRight(min)] < heap[min]) {
			min = getRight(min);
		}
		if (min != pos) {
			int temp = heap[pos];
			heap[pos] = heap[min];
			heap[min] = temp;
			pos = min;
			minHeapify(heap, pos);
		}
	}

	public static void buildHeap(int[] heap) {
		for (int i = (size / 2) - 1; i >= 0; i--) {
			minHeapify(heap, i);
		}
	}

	public static void main(String[] args) {
		display();
		System.out.println();
		buildHeap(heap);
		display();
	}

}
