package com.vishal.google;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeKLists {

    class Node{
        int val;
        int listsIdx;
        int listIdx;
        public Node(int val, int listsIdx, int listIdx){
            this.val = val;
            this.listsIdx = listsIdx;
            this.listIdx = listIdx;
        }
    }

    class Solution {
        public int[] smallestRange(List<List<Integer>> nums) {
            PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.val-b.val);
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < nums.size(); i++){
                minHeap.offer(new Node(nums.get(i).get(0), i, 0));
                max = Math.max(max, nums.get(i).get(0));
            }
            int[] range = new int[2];
            int minRange = Integer.MAX_VALUE;
            while(minHeap.size() == nums.size()){
                Node leastNode = minHeap.poll();
                if((max - leastNode.val) < minRange){
                    minRange = max - leastNode.val;
                    range[0] = leastNode.val;
                    range[1] = max;
                }
                if((leastNode.listIdx + 1) < nums.get(leastNode.listsIdx).size()){
                    minHeap.offer(new Node(nums.get(leastNode.listsIdx).get(leastNode.listIdx + 1),
                            leastNode.listsIdx, leastNode.listIdx + 1));
                    max = Math.max(max, nums.get(leastNode.listsIdx).get(leastNode.listIdx + 1));
                }
            }
            return range;
        }
    }

}
