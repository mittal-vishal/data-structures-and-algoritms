package com.vishal.linkedlist;

public class ReverseKSizedLinkedList {

	public static Node reverse(Node head, int k) {
		Node prev1 = null, prev2 = null, temp = null, start = null;
		Node curr = head;
		while (curr != null) {
			for (int i = 0; i < k; i++) {
				if (curr != null) {
					temp = curr.next;
					curr.next = prev2;
					prev2 = curr;
					curr = temp;
				}
			}
			if (prev1 == null) {
				start = prev2;
			} else {
				prev1.next = prev2;
			}
			prev1 = head;
			prev2 = null;
			head = curr;
		}
		return start;
	}

}
