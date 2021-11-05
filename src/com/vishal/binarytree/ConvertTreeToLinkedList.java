package com.vishal.binarytree;

public class ConvertTreeToLinkedList {

    private TreeNode prev;

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

}
