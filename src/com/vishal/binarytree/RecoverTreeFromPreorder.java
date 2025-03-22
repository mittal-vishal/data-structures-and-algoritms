package com.vishal.binarytree;

import java.util.Stack;

public class RecoverTreeFromPreorder {

    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        int n = traversal.length();
        TreeNode root = null;
        while(i < n){
            int depth = 0;
            while(i < n && traversal.charAt(i) == '-'){
                depth++;
                i++;
            }
            int value = 0;
            while(i < n && Character.isDigit(traversal.charAt(i))){
                value = (10 * value) + traversal.charAt(i)-'0';
                i++;
            }
            TreeNode node = new TreeNode(value);
            while(stack.size() > depth){
                stack.pop();
            }
            if(stack.isEmpty()){
                root = node;
            }else if(stack.peek().left == null){
                stack.peek().left = node;
            }else{
                stack.peek().right = node;
            }
            stack.push(node);
        }
        return root;
    }

}
