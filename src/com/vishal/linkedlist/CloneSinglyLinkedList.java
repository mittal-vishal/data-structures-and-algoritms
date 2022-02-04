package com.vishal.linkedlist;

public class CloneSinglyLinkedList {

    static class ListNode{
        int data;
        ListNode next;
        public ListNode(int data){
            this.data = data;
        }
    }

    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        System.out.println("This is a debug message");
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        head.next = second;
        second.next = third;
        ListNode cloned = clone(head);
        while(cloned != null){
            System.out.print(cloned.data + "->");
            cloned = cloned.next;
        }
    }

    public static ListNode clone(ListNode node){
        if(node == null){
            return null;
        }
        ListNode curr = node;
        ListNode head = null;
        ListNode clonedCurr = null;
        ListNode prev = null;
        while(curr != null){
            clonedCurr = new ListNode(curr.data);
            if(prev == null){
                head = clonedCurr;
            }else{
                //Create linking between cloned nodes
                prev.next = clonedCurr;
            }
            prev = clonedCurr;
            curr = curr.next;
        }
        return head;
    }
}