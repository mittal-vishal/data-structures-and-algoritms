package com.vishal.linkedlist;

public class ReverseKSizedLinkedList {

	public SinglyNode reverseKGroup(SinglyNode head, int k) {
		if(head == null || head.next == null || k == 1){
			return head;
		}
		SinglyNode curr = head;
		SinglyNode prev = head;
		SinglyNode start = null;
		SinglyNode justPrev = null;
		SinglyNode kStart = null;
		SinglyNode temp = null;
		int size = 0;
		while(curr != null){
			curr = curr.next;
			size++;
		}
		curr = head;

		while(curr != null){

			if(size >= k){

				for(int i = 0; i < k; i++){
					temp = curr.next;
					curr.next = justPrev;
					justPrev = curr;
					curr = temp;
				}

				size -= k;

				if(start == null){
					start = justPrev;
				}

				if(kStart != null){
					prev.next = justPrev;
					prev = kStart;
				}
				kStart = curr;
				justPrev = null;
			}else{
				prev.next = curr;
				break;
			}

		}
		return start;
	}

}
