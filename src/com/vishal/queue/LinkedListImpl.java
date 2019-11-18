package com.vishal.queue;

import com.vishal.linkedlist.SinglyNode;

public class LinkedListImpl {

	private static SinglyNode front = null;
	private static SinglyNode rear = null;
	
	public static void main(String[] args) {
		push(10);
		push(5);
		push(12);
		push(20);
		display();
		pop();
		display();
	}
	
	private static void push(int item) {
		SinglyNode temp = new SinglyNode(item);
		if(front == null) {
			front = temp;
			rear = temp;
		}else {
			rear.setNext(temp);
			rear = temp;
		}
	}
	
	private static int pop() {
		if(front == null) {
			return -1;
		}
		int item = front.getData();
		front = front.getNext();
		return item;
	}
	
	private static void display() {
		SinglyNode currNode = front;
		while(currNode != null) {
			System.out.print(currNode.getData() + " ");
			currNode = currNode.getNext();
		}
	}

}
