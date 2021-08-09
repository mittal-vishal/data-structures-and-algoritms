package com.vishal.linkedlist;

public class MergeSortedList {

    public SinglyNode mergeTwoLists(SinglyNode l1, SinglyNode l2) {
        SinglyNode start = new SinglyNode(-1);
        SinglyNode curr = start;
        SinglyNode temp = null;
        while(l1 != null || l2 != null){
            if(l1 == null){
                curr.next = l2;
                break;
            }else if(l2 == null){
                curr.next = l1;
                break;
            } else if(l1.data <= l2.data){
                temp = l1.next;
                curr.next = l1;
                curr = curr.next;
                curr.next = null;
                l1 = temp;
            } else{
                temp = l2.next;
                curr.next = l2;
                curr = curr.next;
                curr.next = null;
                l2 = temp;
            }
        }
        return start.next;
    }

}
