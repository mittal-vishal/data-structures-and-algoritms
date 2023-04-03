package com.vishal.stack;

public class CustomTwoStack {

	class TwoStack {
		int size;
		int top1,top2;
		int arr[];
		TwoStack(int size) {
			arr = new int[size];
			this.size = size;
			top1 = -1;
			top2 = size;
		}
	}

	//Function to push an integer into the stack1.
	void push1(int x, TwoStack sq) {
		if(sq.top2 - sq.top1 == 1){
			return;
		}
		sq.top1++;
		sq.arr[sq.top1] = x;
	}

	//Function to push an integer into the stack2.
	void push2(int x, TwoStack sq) {
		if(sq.top2 - sq.top1 == 1){
			return;
		}
		sq.top2--;
		sq.arr[sq.top2] = x;
	}

	//Function to remove an element from top of the stack1.
	int pop1(TwoStack sq) {
		if(sq.top1 < 0){
			return -1;
		}
		int item = sq.arr[sq.top1];
		sq.top1--;
		return item;
	}

	//Function to remove an element from top of the stack2.
	int pop2(TwoStack sq) {
		if(sq.top2 == sq.size){
			return -1;
		}
		int item = sq.arr[sq.top2];
		sq.top2++;
		return item;
	}
}
