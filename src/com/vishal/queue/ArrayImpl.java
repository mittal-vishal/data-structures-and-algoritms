package com.vishal.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArrayImpl {

	private static int QUEUE_SIZE = 10;
	private static int QUEUE[] = new int[QUEUE_SIZE];
	private static int front = -1;
	private static int rear = -1;
	
	public static void main(String[] args) {
		Arrays.fill(QUEUE, Integer.MIN_VALUE);
		push(10);
		push(5);
		push(12);
		push(20);
		pop();
		display();
		System.out.println();
		reverseIteratively();
		display();
		System.out.println();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(4);
		reverseRecursively(queue);
		System.out.println(queue);
	}
	
	private static void push(int item) {
		if(rear != QUEUE_SIZE - 1) {
			rear = rear + 1;
			QUEUE[rear] = item;
			if(front == -1) {
				front = 0;
			}
		}
	}
	
	private static int pop() {
		if(front == (rear + 1)) {
			return -1;
		}
		int item = QUEUE[front];
		front = front + 1;
		return item;
	}
	
	private static void display() {
		for(int i = front ; i <= rear; i++ ) {
			System.out.print(QUEUE[i] + " ");
		}
	}
	
	private static void reverseIteratively() {
		Stack<Integer> stack = new Stack<>();
		for(int i = front; i <= rear; i++) {
			if(QUEUE[i] != Integer.MIN_VALUE) {
				stack.push(pop());
			}
		}
		while(!stack.isEmpty()) {
			push(stack.pop());
		}
	}
	
	private static void reverseRecursively(Queue<Integer> queue) {
		if(!queue.isEmpty()) {
			int item = queue.remove();
			reverseRecursively(queue);
			queue.add(item);
		}
	}

}
