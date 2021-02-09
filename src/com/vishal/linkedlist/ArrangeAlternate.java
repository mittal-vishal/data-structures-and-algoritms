package com.vishal.linkedlist;

public class ArrangeAlternate {

    public SinglyNode arrange(SinglyNode head){
        SinglyNode slow = head;
        SinglyNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        SinglyNode oddE = head;
        SinglyNode evenE = slow;
        SinglyNode tempO = null;
        SinglyNode tempE = null;

        while(evenE != null){
            tempO = oddE.next;
            tempE = evenE.next;
            oddE.next = evenE;
            if(tempE != null){
                evenE.next = tempO;
            }
            oddE = tempO;
            evenE = tempE;
        }

        return head;

    }

}
