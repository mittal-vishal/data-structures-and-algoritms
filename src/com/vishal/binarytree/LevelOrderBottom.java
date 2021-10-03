package com.vishal.binarytree;

import java.util.*;

public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> reverseLevelList = new ArrayList<>();
        if(root == null){
            return reverseLevelList;
        }
        List<Integer> levelList = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();

        queue.offer(root);
        queue.offer(null);

        while(!queue.isEmpty()){
            TreeNode polled = queue.poll();
            if(polled == null){
                stack.push(levelList);
                levelList = new LinkedList<>();
                if(queue.size() > 0){
                    queue.offer(null);
                }
            }else{
                levelList.add(polled.val);
                if(polled.left != null){
                    queue.offer(polled.left);
                }
                if(polled.right != null){
                    queue.offer(polled.right);
                }
            }
        }
        while(!stack.isEmpty()){
            reverseLevelList.add(stack.pop());
        }

        return reverseLevelList;
    }

}
