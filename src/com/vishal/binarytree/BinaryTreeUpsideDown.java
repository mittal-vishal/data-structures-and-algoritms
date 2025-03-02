package com.vishal.binarytree;

public class BinaryTreeUpsideDown {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null && root.right == null){
            return root;
        }
        TreeNode left = upsideDownBinaryTree(root.left);
        root.left.right = root;
        root.left.left = root.right;
        root.left = null;
        root.right = null;
        return left;
    }

}
