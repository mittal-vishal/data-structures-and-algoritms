package com.vishal.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueArrayImpl {

	private static final int QUEUE_SIZE = 5;
	private int queue[];
	private int front;
	private int rear;

	public QueueArrayImpl(){
		this.front = -1;
		this.rear = -1;
		queue = new int[QUEUE_SIZE];
	}
	
	public static void main(String[] args) {
		QueueArrayImpl queueImpl = new QueueArrayImpl();
		queueImpl.enQueue(10);
		queueImpl.enQueue(5);
		queueImpl.enQueue(12);
		queueImpl.enQueue(20);
		queueImpl.deQueue();
		queueImpl.display();
		System.out.println();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(4);
		queueImpl.reverseIteratively(queue);
		System.out.println(queue);
		queueImpl.reverseRecursively(queue);
		System.out.println(queue);
	}
	
	private void enQueue(int item) {
		if((rear + 1 - front) == QUEUE_SIZE){
			System.out.print("Overflow");
			return;
		}
		if(front == -1){
			front = 0;
			rear = 0;
		}else{
			rear++;
		}
		queue[rear % QUEUE_SIZE] = item;
	}
	
	private int deQueue() {
		if(front == -1 || front > rear){
			System.out.print("Underflow");
			return -1;
		}
		int item = queue[front % QUEUE_SIZE];
		queue[front % QUEUE_SIZE] = -1;
		front++;
		return item;
	}
	
	private void display() {
		for(int i = (front % QUEUE_SIZE); i <= (rear % QUEUE_SIZE); i++){
			System.out.print(queue[i] + " ");
		}
	}
	
	private void reverseIteratively(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();
		while(!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		while(!stack.isEmpty()) {
			queue.offer(stack.pop());
		}
	}

	private void reverseRecursively(Queue<Integer> queue) {
		if(!queue.isEmpty()) {
			int item = queue.poll();
			reverseRecursively(queue);
			queue.add(item);
		}
	}

}
