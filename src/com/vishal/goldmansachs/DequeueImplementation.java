package com.vishal.goldmansachs;

import com.vishal.linkedlist.DoublyNode;

public class DequeueImplementation {

	private static DoublyNode front = null;
	private static DoublyNode rear = null;

	public static void addFirst(int item) {
		DoublyNode temp = new DoublyNode(item);
		temp.setPrev(null);
		temp.setNext(front);
		if(front != null) {
			front.setPrev(temp);
		}else {
			rear = temp;
		}
		front = temp;
	}

	public static void addLast(int item) {
		DoublyNode temp = new DoublyNode(item);
		if(rear != null) {
			rear.setNext(temp);
			temp.setPrev(rear);
			rear = temp;
		}else {
			temp.setPrev(null);
			temp.setNext(rear);
			rear = temp;
		}
	}
	
	private static void print() {
		DoublyNode currNode = front;
		while (currNode != null) {
			System.out.print(currNode.getData() + " ");
			currNode = currNode.getNext();
		}
	}
	
	public static void removeFirst() {
		if(front != null){
			front = front.getNext();
		}
	}
	
	public static void removeLast() {
		if(rear != null) {
			rear.getPrev().setNext(null);
			rear.setPrev(null);
		}
	}
	
	public static int peekFirst() {
		return front != null ? front.getData() : null;
	}
	
	public static int peekLast() {
		return rear != null ? rear.getData() : null;
	}
	
	public static int size() {
		DoublyNode curr = front;
		int size = 0;
		while(curr != null) {
			size++;
		}
		return size;
	}

	public static void main(String[] args) {
		addFirst(1);
		addLast(3);
		addFirst(2);
		print();
		System.out.println(peekFirst());
	}

}
