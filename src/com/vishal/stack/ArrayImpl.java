package com.vishal.stack;

import java.util.Arrays;

public class ArrayImpl {
	
	private static int STACK_CAPACITY = 10;
	private static int top = -1;
	private static int stack[] = new int[STACK_CAPACITY];

	public static void main(String[] args) {
		Arrays.fill(stack, Integer.MIN_VALUE);
		pop();
		push(4);
		push(1);
		print();
		peek();
		size();
		pop();
		push(15);
		System.out.println();
		print();
	}
	
	private static void push(int item) {
		if(top == STACK_CAPACITY - 1) {
			System.out.println("Overflow");
			return;
		}
		top = top + 1;
		stack[top] = item;
	}
	
	private static int pop() {
		int item = -1;
		if(top == -1) {
			System.out.println("Underflow");
		}else {
			item = stack[top];
			top = top - 1;
		}
		return item;
	}
	
	private static void print() {
		for(int i : stack) {
			if(i != Integer.MIN_VALUE) {
				System.out.print(i + " ");
			}else {
				break;
			}
		}
	}
	
	private static int peek() {
		if(top == -1) {
			return -1;
		}else {
			return stack[top];
		}
	}
	
	private static int size() {
		return stack.length;
	}

}
