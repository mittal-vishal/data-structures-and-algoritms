package com.vishal.linkedlist;

import java.util.PriorityQueue;

public class MergeKSortedList {

    public SinglyNode mergeKLists(SinglyNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }else if(lists.length == 1){
            return lists[0];
        }else{
            return mergeKLists(lists, 0, lists.length - 1);
        }
    }

    private SinglyNode mergeKLists(SinglyNode[] nodes, int beg, int end) {

        if(beg == end){
            return nodes[beg];
        }else{
            int mid = beg + ((end - beg)/2);
            SinglyNode left = mergeKLists(nodes, beg, mid);
            SinglyNode right = mergeKLists(nodes, mid + 1, end);
            return mergeTwoLists(left, right);
        }

    }

    private SinglyNode mergeTwoLists(SinglyNode l1, SinglyNode l2) {
        SinglyNode start = new SinglyNode(-1);
        SinglyNode curr = start;
        SinglyNode temp = null;
        while(l1 != null || l2 != null){
            if(l1 == null){
                curr.next = l2;
                break;
            }else if(l2 == null){
                curr.next = l1;
                break;
            } else if(l1.data <= l2.data){
                temp = l1.next;
                curr.next = l1;
                curr = curr.next;
                curr.next = null;
                l1 = temp;
            } else{
                temp = l2.next;
                curr.next = l2;
                curr = curr.next;
                curr.next = null;
                l2 = temp;
            }
        }
        return start.next;
    }

    public SinglyNode mergeKListsUsingHeap(SinglyNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<SinglyNode> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                pq.offer(lists[i]);
            }
        }
        SinglyNode curr = null;
        SinglyNode start = null;
        while(!pq.isEmpty()){
            SinglyNode polled = pq.poll();
            if(curr == null){
                curr = polled;
                start = curr;
            }else{
                curr.next = polled;
                curr = curr.next;
            }
            polled = polled.next;
            if(polled != null){
                pq.offer(polled);
            }
        }
        return start;
    }

}
