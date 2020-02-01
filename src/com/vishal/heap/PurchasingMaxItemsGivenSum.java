package com.vishal.heap;

public class PurchasingMaxItemsGivenSum {
	
	private static int[] cost = { 30, 10, 5, 100, 20 };
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

	public static void minHeapify(int[] heap, int pos) {
		int min = pos;
		if (getLeft(pos) < size && heap[getLeft(pos)] < heap[pos]) {
			min = getLeft(pos);
		}
		if (getRight(pos) < size && heap[getRight(pos)] < heap[min]) {
			min = getRight(pos);
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
		size = cost.length;
		int sum = 35;
		System.out.println(findMaxItems(cost, sum));
	}
	
	public static int extractMin() {
		if (size < 1) {
			System.out.println("Underflow");
			return -1;
		} else {
			int temp = cost[0];
			cost[0] = cost[size - 1];
			cost[size - 1] = temp;
			size--;
			minHeapify(cost, 0);
		}
		return cost[size];
	}

	private static int findMaxItems(int[] cost, int sum) {
		int items = 0;
		buildHeap(cost);
		int extracted = -1;
		while(size != 0) {
			extracted = extractMin();
			if(extracted <= sum) {
				sum = sum - extracted;
				items++;
			}
		}
		return items;
	}
	
}
