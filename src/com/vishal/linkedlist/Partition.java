package com.vishal.linkedlist;

public class Partition {

    public SinglyNode partitionOptimized(SinglyNode head, int x) {
        SinglyNode lessS = null;
        SinglyNode lessE = null;
        SinglyNode greaterS = null;
        SinglyNode greaterE = null;

        SinglyNode curr = head;
        while(curr != null){
            if(curr.data < x){
                if(lessS == null){
                    lessS = curr;
                    lessE = lessS;
                }else{
                    lessE.next = curr;
                    lessE = lessE.next;
                }
            }else{
                if(greaterS == null){
                    greaterS = curr;
                    greaterE = greaterS;
                }else{
                    greaterE.next = curr;
                    greaterE = greaterE.next;
                }
            }
        }
        if(lessS == null || greaterS == null){
            return head;
        }
        lessE.next = greaterS;
        greaterE.next = null;
        return lessS;
    }

    public SinglyNode partition(SinglyNode head, int k){
        if(head == null){
            return null;
        }
        SinglyNode curr = head;
        SinglyNode tail = head;
        SinglyNode end = head;
        while(tail.next != null) {
            tail = tail.next;
        }
        end = tail;
        SinglyNode prev = null;
        SinglyNode temp = null;
        boolean  isFirst = true;
        while(curr != end){
            if(curr == tail && end == null){
                break;
            }
            if(curr.data < k) {
                prev = curr;
                curr = curr.next;
            }else{
                if(curr == head){
                    temp = curr.next;
                    tail.next = curr;
                    curr.next = null;
                    curr = temp;
                    head = curr;
                    tail = tail.next;
                }else{
                    prev.next = curr.next;
                    curr.next = null;
                    tail.next = curr;
                    tail = tail.next;
                    curr = prev.next;
                }
            }
            if((curr == end) && isFirst){
                end = end.next;
                isFirst = false;
            }
        }
        return head;
    }
}
