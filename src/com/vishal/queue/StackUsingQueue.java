package com.vishal.queue;

import java.util.Arrays;

public class StackUsingQueue {
	
	private static int CAPACITY = 10;
	private static int front = -1;
	private static int rear = -1;
	private static int queue[] = new int[CAPACITY];


	public static void main(String[] args) {
		Arrays.fill(queue, -1);
		pop();
		push(4);
		push(1);
		print();
		pop();
		push(15);
		System.out.println();
		print();
	}
	
	private static void push(int item) {
		if(rear == CAPACITY - 1) {
			System.out.println("Overflow");
		}
		if(front == -1) {
			queue[++rear] = item;
			front = 0;
		}else {
			int popItem = pop();
			queue[++rear] = item;
			queue[++rear] = popItem;
		}
	}
	
	private static int pop() {
		if(front == -1 || front == rear + 1) {
			return -1;
		}else {
			int item = queue[front];
			front = front + 1;
			return item;
		}
	}
	
	private static void print() {
		for(int i = front; i <= rear; i++) {
			System.out.print(queue[i] + " ");
		}
	}

}
