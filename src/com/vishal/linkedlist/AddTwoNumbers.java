package com.vishal.linkedlist;

public class AddTwoNumbers {

    public SinglyNode addTwoNumbers(SinglyNode l1, SinglyNode l2) {
        if(l1 == null || l2 == null){
            return null;
        }
        int carry = 0;
        SinglyNode temp = null;
        SinglyNode curr = null;
        SinglyNode start = null;
        while(l1 != null || l2 != null){
            int valA = l1 != null ? l1.data: 0;
            int valB = l2 != null ? l2.data: 0;
            int sum = (valA + valB + carry) % 10;
            carry = (valA + valB + carry)/10;
            if(curr == null){
                curr = new SinglyNode(sum);
                start = curr;
            }else{
                curr.next = new SinglyNode(sum);
                curr = curr.next;
            }
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            curr.next = new SinglyNode(carry);
        }
        return start;
    }

}
