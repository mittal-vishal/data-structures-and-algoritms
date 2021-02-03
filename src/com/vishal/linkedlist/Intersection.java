package com.vishal.linkedlist;

public class Intersection {

    public Node getIntersectionNode(Node headA, Node headB) {

        if(headA == null || headB == null){
            return null;
        }

        int l1 = 0;
        int l2 = 0;
        Node itr1 = headA;
        Node itr2 = headB;

        while(itr1.next != null){
            itr1 = itr1.next;
            l1++;
        }

        while(itr2.next != null){
            itr2 = itr2.next;
            l2++;
        }

        if(itr1 != itr2){
            return null;
        }

        if(l1 > l2){
            itr1 = skipInititalNodes(headA, l1-l2);
            itr2 = headB;
        }else if(l2 > l1){
            itr2 = skipInititalNodes(headB, l2-l1);
            itr1 = headA;
        }else{
            itr1 = headA;
            itr2 = headB;
        }

        while(itr1 != null){
            if(itr1 == itr2){
                return itr1;
            }
            itr1 = itr1.next;
            itr2 = itr2.next;
        }
        return null;
    }

    private Node skipInititalNodes(Node node, int l){
        while(l-- > 0){
            node = node.next;
        }
        return node;
    }

}
