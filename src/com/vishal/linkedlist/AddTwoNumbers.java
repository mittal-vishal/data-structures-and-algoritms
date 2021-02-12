package com.vishal.linkedlist;

public class AddTwoNumbers {

    public SinglyNode addTwoNumbers(SinglyNode l1, SinglyNode l2) {
        SinglyNode head = null;
        SinglyNode start = null;
        int carry = 0;
        int sum = 0;
        int data1 = 0;
        int data2 = 0;

        if(l1 == null || l2 == null){
            return null;
        }

        while(l1 != null || l2 != null){
            data1 = l1 != null ? l1.data : 0;
            data2 = l2 != null ? l2.data : 0;
            sum = (data1 + data2 + carry) % 10;
            carry = (data1 + data2 + carry) / 10;
            if(head == null){
                head = new SinglyNode(sum);
                start = head;
            }else{
                head.next = new SinglyNode(sum);
                head = head.next;
            }
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }

        if(carry > 0){
            head.next = new SinglyNode(carry);
        }

        return start;

    }

}
