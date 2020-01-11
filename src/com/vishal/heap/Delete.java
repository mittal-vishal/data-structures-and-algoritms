package com.vishal.heap;

public class Delete {

	private static final int CAPACITY = 10;
	private static int[] heap = null;
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

	public static void insert(int item) {
		if (size == CAPACITY) {
			System.out.println("Overflow");
		} else {
			heap[size++] = item;
			int temp;
			for (int i = size - 1; i > 0; i = getParent(i)) {
				if (heap[i] < heap[getParent(i)]) {
					temp = heap[i];
					heap[i] = heap[getParent(i)];
					heap[getParent(i)] = temp;
				}
			}
		}
	}

	public static void display() {
		for (int i = 0; i < size; i++) {
			if (heap[i] != -1) {
				System.out.print(heap[i] + " ");
			}
		}
	}

	public static void decreaseKey(int[] heap, int pos, int item) {
		if (pos < size) {
			heap[pos] = 3;
			int temp = -1;
			for (int i = pos; i > 0; i = getParent(i)) {
				if (heap[i] < heap[getParent(i)]) {
					temp = heap[i];
					heap[i] = heap[getParent(i)];
					heap[getParent(i)] = temp;
				}
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

	public static int extractMin() {
		if (size < 1) {
			System.out.println("Underflow");
			return -1;
		} else {
			int temp = heap[0];
			heap[0] = heap[size - 1];
			heap[size - 1] = temp;
			size--;
			minHeapify(heap, 0);
		}
		return heap[size];
	}

	public static void delete(int[] heap, int pos) {
		if (pos < size) {
			decreaseKey(heap, pos, Integer.MIN_VALUE);
			extractMin();
		} else {
			System.out.println("Underflow");
			return;
		}
	}

	public static void main(String[] args) {
		heap = new int[CAPACITY];
		size = 0;
		insert(10);
		insert(20);
		insert(15);
		insert(40);
		insert(50);
		insert(100);
		insert(25);
		insert(45);
		insert(12);
		display();
		System.out.println();
		delete(heap, 7);
		display();
	}

}
