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
        SinglyNode itr = head;
        SinglyNode tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }
        SinglyNode end = tail;
        SinglyNode prev = null;
        SinglyNode temp = null;
        boolean  isFirst = true;
        while(itr != end){
            if(itr.data >= k) {
                if (itr == head) {
                    head = head.next;
                } else {
                    prev.next = itr.next;
                }
                temp = itr;
                tail.next = temp;
                itr = itr.next;
                temp.next = null;
                tail = temp;
            }else{
                prev = itr;
                itr = itr.next;
            }
            if((itr == end) && isFirst){
                end = itr.next;
                isFirst = false;
            }
        }
        return head;
    }
}
