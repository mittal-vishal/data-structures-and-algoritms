package com.vishal.linkedlist;

public class DeleteDuplicates {

    public SinglyNode deleteDuplicates(SinglyNode head) {
        if(head == null || head.next == null){
            return head;
        }
        SinglyNode curr = head;
        SinglyNode prev = null;
        SinglyNode start = null;
        SinglyNode justPrev = null;
        while(curr != null){
            if(curr.next != null && curr.data != curr.next.data && (justPrev == null ? true: justPrev.data != curr.data)){
                if(start == null){
                    start = curr;
                }else{
                    prev.next = curr;
                }
                prev = curr;
                justPrev = curr;
                curr = curr.next;
            }else if(curr.next != null && (curr.data == curr.next.data || (justPrev == null ? false: justPrev.data == curr.data))){
                justPrev = curr;
                curr = curr.next;
            }else if(curr.next == null && justPrev == null ? true: justPrev.data != curr.data){
                if(prev != null){
                    prev.next = curr;
                }else if(start == null){
                    start = curr;
                }
                prev = curr;
                curr = curr.next;
            }else{
                curr = curr.next;
            }
        }
        if(prev != null)
            prev.next = null;
        return start;
    }

}
