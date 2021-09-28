package com.vishal.binarytree;

import java.util.*;

public class ZigZagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        List<Integer> levelList = new ArrayList<>();

        if(root == null){
            return zigzagList;
        }

        queue.offer(root);
        queue.offer(null);

        int level = 0;

        while(!queue.isEmpty()){
            TreeNode polled = queue.poll();
            if(polled == null){
                if(level % 2 == 1){
                    while(!stack.isEmpty()){
                        levelList.add(stack.pop());
                    }
                }
                zigzagList.add(levelList);
                levelList = new ArrayList<>();
                level++;
                if(queue.size() > 0){
                    queue.offer(null);
                }
            }else{
                //If even level, dispay as normal
                if(level % 2 == 0){
                    levelList.add(polled.data);
                }else{
                    //If odd level, reverse the order using stack
                    stack.push(polled.data);
                }
                if(polled.left != null){
                    queue.offer(polled.left);
                }
                if(polled.right != null){
                    queue.offer(polled.right);
                }
            }
        }

        return zigzagList;
    }

}
