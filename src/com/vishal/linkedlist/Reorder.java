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

    public void reorderList1(SinglyNode head) {
        if(head == null || head.next == null){
            return;
        }
        int size = 0;
        SinglyNode curr = head;
        while(curr != null){
            curr = curr.next;
            size++;
        }
        if(size % 2 == 0){
            size = size / 2;
        }else{
            size = (size / 2) + 1;
        }
        SinglyNode dummy = new SinglyNode(0);
        dummy.next = head;
        curr = dummy;
        while(curr != null && size-- > 0){
            curr = curr.next;
        }
        SinglyNode start2 = curr.next;
        curr.next = null;
        start2 = reverse(start2);
        SinglyNode start1 = dummy.next;
        SinglyNode temp1 = null;
        SinglyNode temp2 = null;
        while(start1 != null && start2 != null){
            temp1 = start1.next;
            start1.next = start2;
            temp2 = start2.next;
            start2.next = temp1;
            start1 = temp1;
            start2 = temp2;
        }
    }

    private SinglyNode reverse1(SinglyNode head){
        if(head == null || head.next == null){
            return head;
        }
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
