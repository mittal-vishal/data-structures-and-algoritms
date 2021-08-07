package com.vishal.linkedlist;

public class RotateRight {

    public SinglyNode rotateRight(SinglyNode head, int k) {
        if(head == null || head.next == null){
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

        if(k == 0){
            return head;
        }

        int count = size - k - 1;

        curr = head;
        while(count-- > 0 && curr != null){
            curr = curr.next;
        }

        SinglyNode kStart = curr.next;

        curr.next = null;

        tail.next = head;
        head = kStart;

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
