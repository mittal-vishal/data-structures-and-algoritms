package com.vishal.linkedlist;

public class ReverseFromLeftToRight {

    public SinglyNode reverseBetween(SinglyNode head, int left, int right) {

        if(head == null){
            return head;
        }else if(left == right){
            return head;
        }

        SinglyNode start = null;
        SinglyNode prev = null;
        SinglyNode temp = null;
        SinglyNode kPrev = null;
        SinglyNode curr = head;

        right = right - left + 1;

        while(curr != null && (--left > 0)){
            prev = curr;
            curr = curr.next;
        }

        start = prev;
        prev = null;
        kPrev = curr;

        while(curr != null && (right-- > 0)){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        if(start != null){
            start.next = prev;
        }else{
            head = prev;
        }
        kPrev.next = curr;

        return head;

    }

}
