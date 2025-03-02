package com.vishal.binarytree;

public class SecondMinNode {

    private long min;
    private long result;
    public int findSecondMinimumValue(TreeNode root) {
        min = Long.MAX_VALUE;
        result = min;
        dfs(root);
        if(result == Long.MAX_VALUE){
            return -1;
        }else{
            return (int)result;
        }
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        if(root.val < min){
            result = min;
            min = root.val;
        }else if(root.val < result && root.val != min){
            result = root.val;
        }
        dfs(root.left);
        dfs(root.right);
    }

}
