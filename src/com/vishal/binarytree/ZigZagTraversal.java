package com.vishal.binarytree;

import java.util.*;

public class ZigZagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagList = new ArrayList<>();
        if(root == null){
            return zigzagList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> levelList = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                //If level is odd, push all siblings in stack
                TreeNode currNode = queue.poll();
                if(level % 2 == 1){
                    stack.push(currNode);
                }else{
                    levelList.add(currNode.val);
                }
                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
            while(!stack.isEmpty()){
                levelList.add(stack.pop().val);
            }
            zigzagList.add(levelList);
            //reset the level list
            levelList = new ArrayList<>();
            level++;
        }
        return zigzagList;
    }

}
