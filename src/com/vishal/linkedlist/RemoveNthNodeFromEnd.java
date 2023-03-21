package com.vishal.linkedlist;

public class RemoveNthNodeFromEnd {

    public SinglyNode removeNthFromEnd(SinglyNode head, int n) {
        SinglyNode dummy = new SinglyNode(0);
        dummy.next = head;
        SinglyNode first = dummy;
        SinglyNode second = dummy;
        while(n-- > 0 && first != null){
            first = first.next;
        }
        while(first != null && first.next != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public SinglyNode removeNthFromEnd1(SinglyNode head, int n) {
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
