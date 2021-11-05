package com.vishal.binarysearchtree;

public class RangeSumBST {

    private int range;

    public int rangeSumBST(TreeNode root, int low, int high) {
        range = 0;
        if(root == null){
            return 0;
        }
        inorder(root, low, high);
        return range;
    }

    private void inorder(TreeNode root, int low, int high){
        if(root == null){
            return;
        }
        inorder(root.left, low, high);
        if(root.val >= low && root.val <= high){
            range += root.val;
        }
        inorder(root.right, low, high);
    }

}
