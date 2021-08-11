package com.vishal.stack;

import com.vishal.linkedlist.SinglyNode;

public class StackLinkedListImpl {
	
	private SinglyNode top;

	public StackLinkedListImpl(){
		this.top = null;
	}

	public static void main(String[] args) {
		StackLinkedListImpl stackLinkedList = new StackLinkedListImpl();
		stackLinkedList.push(20);
		stackLinkedList.push(25);
		stackLinkedList.push(12);
		stackLinkedList.print();
		stackLinkedList.pop();
		stackLinkedList.print();
		stackLinkedList.pop();
		stackLinkedList.print();
		stackLinkedList.pop();
		System.out.println();
	}
	
	private void push(int item) {
		SinglyNode newNode = new SinglyNode(item);
		newNode.next = top;
		top = newNode;
	}
	
	private int pop() {
		if(top == null) {
			System.out.println("Underflow");
			return -1;
		}
		SinglyNode temp = top;
		top = top.next;
		temp.next = null;
		return temp.data;
	}
	
	private void print() {
		SinglyNode currNode = top;
		if(currNode == null) {
			System.out.print("Stack Empty");
		}
		while(currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}

}
