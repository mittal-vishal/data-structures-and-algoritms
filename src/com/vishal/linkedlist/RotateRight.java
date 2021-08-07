package com.vishal.linkedlist;

public class RotateRight {

    public SinglyNode rotateRight(SinglyNode head, int k) {
        if(head == null || head.next == null || k < 1){
            return head;
        }

        SinglyNode curr = head;
        SinglyNode tail = null;

        int size = 0;

        while(curr != null){
            tail = curr;
            curr = curr.next;
            size++;
        }

        k = k % size;
        curr = head;
        int count = size - k - 1;

        while(curr != null && count-- > 0 ){
            curr = curr.next;
        }

        SinglyNode start = curr.next;
        tail.next = head;
        curr.next = null;
        if(start != null){
            head = start;
        }
        return head;
    }

    public SinglyNode rotateRightBruteForce(SinglyNode head, int k) {
        if(head == null || head.next == null || k < 1){
            return head;
        }

        SinglyNode curr = head;

        int size = 0;

        while(curr != null){
            curr = curr.next;
            size++;
        }

        k = k % size;
        curr = head;

        while(k-- > 0){
            SinglyNode prev = null;

            while(curr != null && curr.next != null){
                prev = curr;
                curr = curr.next;
            }

            prev.next = null;
            curr.next = head;
            head = curr;
            curr = head;
        }
        return head;
    }

}
