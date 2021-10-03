package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

    public static TreeNode findSuccessor(TreeNode root, int key) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isSuccessor = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode polled = queue.poll();
                if(isSuccessor){
                    return polled;
                }
                if(polled.val == key){
                    isSuccessor = true;
                }
                if(polled.left != null){
                    queue.offer(polled.left);
                }
                if(polled.right != null){
                    queue.offer(polled.right);
                }
            }
        }
        return null;
    }

}
