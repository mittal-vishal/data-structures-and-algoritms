package com.vishal.binarytree;

public class CountGoodNodeInBinaryTree {

    private int goodNodeCount;

    public int goodNodes(TreeNode root) {
        this.goodNodeCount = 0;
        dfs(root, Integer.MIN_VALUE);
        return goodNodeCount;
    }

    private void dfs(TreeNode root, int parent){
        if(root == null){
            return;
        }
        if(root.val >= parent){
            this.goodNodeCount++;
        }
        dfs(root.left, Math.max(root.val, parent));
        dfs(root.right, Math.max(root.val, parent));
    }

}
