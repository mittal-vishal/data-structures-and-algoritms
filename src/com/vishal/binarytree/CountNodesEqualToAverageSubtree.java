package com.vishal.binarytree;

public class CountNodesEqualToAverageSubtree {

    static class Node{
        int numOfNodes;
        int totalSum;
        public Node(int numOfNodes, int totalSum){
            this.numOfNodes = numOfNodes;
            this.totalSum = totalSum;
        }
    }

    private int result;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return result;
    }

    private Node dfs(TreeNode root){
        if(root == null){
            return new Node(0, 0);
        }
        Node leftNode = dfs(root.left);
        Node rightNode = dfs(root.right);
        int sum = leftNode.totalSum + rightNode.totalSum + root.val;
        int totalNodes = leftNode.numOfNodes + rightNode.numOfNodes + 1;
        if(root.val == (sum/totalNodes)){
            result++;
        }
        return new Node(totalNodes, sum);
    }

}
