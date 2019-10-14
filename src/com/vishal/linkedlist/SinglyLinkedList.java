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

	private static void deleteAtBeg() {
		if (head == null) {
			return;
		} else {
			head = head.getNext();
		}
	}

	private static void deleteAtEnd() {
		if (head == null) {
			return;
		} else if (head.getNext() == null) {
			head = null;
		} else {
			SinglyNode currNode = head;
			SinglyNode prevNode = head;
			while (currNode.getNext() != null) {
				prevNode = currNode;
				currNode = currNode.getNext();
			}
			prevNode.setNext(null);
		}
	}

	private static void deleteAtSpecificElement(int element) {
		SinglyNode currNode = head;
		while (currNode.getData() != element) {
			currNode = currNode.getNext();
			if (currNode.getNext() == null && currNode.getData() != element) {
				return;
			}
		}
		if (currNode == head) {
			head = null;
		} else {
			currNode.setData(currNode.getNext().getData());
			currNode.setNext(currNode.getNext().getNext());
		}
	}

	private static void print() {
		SinglyNode current = head;
		while (current != null) {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		}
	}

	private static int findNthNodeFromLast(int n) {
		SinglyNode currNode = head;
		int length = 0;
		while (currNode != null) {
			length++;
			currNode = currNode.getNext();
		}
		if (n > length || n <= 0) {
			return -1;
		}
		currNode = head;
		int count = (length - n + 1);
		while (count != 1) {
			currNode = currNode.getNext();
			count--;
		}
		return currNode.getData();
	}

	private static int findMiddle() {
		SinglyNode currNode = head;
		SinglyNode doubleNode = head;
		while (doubleNode != null && (doubleNode != null && doubleNode.getNext() != null)) {
			currNode = currNode.getNext();
			doubleNode = doubleNode.getNext().getNext();
		}
		return currNode.getData();
	}
	
	private static void reverseIteratively() {
		SinglyNode currNode = head;
		SinglyNode prevNode = null;
		SinglyNode temp = null;
		while(currNode != null) {
			temp = currNode.getNext();
			currNode.setNext(prevNode);
			prevNode = currNode;
			currNode = temp;
		}
		head = prevNode;
	}
	
	private static void reverseRecursively(SinglyNode currNode, SinglyNode prevNode) {
		if(currNode != null) {
			SinglyNode temp = null;
			temp = currNode.getNext();
			currNode.setNext(prevNode);
			reverseRecursively(temp, currNode);
		}else {
			head = prevNode;
		}
	}

	public static void main(String[] args) {
		insertAtBegin(5);
		insertAtBegin(12);
		insertAtEnd(3);
		insertAtBegin(2);
		insertAtEnd(7);
		insertAfterSpecificElement(23, 5);
		insertBeforeSpecificElement(34, 5);
		deleteAtBeg();
		deleteAtEnd();
		deleteAtSpecificElement(5);
		System.out.println("nth node = " + findNthNodeFromLast(3));
		System.out.println("middle node is = " + findMiddle());
		print();
		reverseRecursively(head, null);
		System.out.println();
		print();
		reverseIteratively();
		System.out.println();
		print();
	}

}
