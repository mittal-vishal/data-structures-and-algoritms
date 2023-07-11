package com.vishal.binarytree;

import java.util.HashMap;

public class CloneBinaryTreeWithRandomPointer {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode random;
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
            this.random = null;
        }
    }

    private HashMap<TreeNode, TreeNode> mapping;

    public TreeNode copyRandomBinaryTree(TreeNode root) {
        mapping = new HashMap<>();
        TreeNode cloneRoot = clone(root);
        cloneRandomPointer(root, cloneRoot);
        return cloneRoot;
    }

    private void cloneRandomPointer(TreeNode root, TreeNode cloneRoot){
        if(root == null){
            return;
        }
        cloneRoot.random = mapping.get(root.random);
        cloneRandomPointer(root.left, cloneRoot.left);
        cloneRandomPointer(root.right, cloneRoot.right);
    }

    private TreeNode clone(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode cloneRoot = new TreeNode(root.val);
        mapping.put(root, cloneRoot);
        cloneRoot.left = clone(root.left);
        cloneRoot.right = clone(root.right);
        return cloneRoot;
    }

}
