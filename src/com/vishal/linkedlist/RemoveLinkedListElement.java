package com.vishal.linkedlist;

public class RemoveLinkedListElement {

    public SinglyNode removeElements(SinglyNode head, int val) {
        SinglyNode prev = null;
        SinglyNode curr = head;
        while(curr != null){
            boolean isDeleted = false;
            if(curr.data == val){
                if(prev != null){
                    prev.next = curr.next;
                    curr = curr.next;
                }else{
                    SinglyNode temp = curr;
                    curr = curr.next;
                    temp.next = null;
                    head = curr;
                }
                isDeleted = true;
            }
            if(!isDeleted){
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

}
