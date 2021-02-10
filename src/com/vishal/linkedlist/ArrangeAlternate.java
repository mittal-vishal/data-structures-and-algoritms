package com.vishal.linkedlist;

public class ArrangeAlternate {

    public SinglyNode arrange(SinglyNode head){
        SinglyNode slow = head;
        SinglyNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null){
            slow = slow.next;
        }

        SinglyNode first = head;
        SinglyNode second = slow;
        SinglyNode tempF = null;
        SinglyNode tempS = null;

        while(second != null){
            tempF = first.next;
            tempS = second.next;
            first.next = second;
            if(tempS == null && tempF != slow){
                second.next = tempF;
                tempF.next = null;
            }else if(tempS != null){
                second.next = tempF;
            }
            first = tempF;
            second = tempS;
        }

        return head;

    }

}
