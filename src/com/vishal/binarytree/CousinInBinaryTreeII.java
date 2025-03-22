package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CousinInBinaryTreeII {

    public TreeNode replaceValueInTree(TreeNode root) {
        ArrayList<Integer> levelSum = new ArrayList<>();
        //get level sum
        getLevelSum(levelSum, root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                TreeNode curr = queue.poll();
                int childSum = 0;
                if(curr.left != null){
                    childSum += curr.left.val;
                }
                if(curr.right != null){
                    childSum += curr.right.val;
                }
                if(level+1 >= levelSum.size()){
                    continue;
                }
                int siblingSum = levelSum.get(level+1) - childSum;
                if(curr.left != null){
                    curr.left.val = siblingSum;
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    curr.right.val = siblingSum;
                    queue.offer(curr.right);
                }
            }
            level++;
        }
        root.val = 0;
        return root;
    }

    private void getLevelSum(ArrayList<Integer> levelSum, TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            int sum = 0;
            for(int i = 0; i < queueSize; i++){
                TreeNode curr = queue.poll();
                sum += curr.val;
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            levelSum.add(sum);
        }
    }

}
