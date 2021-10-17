package com.vishal.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class DeepCloneWithRandomPointer {

    static class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> randomPointerMap = new HashMap<>();
        Node oldCurr = head;
        Node newPrev = null;
        Node newHead = null;
        while(oldCurr != null){
            Node newNode = new Node(oldCurr.val);
            if(newPrev != null){
                newPrev.next = newNode;
            }else{
                newHead = newNode;
            }
            newPrev = newNode;
            randomPointerMap.put(oldCurr, newNode);
            oldCurr = oldCurr.next;
        }
        Node newCurr = newHead;
        oldCurr = head;
        while(oldCurr != null){
            newCurr.random = randomPointerMap.get(oldCurr.random);
            oldCurr = oldCurr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }

}
