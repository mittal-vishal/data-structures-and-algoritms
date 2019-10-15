package com.vishal.linkedlist;

import java.util.LinkedHashSet;
import java.util.Set;

public class CircularLinkedList {

	private static SinglyNode head = null;

	private static void insertAtBegin(int item) {
		SinglyNode temp = new SinglyNode(item);
		if (head == null) {
			temp.setNext(head);
			head = temp;
			head.setNext(head);
		} else {
			SinglyNode currNode = head;
			while (currNode.getNext() != head) {
				currNode = currNode.getNext();
			}
			temp.setNext(head);
			currNode.setNext(temp);
			head = temp;
		}
	}

	private static void insertAtEnd(int item) {
		SinglyNode temp = new SinglyNode(item);
		if (head == null) {
			head = temp;
			head.setNext(null);
		} else {
			SinglyNode currNode = head;
			while (currNode.getNext() != head) {
				currNode = currNode.getNext();
			}
			currNode.setNext(temp);
			temp.setNext(head);
		}
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

	private static void deleteAtBeg() {
		if (head == null) {
			return;
		} else if (head.getNext() == head) {
			head = null;
		} else {
			SinglyNode currNode = head;
			while (currNode.getNext() != head) {
				currNode = currNode.getNext();
			}
			currNode.setNext(head.getNext());
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
			while (currNode.getNext() != head) {
				prevNode = currNode;
				currNode = currNode.getNext();
			}
			prevNode.setNext(head);
		}
	}

	private static void deleteAtSpecificElement(int element) {
		SinglyNode currNode = head;
		SinglyNode prevNode = head;
		while (currNode.getData() != element) {
			prevNode = currNode;
			currNode = currNode.getNext();
			if (currNode.getNext() == head && currNode.getData() != element) {
				return;
			}
		}
		if (currNode == head) {
			head = null;
		} else if (currNode.getNext() == head) {
			prevNode.setNext(head);
		} else {
			currNode.setData(currNode.getNext().getData());
			currNode.setNext(currNode.getNext().getNext());
		}
	}

	private static void print() {
		SinglyNode current = head;
		do {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		} while (current != head);
	}

	private static boolean isCycle() {
		SinglyNode slow = head;
		SinglyNode fast = head;
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isCycleExist() {
		SinglyNode currNode = head;
		Set<SinglyNode> hashSet = new LinkedHashSet<>();
		while (currNode != null) {
			if (!hashSet.contains(currNode)) {
				hashSet.add(currNode);
			}else {
				return true;
			}
			currNode = currNode.getNext();
		}
		return false;
	}
	
	private static void removeCycle() {
		SinglyNode currNode = head;
		Set<SinglyNode> hashSet = new LinkedHashSet<>();
		while (currNode != null && currNode.getNext() != null) {
			if (!hashSet.contains(currNode.getNext())) {
				hashSet.add(currNode);
			}else {
				currNode.setNext(null);
			}
			currNode = currNode.getNext();
		}
	}
	
	private static void removeCycleUsingFloyd() {
		SinglyNode fast = head;
		SinglyNode slow = head;
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(fast == slow) {
				break;
			}
		}
		if(slow != fast) {
			return;
		}
		slow = head;
		while(slow != fast) {
			slow = slow.getNext();
			fast = fast.getNext();
		}
		while(slow != null && slow.getNext() != fast) {
			slow = slow.getNext();
		}
		slow.setNext(null);
	}

	public static void main(String[] args) {
		insertAtBegin(5);
		insertAtBegin(2);
		insertAtBegin(7);
		insertAtEnd(12);
		insertAtBegin(32);
		insertAfterSpecificElement(8, 5);
		insertBeforeSpecificElement(43, 5);
		insertAtEnd(3);
		deleteAtBeg();
		deleteAtBeg();
		deleteAtEnd();
		deleteAtSpecificElement(5);
		deleteAtSpecificElement(12);
		System.out.println(isCycle());
		System.out.println(isCycleExist());
		removeCycle();
		removeCycleUsingFloyd();
		print();
	}

}
