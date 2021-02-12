package com.vishal.linkedlist;

public class MergeSortedList {

    public SinglyNode mergeTwoLists(SinglyNode l1, SinglyNode l2) {
        SinglyNode head = null;
        SinglyNode start = null;
        if(l1 == null && l2 == null){
            return null;
        }
        while(l1 != null && l2 != null){
            if(l1.data <= l2.data){
                if(head == null){
                    head = l1;
                    start = l1;
                    l1 = l1.next;
                }else{
                    head.next = l1;
                    head = l1;
                    l1 = l1.next;
                }
            }else{
                if(head == null){
                    head = l2;
                    start = l2;
                    l2 = l2.next;
                }else{
                    head.next = l2;
                    head = l2;
                    l2 = l2.next;
                }
            }
        }
        if(l1 != null && head != null){
            head.next = l1;
        }else if(l1 != null && head == null){
            head = l1;
            start = head;
        }else if(l2 != null && head != null){
            head.next = l2;
        }else{
            head = l2;
            start = head;
        }
        return start;
    }

}
