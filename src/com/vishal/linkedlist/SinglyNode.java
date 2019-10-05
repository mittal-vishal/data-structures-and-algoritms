package com.vishal.linkedlist;

public class SinglyNode {

	private int data;
	private SinglyNode next;

	public SinglyNode(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public SinglyNode getNext() {
		return next;
	}

	public void setNext(SinglyNode next) {
		this.next = next;
	}

}
