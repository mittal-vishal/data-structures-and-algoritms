package com.vishal.linkedlist;

public class SinglyLinkedList {

	private static SinglyNode head = null;

	private static void insertAtBegin(int item) {
		SinglyNode temp = new SinglyNode(item);
		temp.setNext(head);
		head = temp;
	}

	private static void insertAfterSpecificElement(int item, int element) {
		SinglyNode temp = new SinglyNode(item);
		SinglyNode currNode = head;
		while (currNode.getData() != element) {
			currNode = currNode.getNext();
		}
		temp.setNext(currNode.getNext());
		currNode.setNext(temp);
	}

	private static void insertBeforeSpecificElement(int item, int element) {
		SinglyNode temp = new SinglyNode(item);
		SinglyNode currNode = head;
		while (currNode.getData() != element) {
			currNode = currNode.getNext();
		}
		int currData = currNode.getData();
		currNode.setData(temp.getData());
		temp.setData(currData);
		temp.setNext(currNode.getNext());
		currNode.setNext(temp);
	}

	private static void insertAtEnd(int item) {
		SinglyNode temp = new SinglyNode(item);
		if (head == null) {
			head = temp;
			head.setNext(null);
		} else {
			SinglyNode currNode = head;
			while (currNode.getNext() != null) {
				currNode = currNode.getNext();
			}
			currNode.setNext(temp);
			temp.setNext(null);
		}
	}

	private static void print() {
		SinglyNode current = head;
		while (current != null) {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		}
	}

	public static void main(String[] args) {
		insertAtBegin(5);
		insertAtBegin(12);
		insertAtEnd(3);
		insertAtBegin(2);
		insertAfterSpecificElement(23, 5);
		insertBeforeSpecificElement(34, 5);
		print();
	}

}
