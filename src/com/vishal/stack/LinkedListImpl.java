package com.vishal.stack;

import com.vishal.linkedlist.SinglyNode;

public class LinkedListImpl {
	
	private static SinglyNode head = null;

	public static void main(String[] args) {
		push(20);
		push(25);
		push(12);
		print();
		pop();
		System.out.println();
		print();
		pop();
		System.out.println();
		print();
		pop();
		System.out.println();
		print();
		System.out.println();
		pop();
	}
	
	private static void push(int item) {
		SinglyNode newNode = new SinglyNode(item);
		newNode.setNext(head);
		head = newNode;
	}
	
	private static int pop() {
		int item = -1;
		if(head == null) {
			System.out.println("Underflow");
		}else {
			item = head.getData();
			head = head.getNext();
		}
		return item;
	}
	
	private static void print() {
		SinglyNode currNode = head;
		if(currNode == null) {
			System.out.print("Stack Empty");
		}
		while(currNode != null) {
			System.out.print(currNode.getData() + " ");
			currNode = currNode.getNext();
		}
	}

}
