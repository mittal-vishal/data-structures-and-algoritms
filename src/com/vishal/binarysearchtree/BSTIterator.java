package com.vishal.binarysearchtree;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addLeftChilds(root);
    }

    private void addLeftChilds(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode top = stack.pop();
        addLeftChilds(top.right);
        return top.val;
    }

    public boolean hasNext() {
        return stack.size() > 0;
    }

}
