package com.vishal.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class Clone {
	public Node copyList(Node head) {
		Map<Integer, Integer> hashMap = new HashMap<>();
		Node currNode = head;
		Node clonedList = null;
		while (currNode != null) {
			if (currNode.arb != null) {
				hashMap.put(currNode.data, currNode.arb.data);
			}
			currNode = currNode.next;
		}
		currNode = head;
		while (currNode != null) {
			Node node = new Node(currNode.data);
			if (hashMap.containsKey(currNode.data)) {
				Node arbCloned = currNode;
				int arbitCounter = currNode.arb.data - currNode.data;
				while (arbitCounter-- > 0 && arbCloned.next != null) {
					arbCloned = arbCloned.next;
				}
				node.arb = arbCloned;
			} else {
				node.arb = null;
			}
			if (currNode == head) {
				clonedList = node;
				clonedList.next = null;
				head = clonedList;
			} else {
				clonedList.next = node;
				clonedList = node;
			}
			currNode = currNode.next;
		}
		if (clonedList != null) {
			clonedList.next = null;
		}
		return head;
	}
}
