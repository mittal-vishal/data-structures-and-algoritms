package com.vishal.linkedlist;

public class SortList {

    public SinglyNode sortList(SinglyNode head) {
        if(head == null || head.next == null){
            return head;
        }
        SinglyNode mid = getMid(head);
        SinglyNode left = sortList(head);
        SinglyNode right = sortList(mid);
        return merge(left, right);
    }

    private SinglyNode getMid(SinglyNode head){
        SinglyNode dummy = new SinglyNode(-1);
        dummy.next = head;
        SinglyNode slow = dummy;
        SinglyNode fast = dummy;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        SinglyNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    private SinglyNode merge(SinglyNode left, SinglyNode right){
        SinglyNode dummy = new SinglyNode(-1);
        SinglyNode tail = dummy;
        while(left != null && right != null){
            if(left.data <= right.data){
                tail.next = left;
                tail = tail.next;
                left = left.next;
            }else{
                tail.next = right;
                tail = tail.next;
                right = right.next;
            }
        }
        tail.next = left != null? left: right;
        return dummy.next;
    }

}
