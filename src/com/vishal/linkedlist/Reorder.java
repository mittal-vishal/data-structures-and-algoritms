package com.vishal.linkedlist;

public class Reorder {

    public void reorderList(SinglyNode head) {
        if(head == null || head.next == null){
            return;
        }
        SinglyNode slow = head;
        SinglyNode fast = head;
        SinglyNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        SinglyNode ptr2 = null;

        if(fast != null){
            ptr2 = reverse(slow.next);
            slow.next = null;
        }else{
            ptr2 = reverse(slow);
            prev.next = null;
        }

        SinglyNode ptr1 = head;
        SinglyNode temp1 = null;
        SinglyNode temp2 = null;
        while(ptr1 != null){
            temp1 = ptr1.next;
            ptr1.next = ptr2;
            ptr1 = temp1;
            if(ptr2 != null){
                temp2 = ptr2.next;
                ptr2.next = ptr1;
                ptr2 = temp2;
            }
        }
    }

    private SinglyNode reverse(SinglyNode head){
        SinglyNode curr = head;
        SinglyNode prev = null;
        SinglyNode temp = null;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}
