package com.vishal.stack;

import java.util.Arrays;

public class StackArrayImpl {
	
	private static int STACK_CAPACITY = 10;
	private int top;
	private int stack[];

	public StackArrayImpl(){
		this.top = -1;
		this.stack = new int[STACK_CAPACITY];
		Arrays.fill(stack, Integer.MIN_VALUE);
	}

	public static void main(String[] args) {
		StackArrayImpl stackImpl = new StackArrayImpl();
		stackImpl.pop();
		stackImpl.push(4);
		stackImpl.push(1);
		stackImpl.print();
		System.out.println();
		System.out.println(stackImpl.peek());
		System.out.println(stackImpl.size());
		stackImpl.pop();
		stackImpl.push(15);
		stackImpl.print();
	}
	
	private void push(int item) {
		if(top == STACK_CAPACITY - 1) {
			System.out.println("Overflow");
			return;
		}
		stack[++top] = item;
	}
	
	private int pop() {
		if(top == -1) {
			System.out.println("Underflow");
			return -1;
		}
		int item = stack[top];
		stack[top--] = Integer.MIN_VALUE;
		return item;
	}
	
	private void print() {
		for(int i = top; i >= 0; i--) {
			if(stack[i] != Integer.MIN_VALUE) {
				System.out.print(stack[i] + " ");
			}else {
				break;
			}
		}
	}
	
	private int peek() {
		if(top == -1) {
			return -1;
		}else {
			return stack[top];
		}
	}

	private int size() {
		return top + 1;
	}

}
