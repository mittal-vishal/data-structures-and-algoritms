package com.vishal.linkedlist;

import java.util.Stack;

public class Palindrome {

    public boolean isPalindrome(Node head) {

        if(head == null){
            return true;
        }

        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            if(fast != null){
                slow = slow.next;
            }
        }

        if(fast == null){
            slow = slow.next;
            fast = slow;
        }else{
            fast = slow.next;
        }

        Node start = head;

        Stack<Node> stack = new Stack<>();

        while(start != slow){
            stack.push(start);
            start = start.next;
        }

        Node polledNode = null;

        while(!stack.isEmpty() && (fast != null)){
            polledNode = stack.pop();
            if(polledNode.data != fast.data){
                return false;
            }
            fast = fast.next;
        }

        return true;

    }

}
