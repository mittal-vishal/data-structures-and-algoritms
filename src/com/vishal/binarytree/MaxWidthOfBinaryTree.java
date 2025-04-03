package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree {

    static class Node{
        TreeNode treeNode;
        int num;
        int level;
        public Node(TreeNode treeNode, int num, int level){
            this.treeNode = treeNode;
            this.num = num;
            this.level = level;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 1, 0));
        int prevLevel = 0;
        int result = 0;
        int firstLevelNodeNum = 1;
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr.level > prevLevel){
                prevLevel = curr.level;
                firstLevelNodeNum = curr.num;
            }
            result = Math.max(result, curr.num-firstLevelNodeNum+1);
            if(curr.treeNode.left != null){
                queue.offer(new Node(curr.treeNode.left, 2*curr.num, curr.level+1));
            }
            if(curr.treeNode.right != null){
                queue.offer(new Node(curr.treeNode.right, 2*curr.num+1, curr.level+1));
            }
        }
        return result;
    }

}
