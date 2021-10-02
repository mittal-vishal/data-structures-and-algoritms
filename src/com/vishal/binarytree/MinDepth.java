package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {

    public int minDepth(TreeNode root) {
        int minDepth = 0;
        if(root == null){
            return minDepth;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            minDepth++;
            int k = queue.size();
            for(int i = 0; i < k; i++){
                TreeNode polled = queue.poll();
                if(polled.left == null && polled.right == null){
                    return minDepth;
                }
                if(polled.left != null){
                    queue.offer(polled.left);
                }
                if(polled.right != null){
                    queue.offer(polled.right);
                }
            }
        }
        return minDepth;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left != 0 && right != 0){
            return 1 + Math.min(left, right);
        }else{
            return left != 0 ? 1 + left : 1 + right;
        }
    }

}
