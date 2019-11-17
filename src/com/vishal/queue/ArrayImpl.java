package com.vishal.queue;

public class ArrayImpl {

	private static int QUEUE_SIZE = 10;
	private static int QUEUE[] = new int[QUEUE_SIZE];
	private static int front = -1;
	private static int rear = -1;
	
	public static void main(String[] args) {
		push(10);
		push(5);
		push(12);
		push(20);
		pop();
		display();
	}
	
	private static void push(int item) {
		if(rear == QUEUE_SIZE - 1) {
			return;
		}else {
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

}
