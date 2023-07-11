package com.vishal.binarysearchtree;

public class LargestBSTSubtree {

    static class NodeValue{
        int max;
        int min;
        int size;
        public NodeValue(int max, int min, int size){
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }
    public int largestBSTSubtree(TreeNode root) {
        if(root == null){
            return 0;
        }
        return dfs(root).size;
    }

    private NodeValue dfs(TreeNode root){
        if(root == null){
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        NodeValue leftNodeVal = dfs(root.left);
        NodeValue rightNodeVal = dfs(root.right);
        //check for valid BST
        if(root.val > leftNodeVal.max && root.val < rightNodeVal.min){
            int max = Math.max(root.val, rightNodeVal.max);
            int min = Math.min(root.val, leftNodeVal.min);
            int size = leftNodeVal.size + rightNodeVal.size + 1;
            return new NodeValue(max, min, size);
        }else{
            //INF for left and -INF for right
            int size = Math.max(leftNodeVal.size, rightNodeVal.size);
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, size);
        }
    }

}
