package com.vishal.heap;

public class Heapify {

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

	public static void minHeapify(int[] heap, int pos) {
		int min = pos;
		int left = getLeft(pos);
		int right = getRight(pos);
		if (left < size && heap[left] < heap[min]) {
			min = left;
		}
		if (right < size && heap[right] < heap[min]) {
			min = right;
		}
		if (min != pos) {
			int temp = heap[pos];
			heap[pos] = heap[min];
			heap[min] = temp;
			minHeapify(heap, min);
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
	}

}
