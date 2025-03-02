package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestBinaryTreeValueII {

    private PriorityQueue<Integer> minHeap;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        minHeap = new PriorityQueue<>((a,b) -> {
            if(Math.abs(b-target) > Math.abs(a-target)){
                return 1;
            }else{
                return -1;
            }
        });
        dfs(root,k);
        return new ArrayList<>(minHeap);
    }

    private void dfs(TreeNode root, int k){
        if(root == null){
            return;
        }
        minHeap.offer(root.val);
        if(minHeap.size() > k){
            minHeap.poll();
        }
        dfs(root.left, k);
        dfs(root.right, k);
    }

}
