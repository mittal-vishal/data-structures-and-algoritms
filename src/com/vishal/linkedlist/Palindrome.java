package com.vishal.linkedlist;

import java.util.Stack;

public class Palindrome {

    public boolean isPalindromeOptimal(Node head) {
        if(head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        boolean isEven = false;
        if(fast == null){
            isEven = true;
        }

        Node mid = null;

        if(isEven){
            mid = reverse(slow);
        }else{
            mid = reverse(slow.next);
        }

        //Check for palindrome
        Node ptr1 = head;
        Node ptr2 = mid;
        boolean isPalin = true;
        while(ptr1 != slow){
            if(ptr1.data != ptr2.data){
                isPalin = false;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        //Reverse the second half again and combine with first half to make original list
        Node second = reverse(mid);
        if(isEven){
            prev.next = second;
        }else{
            slow.next = second;
        }
        return isPalin;
    }

    private Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        Node temp = null;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

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
