package com.vishal.queue;

import com.vishal.linkedlist.SinglyNode;

public class LinkedListImpl {

	private SinglyNode front;
	private SinglyNode rear;

	public LinkedListImpl(){
		this.front = null;
		this.rear = null;
	}
	
	public static void main(String[] args) {
		LinkedListImpl queueList = new LinkedListImpl();
		queueList.push(10);
		queueList.push(5);
		queueList.push(12);
		queueList.push(20);
		queueList.display();
		queueList.pop();
		queueList.display();
	}
	
	private void push(int item) {
		SinglyNode temp = new SinglyNode(item);
		if(rear == null) {
			front = temp;
			rear = temp;
		}else {
			rear.next = temp;
			rear = rear.next;
		}
	}
	
	private int pop() {
		if(front == null) {
			System.out.print("Underflow");
			return -1;
		}
		SinglyNode temp = front;
		front = front.next;
		temp.next = null;
		return temp.data;
	}
	
	private void display() {
		SinglyNode currNode = front;
		while(currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.getNext();
		}
	}

}
