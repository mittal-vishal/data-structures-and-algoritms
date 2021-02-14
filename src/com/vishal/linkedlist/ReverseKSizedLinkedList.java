package com.vishal.linkedlist;

public class ReverseKSizedLinkedList {

	public static SinglyNode reverseKGroup(SinglyNode head, int k) {

		if(head == null){
			return null;
		}

		SinglyNode curr = head;
		SinglyNode prev = null;
		SinglyNode sStart = null;
		SinglyNode start = null;
		SinglyNode prevPrev = head;
		SinglyNode temp = null;
		SinglyNode kNode = head;

		while(curr != null && kNode != null){

			for(int i = 0; i < k-1; i++){
				if(kNode == null){
					break;
				}else{
					kNode = kNode.next;
				}
			}

			if(kNode != null){
				for(int i = 0; i < k; i++){
					temp = curr.next;
					curr.next = prev;
					prev = curr;
					curr = temp;
				}

				if(sStart == null){
					sStart = prev;
				}else{
					prevPrev.next = prev;
					prevPrev = start;
				}
				prev = null;
				start = curr;
				kNode = curr;
			}else{
				prevPrev.next = start;
			}

		}

		return sStart;

	}

}
