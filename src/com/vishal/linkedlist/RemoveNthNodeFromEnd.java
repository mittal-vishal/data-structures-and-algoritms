package com.vishal.linkedlist;

public class RemoveNthNodeFromEnd {

    public SinglyNode removeNthFromEnd(SinglyNode head, int n) {
        SinglyNode slow = head;
        SinglyNode fast = head;
        SinglyNode prev = null;

        while(slow != null && --n > 0){
            slow = slow.next;
        }

        while(slow != null && slow.next != null){
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }

        if(prev != null){
            prev.next = fast.next;
        }else{
            head = head.next;
        }

        return head;
    }

}
