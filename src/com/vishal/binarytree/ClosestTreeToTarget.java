package com.vishal.binarytree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ClosestTreeToTarget {

    private HashMap<TreeNode,TreeNode> nodeParent;
    private TreeNode src;
    private Integer targetValue;
    private HashSet<TreeNode> visited;
    private Queue<TreeNode> queue;

    public int findClosestLeaf(TreeNode root, int k) {
        nodeParent = new HashMap<>();
        targetValue = k;
        dfs(root, null);
        queue = new LinkedList<>();
        queue.offer(src);
        visited = new HashSet<>();
        visited.add(src);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null){
                continue;
            }
            if(curr.left == null && curr.right == null){
                return curr.val;
            }
            addInQueue(curr.left);
            addInQueue(curr.right);
            TreeNode parent = nodeParent.get(curr);
            addInQueue(parent);
        }
        return -1;
    }

    private void addInQueue(TreeNode node){
        if(node != null && !visited.contains(node)){
            visited.add(node);
            queue.offer(node);
        }
    }

    private void dfs(TreeNode node, TreeNode parent){
        if(node == null){
            return;
        }
        nodeParent.put(node, parent);
        if(node.val == targetValue){
            src = node;
        }
        dfs(node.left, node);
        dfs(node.right, node);
    }

}
