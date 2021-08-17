package com.vishal.heap;

public class Insertion {

	private static final int CAPACITY = 10;
	private int heap[];
	private int size;

	public Insertion(){
		heap = new int[CAPACITY];
		size = 0;
	}

	public int getLeft(int i) {
		return 2 * i + 1;
	}

	public int getRight(int i) {
		return 2 * i + 2;
	}

	public int getParent(int i) {
		return (i - 1) / 2;
	}

	public void insert(int item) {
		if (size == CAPACITY) {
			System.out.println("Overflow");
			return;
		}
		heap[size] = item;
		for(int i = size; i != 0 && heap[i] < heap[getParent(i)];){
			int temp = heap[i];
			heap[i] = heap[getParent(i)];
			heap[getParent(i)] = temp;
			i = getParent(i);
		}
		size++;
	}

	public void display() {
		for (int i = 0; i < size; i++) {
			if (heap[i] != 0) {
				System.out.print(heap[i] + " ");
			}
		}
	}

	public static void main(String[] args) {
		Insertion heapInsertion = new Insertion();
		heapInsertion.insert(10);
		heapInsertion.insert(20);
		heapInsertion.insert(15);
		heapInsertion.insert(40);
		heapInsertion.insert(50);
		heapInsertion.insert(100);
		heapInsertion.insert(25);
		heapInsertion.insert(45);
		heapInsertion.insert(1);
		heapInsertion.display();
	}

}
