package com.vishal.linkedlist;

public class FirstNodeOfCycle {

    public SinglyNode detectCycle(SinglyNode head) {

        if(head == null || head.next == null){
            return null;
        }

        SinglyNode curr = head;

        SinglyNode slow = head;
        SinglyNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }

        if(slow != fast){
            return null;
        }

        while(curr != null && slow != null && curr != slow){
            curr = curr.next;
            slow = slow.next;
        }

        return curr;
    }

}
