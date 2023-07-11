package com.vishal.binarytree;

import com.vishal.binarytree.TreeNode;

public class ConstructBSTTreeSortedLL {

    static class ListNode {
        int val;
        ListNode next;
    }

    public com.vishal.binarytree.TreeNode sortedListToBST(ListNode head) {
        return constructTree(head);
    }

    private com.vishal.binarytree.TreeNode constructTree(ListNode head){
        if(head == null){
            return null;
        }
        ListNode mid = getMid(head);
        com.vishal.binarytree.TreeNode currNode = new TreeNode(mid.val);
        if(mid == head){
            return currNode;
        }
        currNode.left = constructTree(head);
        currNode.right = constructTree(mid.next);
        return currNode;
    }

    private ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev != null){
            prev.next = null;
        }
        return slow;
    }

}
