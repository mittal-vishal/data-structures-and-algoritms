package com.vishal.binarysearchtree;

public class MinAbsDiff {

    private int prev;
    private int minAbs;

    public int getMinimumDifference(TreeNode root) {
        prev = -1;
        minAbs = Integer.MAX_VALUE;
        inorder(root);
        return minAbs;
    }

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(prev != -1){
            minAbs = Math.min(minAbs, root.val - prev);
        }
        prev = root.val;
        inorder(root.right);
    }

}
