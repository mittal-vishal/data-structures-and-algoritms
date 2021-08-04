package com.vishal.linkedlist;

public class ReverseFromLeftToRight {

    public SinglyNode reverseBetween(SinglyNode head, int left, int right) {
        if(left >= right || head == null || head.next == null){
            return head;
        }
        SinglyNode curr = head;
        SinglyNode prev = null;

        right = right - left + 1;
        while(--left > 0){
            prev = curr;
            curr = curr.next;
        }

        SinglyNode justPrev = null;
        SinglyNode temp = null;
        SinglyNode start = null;

        while(right-- > 0){
            temp = curr.next;
            curr.next = justPrev;
            if(justPrev == null){
                justPrev = curr;
                start = justPrev;
            }else{
                justPrev = curr;
            }
            curr = temp;
        }

        if(prev != null){
            prev.next = justPrev;
        }else{
            head = justPrev;
        }
        start.next = curr;
        return head;
    }

}
