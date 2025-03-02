package com.vishal.linkedlist;

public class Intersection {

    public Node getIntersectionNode(Node headA, Node headB) {
        int lengthA = 0;
        Node curr = headA;
        while(curr != null){
            curr = curr.next;
            lengthA++;
        }
        curr = headB;
        int lengthB = 0;
        while(curr != null){
            curr = curr.next;
            lengthB++;
        }
        if(lengthA > lengthB){
            int diff = lengthA - lengthB;
            while(headA != null && diff > 0){
                headA = headA.next;
                diff--;
            }
        }else if(lengthB > lengthA){
            int diff = lengthB - lengthA;
            while(headB != null && diff > 0){
                headB = headB.next;
                diff--;
            }
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

}
