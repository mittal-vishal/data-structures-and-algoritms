package com.vishal.linkedlist;

public class ReverseKSizedLinkedList {

	public SinglyNode reverseKGroup(SinglyNode head, int k) {
		SinglyNode curr = head;
		SinglyNode start = null;
		SinglyNode kStart = curr;
		SinglyNode kPrev = curr;
		SinglyNode temp = null;
		int size = 0;
		while(curr != null){
			size++;
			curr = curr.next;
		}
		curr = head;
		size = size - (size % k);
		for(int i = 0; i < size;){
			SinglyNode prev = null;
			for(int j = 0; j < k; j++){
				//reverse K nodes
				temp = curr.next;
				curr.next = prev;
				prev = curr;
				curr = temp;
			}
			if(start == null){
				start = prev;
			}else{
				kPrev.next = prev;
				kPrev = kStart;
			}
			kStart = curr;
			i += k;
		}
		if(kPrev != null){
			kPrev.next = curr;
		}
		return start;
	}

}
