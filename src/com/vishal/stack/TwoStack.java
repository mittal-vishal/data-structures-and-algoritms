package com.vishal.stack;

public class TwoStack {
	int stack[];
	int top1;
	int top2;

	public TwoStack(int capacity) {
		this.stack = new int[capacity];
		this.top1 = -1;
		this.top2 = capacity;
	}

	public void push1(int item) {
		if(top1 < (top2 + 1)){
			stack[++top1] = item;
		}
	}

	public void push2(int item) {
		if(top2 > (top1 + 1)){
			stack[--top2] = item;
		}
	}

	public int pop1() {
		if (top1 > -1) {
			int item = stack[top1];
			top1 = top1 - 1;
			return item;
		} else {
			return -1;
		}
	}

	public int pop2() {
		if (top2 < stack.length) {
			int item = stack[top2];
			top2 = top2 + 1;
			return item;
		} else {
			return -1;
		}
	}
}
