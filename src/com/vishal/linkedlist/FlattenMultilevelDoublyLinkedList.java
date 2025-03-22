package com.vishal.linkedlist;

public class FlattenMultilevelDoublyLinkedList {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
        public Node(int val, Node prev, Node next, Node child){
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }

    public Node flatten(Node head) {
        if(head == null){
            return null;
        }
        Node dummy = new Node(-1, null, head, null);
        dfs(dummy, head);
        dummy.next.prev = null;
        Node flattenedHead = dummy.next;
        dummy.next = null;
        return flattenedHead;
    }

    private Node dfs(Node prev, Node curr){
        if(curr == null){
            return prev;
        }
        prev.next = curr;
        curr.prev = prev;
        Node temp = curr.next;
        Node tail = dfs(curr, curr.child);
        curr.child = null;
        return dfs(tail, temp);
    }

}
