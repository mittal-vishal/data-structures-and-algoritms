package com.vishal.linkedlist;

public class DoublyLinkedList {

	private static DoublyNode head;
	
	private static void insertAtBegining(int x) {
		DoublyNode temp = new DoublyNode(x);
		temp.setPrev(null);
		temp.setNext(head);
		if(head != null) {
			head.setPrev(temp);
		}
		head = temp;
	}
	
	private static void insertAtEnd(int item) {
		DoublyNode temp = new DoublyNode(item);
		if (head == null) {
			head = temp;
			head.setPrev(null);
			head.setNext(null);
		} else {
			DoublyNode currNode = head;
			while(currNode.getNext() != null) {
				currNode = currNode.getNext();
			}
			currNode.setNext(temp);
			temp.setPrev(currNode);
			temp.setNext(null);
		}
	}
	
	private static void print() {
		DoublyNode currNode = head;
		while (currNode != null) {
			System.out.print(currNode.getData() + " ");
			currNode = currNode.getNext();
		}
	}
	
	private static void insertAfterSpecificElement(int item, int element) {
		DoublyNode temp = new DoublyNode(item);
		DoublyNode currNode = head;
		while (currNode.getData() != element) {
			currNode = currNode.getNext();
		}
		temp.setNext(currNode.getNext());
		currNode.setNext(temp);
		temp.setPrev(currNode);
	}

	private static void insertBeforeSpecificElement(int item, int element) {
		DoublyNode temp = new DoublyNode(item);
		DoublyNode currNode = head;
		while (currNode.getData() != element) {
			currNode = currNode.getNext();
		}
		temp.setNext(currNode);
		temp.setPrev(currNode.getPrev());
		currNode.getPrev().setNext(temp);
		currNode.setPrev(temp);
	}
	
	public static void main(String[] args) {
		insertAtBegining(8);
		insertAtBegining(12);
		insertAtEnd(3);
		insertAfterSpecificElement(34, 8);
		insertBeforeSpecificElement(7, 8);
		print();
	}

}
