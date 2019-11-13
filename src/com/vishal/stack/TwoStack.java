package com.vishal.stack;

public class TwoStack {
	int arr[] = new int[100];
	int top1 = -1;
	int top2 = arr.length;

	public void push1(int x, TwoStack sq) {
		sq.arr[++sq.top1] = x;
	}

	public void push2(int x, TwoStack sq) {
		sq.arr[--sq.top2] = x;
	}

	public int pop1(TwoStack sq) {
		if (sq.top1 > -1) {
			int item = sq.arr[sq.top1];
			sq.top1 = sq.top1 - 1;
			return item;
		} else {
			return -1;
		}
	}

	public int pop2(TwoStack sq) {
		if (sq.top2 <= sq.arr.length - 1) {
			int item = sq.arr[sq.top2];
			sq.top2 = sq.top2 + 1;
			return item;
		} else {
			return -1;
		}
	}
}
