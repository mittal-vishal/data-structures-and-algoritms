package com.vishal.queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class QueueUsingStack {

	private static int CAPACITY = 10;
	private static int top = -1;
	private static int queue[] = new int[CAPACITY];

	public static void main(String[] args) {
		Arrays.fill(queue, Integer.MIN_VALUE);
		pop();
		push(4);
		push(1);
		print();
		pop();
		System.out.println();
		print();
		push(15);
		System.out.println();
		print();
	}

	private static void push(int item) {
		if (top == CAPACITY - 1) {
			System.out.println("Overflow");
		} else {
			Stack<Integer> stack1 = new Stack<>();
			Stack<Integer> stack2 = new Stack<>();
			stack2.push(item);
			for (int i = top; i >= 0; i--) {
				stack1.push(pop());
			}
			Iterator<Integer> itr = stack1.iterator();
			while (itr.hasNext()) {
				stack2.push(itr.next());
			}
			Iterator<Integer> itr2 = stack2.iterator();
			while (itr2.hasNext()) {
				queue[++top] = itr2.next();
			}
		}
	}

	private static int pop() {
		if (top == -1) {
			return -1;
		} else {
			return queue[top--];
		}
	}

	private static void print() {
		for (int i = top; i >= 0; i--) {
			if (queue[i] != Integer.MIN_VALUE) {
				System.out.print(queue[i] + " ");
			} else {
				break;
			}
		}
	}

}
