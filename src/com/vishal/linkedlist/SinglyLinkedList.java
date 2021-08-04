package com.vishal.linkedlist;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

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

	public static SinglyNode middleNode(SinglyNode head) {
		if(head == null || head.next == null){
			return head;
		}
		SinglyNode slow = head;
		SinglyNode fast = head;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	private static void reverseIteratively() {
		SinglyNode currNode = head;
		SinglyNode prevNode = null;
		SinglyNode temp = null;
		while (currNode != null) {
			temp = currNode.getNext();
			currNode.setNext(prevNode);
			prevNode = currNode;
			currNode = temp;
		}
		head = prevNode;
	}

	private static SinglyNode reverseRecursively(SinglyNode curr, SinglyNode prev) {
		if(curr == null)
			return prev;
		SinglyNode temp = null;
		temp = curr.getNext();
		curr.setNext(prev);
		return reverseRecursively(temp, curr);
	}

	public static boolean hasCycle(SinglyNode head) {
		SinglyNode slow = head;
		SinglyNode fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				return true;
			}
		}
		return false;
	}

	public static boolean hasCycleUsingSet(SinglyNode head) {
		Set<SinglyNode> nodeSet = new HashSet<>();
		SinglyNode curr = head;
		while(curr != null){
			if(nodeSet.contains(curr)){
				return true;
			}
			nodeSet.add(curr);
			curr = curr.next;
		}
		return false;
	}

	public static SinglyNode deleteDuplicates(SinglyNode head) {
		if(head == null){
			return head;
		}
		SinglyNode curr = head;
		while(curr != null && curr.next != null){
			if(curr.data == curr.next.data){
				curr.next = curr.next.next;
			}else{
				curr = curr.next;
			}
		}
		return head;
	}

	private static void purgeDuplicateInUnSortedList() {
		Set<Integer> set = new HashSet<>();
		SinglyNode curr = head;
		SinglyNode prev = null;
		while (curr != null) {
			if (set.contains(curr.getData()) && prev != null) {
				prev.setNext(curr.getNext());
			} else {
				set.add(curr.getData());
				prev = curr;
			}
			curr = curr.getNext();
		}
	}

	private static void segregateEvenAndOdd() {
		SinglyNode currNode = head;
		SinglyNode endNode = null;
		while (currNode != null) {
			endNode = currNode;
			currNode = currNode.getNext();
		}
		currNode = head;
		SinglyNode actualEndNode = endNode;
		while (currNode != actualEndNode) {
			if (currNode.getData() % 2 == 1) {
				endNode.setNext(currNode);
				currNode = currNode.getNext();
				endNode = endNode.getNext();
				endNode.setNext(null);
				head = currNode;
			} else {
				break;
			}
		}
		SinglyNode prevNode = null;
		while (currNode != actualEndNode) {
			if (currNode.getData() % 2 == 0) {
				prevNode = currNode;
				currNode = currNode.getNext();
			} else if (prevNode != null) {
				endNode.setNext(currNode);
				prevNode.setNext(currNode.getNext());
				currNode = currNode.getNext();
				endNode = endNode.getNext();
				endNode.setNext(null);
			}
		}

	}
	
	private static SinglyNode oddEvenList(SinglyNode head) {
        if(head == null || head.getNext() == null){
            return head;
        }
        SinglyNode odd = head;
        SinglyNode even = head.getNext();
        SinglyNode evenStart = even;
        while(odd != null && odd.getNext() != null && even != null && even.getNext() != null){
            odd.setNext(odd.getNext().getNext());
            even.setNext(even.getNext().getNext());
            odd = odd.getNext();
            even = even.getNext();
        }
        odd.setNext(evenStart);
        return head;
    }

	private static void segregateEvenAndOdd1() {
		SinglyNode evenStart = null;
		SinglyNode evenEnd = null;
		SinglyNode oddStart = null;
		SinglyNode oddEnd = null;
		for (SinglyNode currNode = head; currNode != null; currNode = currNode.getNext()) {
			if (currNode.getData() % 2 == 0 && (currNode == head || evenStart == null)) {
				evenStart = currNode;
				evenEnd = evenStart;
			} else if (currNode.getData() % 2 == 0 && currNode != head && evenEnd != null) {
				evenEnd.setNext(currNode);
				evenEnd = evenEnd.getNext();
			} else if (currNode.getData() % 2 == 1 && (currNode == head || oddStart == null)) {
				oddStart = currNode;
				oddEnd = oddStart;
			} else if (currNode.getData() % 2 == 1 && currNode != head && oddEnd != null){
				oddEnd.setNext(currNode);
				oddEnd = oddEnd.getNext();
			}
		}
		if (evenEnd != null && oddStart != null) {
			evenEnd.setNext(oddStart);
			oddEnd.setNext(null);
		}else if(evenStart == null) {
			head = oddStart;
			oddEnd.setNext(null);
		}else {
			head = evenStart;
			evenEnd.setNext(null);
		}
		head = evenStart;
	}
	
	private static int intersectPoint(SinglyNode headA, SinglyNode headB) {
	    Set<SinglyNode> set = new HashSet<>();
	    SinglyNode currNode = headA;
        while(currNode != null){
             set.add(currNode);
             currNode = currNode.getNext();
        }
        currNode = headB;
        while(currNode != null){
             if(set.contains(currNode)){
                 return currNode.getData();
             }
             currNode = currNode.getNext();
        }
        return -1;
	}
	
	private static void pairwiseSwap(SinglyNode head) {
		SinglyNode currNode = head;
		SinglyNode temp = null;
		SinglyNode currIncr = null;
		SinglyNode prev = null;
        while(currNode != null && currNode.getNext() != null){
            currIncr = currNode.getNext().getNext();
            temp = currNode.getNext();
        	if(currNode == head){
                head = currNode.getNext();
            }else {
                prev.setNext(temp);
            }
            currNode.setNext(currNode.getNext().getNext());
            temp.setNext(currNode);
            prev = currNode;
            currNode = currIncr;
        }
        SinglyLinkedList.head = head;
    }

	public static void main(String[] args) {
		insertAtBegin(2);
		insertAtBegin(1);
		insertAtEnd(3);
		insertAtEnd(4);
		insertAtEnd(5);
		print();
		System.out.println();
		oddEvenList(head);
		print();
		insertAfterSpecificElement(23, 5);
		insertBeforeSpecificElement(34, 5);
		deleteAtBeg();
		deleteAtEnd();
		deleteAtSpecificElement(5);
		System.out.println("nth node = " + findNthNodeFromLast(3));
		middleNode(head);
		print();
		reverseRecursively(head, null);
		System.out.println();
		System.out.println("cycle = " + hasCycle(head));
		System.out.println("cycle = " + hasCycleUsingSet(head));
		print();
		reverseIteratively();
		insertAtEnd(7);
		insertAtBegin(7);
		insertAtBegin(7);
		deleteDuplicates(head);
		purgeDuplicateInUnSortedList();
		System.out.println();
		print();
		segregateEvenAndOdd();
		segregateEvenAndOdd1();
		System.out.println();
		print();
		System.out.println();
		System.out.println(intersectPoint(head, head));
		pairwiseSwap(head);
		print();
		Partition p = new Partition();
		p.partitionOptimized(head, 3);
		print();
	}

}
