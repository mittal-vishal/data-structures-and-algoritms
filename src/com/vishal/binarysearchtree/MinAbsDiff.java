package com.vishal.binarysearchtree;

public class MinAbsDiff {

    private int ans;
    private Integer prev;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        if(prev != null){
            ans = Math.min(ans, root.val - prev);
        }
        prev = root.val;
        dfs(root.right);
    }

}
