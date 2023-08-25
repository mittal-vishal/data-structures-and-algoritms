package com.vishal.linkedlist;

import java.util.HashMap;

public class RemoveZeroSumConsecutiveNodes {

    public SinglyNode removeZeroSumSublists(SinglyNode head) {
        int prefixSum = 0;
        HashMap<Integer,SinglyNode> prefixNodes = new HashMap<>();
        SinglyNode dummy = new SinglyNode(0);
        dummy.next = head;
        SinglyNode curr = dummy;
        while(curr != null){
            prefixSum += curr.data;
            prefixNodes.put(prefixSum, curr);
            curr = curr.next;
        }
        curr = dummy;
        prefixSum = 0;
        while(curr != null){
            prefixSum += curr.data;
            if(prefixNodes.containsKey(prefixSum)){
                curr.next = prefixNodes.get(prefixSum).next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

}
