package com.vishal.binarytree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TwoSum {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode polledNode = queue.poll();
            if(set.contains(k - polledNode.val)){
                return true;
            }
            set.add(polledNode.val);
            if(polledNode.left != null)
                queue.add(polledNode.left);
            if(polledNode.right != null)
                queue.add(polledNode.right);
        }
        return false;
    }

    public boolean findTargetDFS(TreeNode root, int k) {
        Set<Integer> pair = new HashSet<>();
        return dfs(root, k, pair);
    }

    private boolean dfs(TreeNode root, int k, Set<Integer> pair){
        if(root == null){
            return false;
        }else if(pair.contains(k - root.val)){
            return true;
        }
        pair.add(root.val);
        return dfs(root.left, k, pair) || dfs(root.right, k, pair);
    }
}
