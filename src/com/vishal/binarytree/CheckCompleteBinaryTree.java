package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompleteBinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return true;
        }
        queue.offer(root);
        boolean isNullNodeSeen = false;
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null){
                isNullNodeSeen = true;
            }else{
                if(isNullNodeSeen){
                    return false;
                }
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        return true;
    }

}
